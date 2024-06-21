package com.example.kma_practice.bai9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.kma_practice.bai8.PlaySongService;

public class MyReceiverOpenSong extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        if(intent.getAction().equals("com.example.START_MUSIC_SERVICE")){
//            Intent serviceIntent = new Intent(context, PlaySongService.class);
//            context.startService(serviceIntent);
//            Toast.makeText(context, "receive play service", Toast.LENGTH_LONG).show();
//        }
        Intent serviceIntent = new Intent(context, PlaySongService.class);
        context.startService(serviceIntent);

        Intent activityIntent = new Intent(context, Bai9Activity.class);
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(activityIntent);
          Toast.makeText(context, "receive play service", Toast.LENGTH_LONG).show();

    }
}