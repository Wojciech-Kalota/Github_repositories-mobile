package me.regos.github_repo.utils;

import android.util.Log;
import android.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Languages {
    public static List<Pair<String, String>> getAllLanguages(String username, String repo) throws IOException, InterruptedException {
        List<Pair<String, String>> result = new ArrayList<>();


        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();


        URL url = new URL("https://api.github.com/repos/" + URLEncoder.encode(username, "UTF-8") + "/" + URLEncoder.encode(repo, "UTF-8") + "/languages");
        HttpURLConnection connection;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = reader.readLine()) != null) {
            responseContent.append(line);
        }
        reader.close();

        String response = responseContent.toString();

        response = response.replaceAll("\"", "");
        response = response.substring(1, response.length()-1);

        for(String tmp : response.split(",")){
            var parts = tmp.split(":");
            result.add(new Pair<>(parts[0], parts[1]));
        }

        return result;

    }
}
