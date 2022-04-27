package me.regos.github_repo.utils;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import java.io.IOException;
import java.util.List;

import me.regos.github_repo.utils.Repositories;

public class AssignTaskLanguages extends AsyncTask<String, Void, List<Pair<String, String>>> {

    @Override
    protected List<Pair<String, String>> doInBackground(String... strings) {

        try {
            return Languages.getAllLanguages(strings[0], strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }

    }
}
