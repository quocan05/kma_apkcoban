package com.example.kma_practice.bai3;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;
import com.example.kma_practice.bai8.Song;
import com.example.kma_practice.object.ItemBai3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 extends AppCompatActivity {

    RecyclerView rcv;
    List<Song> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);

        requestPermission();
        addItem();
        initUI();

    }

    public void requestPermission() {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[] {android.Manifest.permission.CALL_PHONE},123);
        }
    }

    void addItem(){
        list = new ArrayList<Song>();
        list.add(new Song("Ngay mai lay chong", "Hiep vit", R.raw.laychong));
        list.add(new Song("Baby shark", "Nhung cute", R.raw.babyshark));
        list.add(new Song("Nhung loi doi gian", "Thai Hoang", R.raw.nhungloidoigian));
//        list.add(new Song("abvasc", "098999923999", R.mipmap.blueicon, "Ha Nam"));
//        list.add(new Song("asasa", "098992134999", R.mipmap.blueicon, "Ha Noi"));
//        list.add(new Song("aswww", "09899949999", R.mipmap.blueicon,"Earth"));
//        list.add(new Song("wewewa", "098939991999", R.mipmap.blueicon,"Vegeta"));
    }
    void initUI() {
        rcv = findViewById(R.id.rcvContacts);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(new MyAdapter(getApplicationContext(), list));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (!(grantResults[0] == PackageManager.PERMISSION_GRANTED) && requestCode == 123) {
            requestPermission();
        }
    }
}