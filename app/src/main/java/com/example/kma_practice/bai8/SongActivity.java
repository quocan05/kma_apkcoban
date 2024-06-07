package com.example.kma_practice.bai8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kma_practice.R;

public class SongActivity extends AppCompatActivity {


    Button btnPlay, btnStop;
    TextView tvNameSong;
    Intent intent;
    int linkSong;
    String nameSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_song);

        intent = getIntent();
        linkSong = intent.getIntExtra("song", -1);
        nameSong = intent.getStringExtra("name_song");
        initUI();
        actionService();
    }

    private void initUI() {
        btnPlay = findViewById(R.id.btnPlaySong);
        btnStop = findViewById(R.id.btnStopSong);
        tvNameSong = findViewById(R.id.tvNameSong);
        tvNameSong.setText(nameSong);
    }

    @Override
    public void onBackPressed() {
        Intent serviceIntent = new Intent(SongActivity.this
                , PlaySongService.class);
        stopService(serviceIntent);
        super.onBackPressed();
    }

    private void actionService() {


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linkSong != -1) {
                    Intent serviceIntent = new Intent(SongActivity.this
                            , PlaySongService.class);
                    serviceIntent.putExtra("song", linkSong);

                    startService(serviceIntent);
                }

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(SongActivity.this
                        , PlaySongService.class);
                stopService(serviceIntent);
            }
        });


    }
}