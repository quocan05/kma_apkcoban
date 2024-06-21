package com.example.kma_practice.bai10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kma_practice.R;

public class Bai10Activity extends AppCompatActivity {


    String user;
    TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai10);
        initUi();
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        tvUser.setText(user);
    }

    private void initUi(){
        tvUser = findViewById(R.id.tvInfoLogin);
    }
}