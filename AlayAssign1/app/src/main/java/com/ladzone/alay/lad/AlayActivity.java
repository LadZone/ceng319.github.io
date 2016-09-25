package com.ladzone.alay.lad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class AlayActivity extends AppCompatActivity {
    private Handler page = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alay);
        page.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(AlayActivity.this, PizzaHut.class);
                startActivity(intent);
            }
        }, 2000); // 4 sec


    }
}
