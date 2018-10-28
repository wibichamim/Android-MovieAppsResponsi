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
    ImageView tvImg;
    TextView tvJudul, tvDesc;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvImg = findViewById(R.id.poster2);
        tvJudul = findViewById(R.id.judul2);
        tvDesc = findViewById(R.id.deskripsi2);

        img = getIntent().getStringExtra("poster_path");
        judul = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("overview");

        Glide.with(getApplicationContext())
                .load("http://image.tmdb.org/t/p/w185"+img)
                .placeholder(R.drawable.img_default_bg)
                .into(tvImg);
        tvJudul.setText(judul);
        tvDesc.setText(desc);

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
