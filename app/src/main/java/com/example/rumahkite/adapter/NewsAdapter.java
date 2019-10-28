package com.example.rumahkite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rumahkite.R;
import com.example.rumahkite.model.CarouselNews;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<CarouselNews> carouselNewsArrayList;

    public NewsAdapter(Context context, ArrayList<CarouselNews> carouselNewsArrayList) {
        layoutInflater = LayoutInflater.from(context);
        this.carouselNewsArrayList = carouselNewsArrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.carousel_news, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.MyViewHolder holder, int position) {
        holder.ivImageNews.setImageResource(carouselNewsArrayList.get(position).getImage());
        holder.tvHeaderNews.setText(carouselNewsArrayList.get(position).getHeader());

    }

    @Override
    public int getItemCount() {
        return carouselNewsArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImageNews;
        TextView tvHeaderNews;
        public MyViewHolder(View view) {
            super(view);

            ivImageNews = (ImageView) view.findViewById(R.id.imagenews);
            tvHeaderNews = (TextView) view.findViewById(R.id.headernews);
        }
    }
}
