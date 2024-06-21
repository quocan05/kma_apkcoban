package com.example.kma_practice.bai9;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kma_practice.R;

public class Bai9Activity extends AppCompatActivity {


    MyReceiver myReceiver;
    MyReceiverOpenSong myReceiverOpenSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai9);
        myReceiver = new MyReceiver();
        myReceiverOpenSong = new MyReceiverOpenSong();



        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(myReceiver, filter);

        IntentFilter musicFilter = new IntentFilter();
        musicFilter.addAction("com.example.START_MUSIC_SERVICE");
        registerReceiver(myReceiverOpenSong, musicFilter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}