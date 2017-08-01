package com.prachigautam.itunesapp;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;

import static com.prachigautam.itunesapp.ApplicationController.retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMusic;
    LinearLayoutManager mLayoutManager;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getControls();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void getControls() {

        rvMusic = (RecyclerView) findViewById(R.id.rvMusic);
        mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rvMusic.setHasFixedSize(true);
        rvMusic.setLayoutManager(mLayoutManager);


        getData();
    }

    private void getData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_music_list, menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                if (query.length() < 3) {
                    Toast.makeText(MainActivity.this, "Enter minimum 3 chars", Toast.LENGTH_SHORT).show();
                } else {
                    // server call
                    ApplicationController.executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (ConstantsMethods.isConnected(MainActivity.this)) {

                                    final ResultApi resultApi = retrofit.create(ResultApi.class);
                                    Call<MusicPojo> callMusic = resultApi.searchMusic(query);
                                    final MusicPojo musicPojo = callMusic.execute().body();

                                    if (musicPojo != null) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (musicPojo.resultCount > 0) {
                                                    MusicAdapter adapter = new MusicAdapter(musicPojo.getResults(), MainActivity.this);
                                                    rvMusic.setAdapter(adapter);

                                                } else if (musicPojo.getResultCount() == 0) {
                                                    Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });

                                    }
                                }
                            } catch (Exception e) {
                                Log.d("music : ", e.toString());
                            }
                        }
                    });
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() == 0) {

                }
                return true;
            }
        });
        return true;
    }
}
