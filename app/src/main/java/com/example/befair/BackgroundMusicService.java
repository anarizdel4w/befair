package com.example.befair;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class BackgroundMusicService extends Service {
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mylog", "On Create Service");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("mylog", "Starting playing");
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String from = bundle.getString("From");
            if (from.equals("Quiz")){
                mediaPlayer = MediaPlayer.create(this, R.raw.music);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }else{
                mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public boolean stopService(Intent name) {

        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

    }
}
