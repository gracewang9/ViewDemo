package com.example.viewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.viewdemo.views.DrawViewPractice0;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DrawViewPractice0 drawViewPractice0=findViewById(R.id.decelerate);
        drawViewPractice0.setListener(new DrawViewPractice0.OnItemSelectListener() {
            @Override
            public void onItemSelect(int index) {
                Log.e("log-->>","index = "+index);
            }
        });
    }
}