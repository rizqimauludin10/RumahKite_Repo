package com.example.rumahkite.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.rumahkite.R;
import com.example.rumahkite.model.CarouselImage;

import java.util.ArrayList;

public class CarouselImageAdapter extends PagerAdapter {

    private ArrayList<CarouselImage> carouselImages;
    private LayoutInflater layoutInflater;
    private Context context;

    public CarouselImageAdapter(Context context, ArrayList<CarouselImage> carouselImages){
        this.context = context;
        this.carouselImages = carouselImages;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return carouselImages.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.carousel_image, container, false );
        assert view != null;
        final ImageView imageView = (ImageView) view.findViewById(R.id.banner);

        imageView.setImageResource(carouselImages.get(position).getImage());
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
