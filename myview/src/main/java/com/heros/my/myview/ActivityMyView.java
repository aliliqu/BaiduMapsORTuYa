package com.heros.my.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityMyView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        MyView myView=new MyView(this);

    }
}
