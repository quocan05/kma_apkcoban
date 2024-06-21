package com.example.kma_practice.bai10;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.kma_practice.bai4.Bai4Activity;

public class Bai10Activity extends AppCompatActivity {


    String user;
    TextView tvUser;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai10);
        initUi();
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        tvUser.setText(user);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("logged_in", false);
                editor.remove("user");
                editor.apply();

                // Redirect to Bai4Activity
                Intent intentLogout = new Intent(Bai10Activity.this, Bai4Activity.class);
                startActivity(intentLogout);
                finish();
            }
        });
    }

    private void initUi(){
        tvUser = findViewById(R.id.tvInfoLogin);
        btnLogout = findViewById(R.id.btnLogout10);
    }
}