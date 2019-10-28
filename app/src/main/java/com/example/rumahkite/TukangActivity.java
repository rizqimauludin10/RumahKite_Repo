package com.example.rumahkite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rumahkite.services.StatusBar;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.view.View.*;

public class TukangActivity extends AppCompatActivity {
    Button btTukang;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tukang);

        btTukang = findViewById(R.id.tukangone);

        btTukang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(TukangActivity.this, TukangFormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
