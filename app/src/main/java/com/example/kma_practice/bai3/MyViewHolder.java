package com.example.kma_practice.bai3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tvName, tvNumber;
    ImageView img;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.imgAvatar);
        tvName = itemView.findViewById(R.id.tvName);
        tvNumber = itemView.findViewById(R.id.tvNumber);
    }
}
