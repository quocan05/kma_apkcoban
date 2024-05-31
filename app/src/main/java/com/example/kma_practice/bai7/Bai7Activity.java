package com.example.kma_practice.bai7;

import android.content.Intent;
import android.net.Uri;
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
import com.example.kma_practice.object.ItemBai3;

public class Bai7Activity extends AppCompatActivity {


    TextView tvInfo;
    Button btnDial, btnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai7);
        initUI();

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String location = intent.getStringExtra("location");
            String phone = intent.getStringExtra("phone");

            if (name != null && location != null && phone != null) {
                setData(name, location, phone);
                doAction(phone, location);
            } else {
                tvInfo.setText("Data not found");
            }
        }

    }


    private void doAction(String phone, String loc){
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+phone));
                startActivity(dial);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(Uri.parse("geo:0,0?q=" + Uri.encode(loc)));
                startActivity(map);
            }
        });
    }
    private  void setData( String name, String loc, String phone){
        tvInfo.setText("Object: "+name+", Phone: "+phone+", Location: "+loc);
    }
    private void initUI(){
        tvInfo = findViewById(R.id.tvInfo);
        btnDial = findViewById(R.id.btnDial);
        btnMap = findViewById(R.id.btnOpenMap);
    }
}