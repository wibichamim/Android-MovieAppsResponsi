package com.wibi.movielover;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    RecyclerView rvList;
    private AdapterClass adapter;
    List<Movies> listMovies = new ArrayList<>();
    ProgressDialog loading;
    MovieApi apiService;

    private final String api_key = BuildConfig.API_KEY;
    private String language = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.recyclerList);

        apiService = ServerApi.getAPIService();

        adapter = new AdapterClass(getApplicationContext(), listMovies);

        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvList.setAdapter(adapter);

        refresh();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

            if (id == R.id.id) {
                language = "id";
                refresh();
            }
            else if (id == R.id.en) {

                language = "en";
                refresh();
            }
                return super.onOptionsItemSelected(item);

        }


    private void refresh(){

        apiService.getNowPlayingMovie(api_key, language).enqueue(new Callback<ResponseM>() {
            @Override
            public void onResponse(Call<ResponseM> call, Response<ResponseM> response) {
                if (response.isSuccessful()){
                    listMovies = response.body().getMovies();
                    rvList.setAdapter(new AdapterClass(getApplicationContext(), listMovies));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseM> call, Throwable t) {

            }

        });
    }



}
