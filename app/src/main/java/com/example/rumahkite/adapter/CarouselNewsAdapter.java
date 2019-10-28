package com.example.rumahkite.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.rumahkite.R;
import com.example.rumahkite.model.CarouselImage;
import com.example.rumahkite.model.CarouselNews;

import java.util.ArrayList;

public class CarouselNewsAdapter extends PagerAdapter {
    private ArrayList<CarouselNews> carouselNews;
    private LayoutInflater layoutInflater;
    private Context context;

    public CarouselNewsAdapter(Context context, ArrayList<CarouselNews> carouselNews){
        this.context = context;
        this.carouselNews = carouselNews;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return carouselNews.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.carousel_news, container, false );
        assert view != null;
        final ImageView imageView = view.findViewById(R.id.imagenews);
        final TextView tvheader = view.findViewById(R.id.headernews);

        imageView.setImageResource(carouselNews.get(position).getImage());
        tvheader.setText(carouselNews.get(position).getHeader());
        container.addView(view, 0);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {

    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}
