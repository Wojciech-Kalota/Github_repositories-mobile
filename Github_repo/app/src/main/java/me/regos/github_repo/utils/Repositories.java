package me.regos.github_repo.utils;

import android.app.Application;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Repositories
{

    public static List<String> downloadAllRepos(String username) {
        var result = new ArrayList<String>();

        String next = null;
        try {
            next = "https://api.github.com/users/" + URLEncoder.encode(username, "UTF-8") + "/repos?page=1";

            while (true) {

                BufferedReader reader;
                String line;
                StringBuilder responseContent = new StringBuilder();


                URL url = new URL(next);
                HttpURLConnection connection;
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() != 200)
                    //Toast.makeText(, "User not found", Toast.LENGTH_LONG).show();
                    break;

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();

                result.add(responseContent.toString());


                var linkHeader = connection.getHeaderField("Link");

                if (linkHeader == null)
                    break;

                boolean nextFound = false;
                for (String i : linkHeader.split(",")) { // next,last
                    var parts = i.split(";"); // <uri>; rel=next
                    if (parts[1].contains("next")) {
                        var tmp = parts[0].trim();
                        next = tmp.substring(1, tmp.length() - 1); // <>
                        nextFound = true;
                        break;
                    }
                }

                if (!nextFound)
                    break;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Stream<Repo> getAllRepos(String username){
        var gson = new Gson();

        return downloadAllRepos(username)
                .stream()
                .map(page -> gson.fromJson(page, Repo[].class))
                .flatMap(Arrays::stream);
    }

    public static class Repo {
        public String name;

        @Override
        public String toString() {
            return "Repo{" +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}



