package com.example.rumahkite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.rumahkite.adapter.CarouselImageAdapter;
import com.example.rumahkite.adapter.NewsAdapter;
import com.example.rumahkite.model.CarouselImage;
import com.example.rumahkite.model.CarouselNews;
import com.example.rumahkite.services.StatusBar;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static ViewPager mPager;
    private static ViewPager mPagerNews;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static int NUM_PAGES_NEWS = 0;
    private ArrayList<CarouselImage> carouselImageArrayList;

    private RecyclerView recyclerView;
    private ArrayList<CarouselNews> carouselNewsArrayList;
    private NewsAdapter newsAdapter;


    private Button Bthome, Bttukang;
    Intent intent;

    private int[] myImageList = new int[]{
            R.drawable.promo,
            R.drawable.promo2,
            R.drawable.promo3
    };

    private int[] myNewsList = new int[]{
            R.drawable.newsone,
            R.drawable.newstwo
    };

    private String[] myHeaderList = new String[]{
            "Asyik Memanjakan Diri di Rumah",
            "Rumah Nyaman dan Adem"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBar statusBar = new StatusBar(this);
        statusBar.statusBarCall(MainActivity.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this,R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this,R.color.white));

        carouselImageArrayList = new ArrayList<>();
        carouselImageArrayList = populateList();

        recyclerView = findViewById(R.id.rvNews);
        carouselNewsArrayList = carouselNews();
        newsAdapter = new NewsAdapter(this, carouselNewsArrayList);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        TextView tvRek = findViewById(R.id.rekomendasi);
        Bthome = findViewById(R.id.homeBt);
        Bttukang = findViewById(R.id.bttukang);


        init();

        Bthome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, TabsActivity.class);
                startActivity(intent);
            }
        });

        Bttukang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, TukangActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<CarouselNews> carouselNews() {
        ArrayList<CarouselNews> newsArrayList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            CarouselNews carouselNews = new CarouselNews();
            carouselNews.setImage(myNewsList[i]);
            carouselNews.setHeader(myHeaderList[i]);
            newsArrayList.add(carouselNews);
        }

        return newsArrayList;
    }

    private ArrayList<CarouselImage> populateList(){
        ArrayList<CarouselImage> list = new ArrayList<>();

        for (int i = 0 ; i < 3; i++) {
            CarouselImage carouselImage =  new CarouselImage();
            carouselImage.setImage(myImageList[i]);
            list.add(carouselImage);
        }
        return list;
    }


    private void init(){
        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new CarouselImageAdapter(MainActivity.this, carouselImageArrayList));

        CirclePageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(4*density);

        NUM_PAGES = carouselImageArrayList.size();

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 4000, 4000);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        /*if (id == R.id.like) {

        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
