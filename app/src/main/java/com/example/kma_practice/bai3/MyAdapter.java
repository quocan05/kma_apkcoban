package com.example.kma_practice.bai3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kma_practice.R;
import com.example.kma_practice.bai10.AccountBai10;
import com.example.kma_practice.bai8.Song;
import com.example.kma_practice.bai8.SongActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;

    private OnItemClickListener listener;


    public MyAdapter(Context context, List<AccountBai10> list) {
        this.context = context;
        this.list = list;
    }

    List<AccountBai10> list;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvName.setText(list.get(position).getName());
        holder.tvNumber.setText(list.get(position).getPhoneNumber());
//        holder.img.setImageResource(list.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent quaySo = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+holder.tvNumber.getText()));
//                quaySo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(quaySo);
//                Intent intent = new Intent(v.getContext(), SongActivity.class);
//
////                intent.putExtra("name", list.get(position).getName());
//                    intent.putExtra("song", list.get(position).getLink());
//                    intent.putExtra("name_song", list.get(position).getName());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
