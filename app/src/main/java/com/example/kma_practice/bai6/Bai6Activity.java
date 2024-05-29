package com.example.kma_practice.bai6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kma_practice.R;

public class Bai6Activity extends AppCompatActivity {


    EditText edtSearch;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai6);
        initUI();

        actionSearch();
    }

    private void actionSearch() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = edtSearch.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=" + Uri.encode(loc)));
                startActivity(intent);
            }
        });
    }


    private void initUI() {
        btnSearch = findViewById(R.id.btnSearchLocation);
        edtSearch = findViewById(R.id.edtSearch);
    }

}