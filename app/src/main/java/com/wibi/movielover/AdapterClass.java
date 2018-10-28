package com.wibi.movielover;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wibi.movielover.Movies;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private Context context;
    private List<Movies> listMovies;

    public AdapterClass(Context context, List<Movies> listMovies){
        this.context = context;
        this.listMovies = listMovies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Movies movies = listMovies.get(position);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185"+movies.getPosterPath())
                .placeholder(R.drawable.img_default_bg)
                .into(holder.gmb);
        holder.judul.setText(movies.getTitle());
        holder.desc.setText(movies.getOverview());
//-

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("title", movies.getTitle());
                i.putExtra("poster_path", movies.getPosterPath());
                i.putExtra("overview", movies.getOverview());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button btnSelect;
        private ImageView gmb;
        private CardView cv;
        private TextView judul, desc;

        public ViewHolder(View itemView) {
            super(itemView);
            btnSelect = itemView.findViewById(R.id.btnSelect);
            cv = itemView.findViewById(R.id.card_view);
            gmb = itemView.findViewById(R.id.poster1);
            judul = itemView.findViewById(R.id.judul1);
            desc = itemView.findViewById(R.id.deskripsi1);
        }
    }
}
