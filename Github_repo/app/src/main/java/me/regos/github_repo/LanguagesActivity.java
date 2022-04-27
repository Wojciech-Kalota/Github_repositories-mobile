package me.regos.github_repo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import me.regos.github_repo.adapters.Adapter;
import me.regos.github_repo.adapters.AdapterLanguages;
import me.regos.github_repo.utils.AssignTask;
import me.regos.github_repo.utils.AssignTaskLanguages;
import me.regos.github_repo.utils.OnClickListener;
import me.regos.github_repo.utils.Repositories;

public class LanguagesActivity extends AppCompatActivity implements OnClickListener {

    ActionBar actionBar;
    RecyclerView recyclerViewLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        recyclerViewLanguages = findViewById(R.id.recyclerViewLanguages);

        String user = getIntent().getStringExtra("user");
        String repository = getIntent().getStringExtra("repo");

        actionBar = getSupportActionBar();
        actionBar.setTitle(repository);

        AssignTaskLanguages assignTask = new AssignTaskLanguages();

        List<Pair<String, String>> langs = new ArrayList<>();
        try {
            langs = assignTask.execute(user, repository).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        AdapterLanguages adapterLanguages = new AdapterLanguages(this, langs, this);
        recyclerViewLanguages.setAdapter(adapterLanguages);
        recyclerViewLanguages.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(int position){

    }
}