package me.regos.github_repo.utils;

import android.os.AsyncTask;

public class AssignTask extends AsyncTask<String, Void, Object[]> {

    @Override
    protected Object[] doInBackground(String... strings) {
        return Repositories.getAllRepos(strings[0]).toArray();
    }
}
