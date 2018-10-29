package com.wibi.movielover;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    String img, judul, desc;
    ImageView poster;
    TextView vJudul, deskripsi;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        poster = findViewById(R.id.poster2);
        vJudul = findViewById(R.id.judul2);
        deskripsi = findViewById(R.id.deskripsi2);

        img = getIntent().getStringExtra("poster_path");
        judul = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("overview");

        Glide.with(getApplicationContext())
                .load("http://image.tmdb.org/t/p/w185"+img)
                .placeholder(R.drawable.img_default_bg)
                .into(poster);
        vJudul.setText(judul);
        deskripsi.setText(desc);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
