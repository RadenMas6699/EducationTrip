package com.radenmas.educationtrip.jaringan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.Startup;
import com.spark.submitbutton.SubmitButton;

public class ResultJaringan extends AppCompatActivity {

    private TextView username, score, mapel;
    private SubmitButton btn_menu;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_quiz);

        init();
        scoreJaringan();
        onClick();
    }

    private void init() {
        username = findViewById(R.id.username);
        score = findViewById(R.id.score);
        btn_menu = findViewById(R.id.btn_menu);
        mapel = findViewById(R.id.mapel);
        mapel.setText("JARINGAN");
    }

    private void scoreJaringan() {
        SharedPreferences myAccount = this.getSharedPreferences("myAccount", Context.MODE_PRIVATE);
        String user = myAccount .getString("username","");
        username.setText(user);

        SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mystar.edit();

        int starpart1jaringan = mystar.getInt("starpart1jaringan",0);
        int starpart2jaringan = mystar.getInt("starpart2jaringan",0);
        int starpart3jaringan = mystar.getInt("starpart3jaringan",0);
        int starpart4jaringan = mystar.getInt("starpart4jaringan",0);
        int starpart5jaringan = mystar.getInt("starpart5jaringan",0);

        int starjaringan = starpart1jaringan + starpart2jaringan + starpart3jaringan + starpart4jaringan + starpart5jaringan;
        score.setText(""+starjaringan);

        editor.putInt("starjaringan",starjaringan);
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
                        startActivity(new Intent(ResultJaringan.this, Startup.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                },2000);
            }
        });
    }
}
