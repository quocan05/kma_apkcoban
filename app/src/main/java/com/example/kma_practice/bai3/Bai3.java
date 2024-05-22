package com.example.kma_practice.bai3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;
import com.example.kma_practice.object.ItemBai3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 extends AppCompatActivity {

    RecyclerView rcv;
    List<ItemBai3> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);
        addItem();
        initUI();

    }

    void addItem(){
        list = new ArrayList<ItemBai3>();
        list.add(new ItemBai3("Quoc An", "0989999999", R.mipmap.blueicon));
        list.add(new ItemBai3("Nhung Cute", "09899399999", R.mipmap.blueicon));
        list.add(new ItemBai3("Pham Hoang", "0989993329999", R.mipmap.blueicon));
        list.add(new ItemBai3("Trung Hieu", "098999923999", R.mipmap.blueicon));
        list.add(new ItemBai3("Hoang Cau", "098992134999", R.mipmap.blueicon));
        list.add(new ItemBai3("Goku", "09899949999", R.mipmap.blueicon));
        list.add(new ItemBai3("Vegeta", "098939991999", R.mipmap.blueicon));
    }
    void initUI() {
        rcv = findViewById(R.id.rcvContacts);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(new MyAdapter(getApplicationContext(), list));
    }
}