package me.regos.github_repo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import me.regos.github_repo.adapters.Adapter;
import me.regos.github_repo.utils.AssignTask;
import me.regos.github_repo.utils.OnClickListener;
import me.regos.github_repo.utils.Repositories;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ActionBar actionBar;
    RecyclerView recyclerView;

    private String[] names = new String[0];
    private String userName;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        actionBar = getSupportActionBar();

        adapter = new Adapter(this, names, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Username");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userName = query;
                actionBar.setTitle(userName);

                AssignTask assignTask = new AssignTask();

                try {
                    var repos = assignTask.execute(userName).get();
                    names = Arrays.stream(repos).map(x -> ((Repositories.Repo) x).name).toArray(String[]::new);

                    Adapter newAdapter = new Adapter(adapter.getContext(), names, adapter.getClickListener());
                    recyclerView.setAdapter(newAdapter);

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(int position) {
        var repo = names[position];
        Intent intent = new Intent(this, LanguagesActivity.class).putExtra("user", userName).putExtra("repo", repo);
        startActivity(intent);


    }
}