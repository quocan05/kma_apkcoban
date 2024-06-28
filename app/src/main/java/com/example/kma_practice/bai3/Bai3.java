package com.example.kma_practice.bai3;

import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;
import com.example.kma_practice.bai10.AccountBai10;
import com.example.kma_practice.bai8.Song;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Bai3 extends AppCompatActivity {

    RecyclerView rcv;
    List<Song> list;
    List<AccountBai10> listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);

        requestPermission();
        laodAccountBai10();
        //addItem();
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
        rcv.setAdapter(new MyAdapter(getApplicationContext(), listUser));
    }

    private void laodAccountBai10() {
        AssetManager assetManager = getAssets();
        try (InputStream inputStream = assetManager.open("users.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<AccountBai10>>(){}.getType();
            listUser = gson.fromJson(new InputStreamReader(inputStream), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (!(grantResults[0] == PackageManager.PERMISSION_GRANTED) && requestCode == 123) {
            requestPermission();
        }
    }
}