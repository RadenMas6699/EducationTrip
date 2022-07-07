package com.radenmas.educationtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.radenmas.educationtrip.multimedia.Part1Multimedia;

import java.util.HashMap;
import java.util.Map;

public class Startup extends AppCompatActivity {

    private ImageView btn_exit, btn_settings, btn_highscore, btn_info;
    private LinearLayout btn_play;
    MediaPlayer mediaPlayer;
    ToggleButton myToggle;

    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);

//        SharedPreferences mySound = this.getSharedPreferences("mySound", Context.MODE_PRIVATE);
//
//        boolean prefmusic = mySound.getBoolean("music",true);

//        music();
        init();
//        if (prefmusic == true){
//            mediaPlayer.setVolume(1, 1);
//            myToggle.setBackgroundDrawable(getResources().getDrawable(R.drawable.volume_on));
//        } else {
//            mediaPlayer.setVolume(0, 0);
//            myToggle.setBackgroundDrawable(getResources().getDrawable(R.drawable.volume_off));
//        }
        onClick();


    }

    private void init() {
        btn_play = findViewById(R.id.btn_play);
        btn_settings = findViewById(R.id.btn_settings);
        btn_highscore = findViewById(R.id.btn_highscore);
        btn_info = findViewById(R.id.btn_info);
        btn_exit = findViewById(R.id.btn_exit);
        fAuth = FirebaseAuth.getInstance();
    }

    private void music() {
//        myToggle = (ToggleButton) findViewById(R.id.toggleSound);
//        mediaPlayer = MediaPlayer.create(this, R.raw.play);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }


    private void onClick() {
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Startup.this, MenuPlay.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fAuth.getCurrentUser() == null) {
                    startActivity(new Intent(Startup.this, MenuLogin.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                } else {
                    startActivity(new Intent(Startup.this, MenuSettings.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                finish();
            }
        });

        btn_highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fAuth.getCurrentUser() == null) {
                    startActivity(new Intent(Startup.this, MenuLogin.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                } else {
                    startActivity(new Intent(Startup.this, MenuHighscore.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                finish();
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Startup.this, MenuInfo.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogExit();
            }
        });
    }

    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        SharedPreferences mySound = this.getSharedPreferences("mySound", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorMusic = mySound.edit();

        boolean prefmusic = mySound.getBoolean("music",true);

        if (on) {
            mediaPlayer.setVolume(0, 0);
            myToggle.setBackgroundDrawable(getResources().getDrawable(R.drawable.volume_off));
            editorMusic.putBoolean("music", false);
            editorMusic.apply();
        } else {
            mediaPlayer.setVolume(1, 1);
            myToggle.setBackgroundDrawable(getResources().getDrawable(R.drawable.volume_on));
            editorMusic.putBoolean("music", true);
            editorMusic.apply();
        }
    }

    public void dialogExit() {
        final Dialog dialogExit = new Dialog(Startup.this);
        dialogExit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogExit.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogExit.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogExit.setContentView(R.layout.dialog_exit);
        dialogExit.setCancelable(false);
        dialogExit.show();

        TextView dialog_ya = dialogExit.findViewById(R.id.dialog_ya);
        TextView dialog_tidak = dialogExit.findViewById(R.id.dialog_tidak);

        dialog_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogExit.dismiss();
                mediaPlayer.stop();
                overridePendingTransition(R.anim.exit,R.anim.fade_out);
                finish();
            }
        });

        dialog_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogExit.dismiss();
                dialogExit.cancel();
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        dialogExit();
    }

}
