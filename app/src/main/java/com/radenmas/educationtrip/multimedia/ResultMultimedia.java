package com.radenmas.educationtrip.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.Startup;
import com.spark.submitbutton.SubmitButton;

public class ResultMultimedia extends AppCompatActivity {

    private TextView username, score, mapel;
    private SubmitButton btn_menu;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_quiz);

        init();
        scoreMultimedia();
        onClick();
    }

    private void init() {
        username = findViewById(R.id.username);
        score = findViewById(R.id.score);
        btn_menu = findViewById(R.id.btn_menu);
        mapel = findViewById(R.id.mapel);
        mapel.setText("MULTIMEDIA");
    }

    private void scoreMultimedia() {
        SharedPreferences myAccount = this.getSharedPreferences("myAccount", Context.MODE_PRIVATE);
        String user = myAccount .getString("username","");
        username.setText(user);

        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1multimedia = mystar.getInt("starpart1multimedia",0);
        int starpart2multimedia = mystar.getInt("starpart2multimedia",0);
        int starpart3multimedia = mystar.getInt("starpart3multimedia",0);
        int starpart4multimedia = mystar.getInt("starpart4multimedia",0);
        int starpart5multimedia = mystar.getInt("starpart5multimedia",0);

        int starmultimedia = starpart1multimedia + starpart2multimedia + starpart3multimedia + starpart4multimedia + starpart5multimedia;
        score.setText(""+starmultimedia);

        editor.putInt("starmultimedia",starmultimedia);
        editor.apply();

        mediaPlayer = MediaPlayer.create(this, R.raw.win);
        mediaPlayer.start();
    }

    private void onClick() {
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ResultMultimedia.this, Startup.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                },2000);
            }
        });
    }
}
