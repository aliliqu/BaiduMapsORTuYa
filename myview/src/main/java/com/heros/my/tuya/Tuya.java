package com.heros.my.tuya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.heros.my.myview.R;

public class Tuya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TuYaView tuYaView=new TuYaView(Tuya.this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        setContentView(tuYaView);
    }
}
