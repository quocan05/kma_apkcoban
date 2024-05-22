package com.example.kma_practice.bai3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;
import com.example.kma_practice.object.ItemBai3;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;

    public MyAdapter(Context context, List<ItemBai3> list) {
        this.context = context;
        this.list = list;
    }

    List<ItemBai3> list;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvNumber.setText(list.get(position).getPhoneNumber());
        holder.img.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
