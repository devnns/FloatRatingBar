package com.devnn.floatraingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devnn.floatraingbar.library.FloatRatingBar;

public class MainActivity extends AppCompatActivity {
    private FloatRatingBar floatRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatRatingBar = findViewById(R.id.rating_bar1);
        floatRatingBar.setRate(1.0f);
    }
}
