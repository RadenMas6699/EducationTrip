package com.radenmas.educationtrip.rpl;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.educationtrip.MenuPlay;
import com.radenmas.educationtrip.R;
import com.radenmas.educationtrip.function.DisableButton;
import com.radenmas.educationtrip.function.EnableButton;
import com.radenmas.educationtrip.function.HeartPoint;

public class Part3RPL extends AppCompatActivity {

    private BankSoalRPL bankSoalRPL = new BankSoalRPL();
    private TextView koinText, question, choice1, choice2, choice3, choice4, waktu;
    private String mAnswer;
    private int timeValue = 15;
    private int pointheart = 3;
    private int mQuestionNumber = 0;
    private int scorepart3rpl = 0;
    private CountDownTimer countDownTimer;
    private ImageView heart, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_rpl);

        init();
        updateScore(scorepart3rpl);
        countDown();
        updateQuestion();
    }

    private void init() {
        koinText = findViewById(R.id.koinText);
        question = findViewById(R.id.question);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        waktu = findViewById(R.id.waktu);
        heart = findViewById(R.id.heart);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Part3RPL.this, MapsRPL.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    private void updateQuestion() {
        if(mQuestionNumber< bankSoalRPL.getLength3() ){
            timeValue = 15;
            countDownTimer.cancel();
            countDownTimer.start();

            question.setText(bankSoalRPL.getQuestion3(mQuestionNumber));
            choice1.setText(bankSoalRPL.getChoice3(mQuestionNumber, 1));
            choice2.setText(bankSoalRPL.getChoice3(mQuestionNumber, 2));
            choice3.setText(bankSoalRPL.getChoice3(mQuestionNumber, 3));
            choice4.setText(bankSoalRPL.getChoice3(mQuestionNumber,4));
            mAnswer = bankSoalRPL.getCorrectAnswer3(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mystar.edit();

            if (scorepart3rpl >=0 && scorepart3rpl < 30){
                int starpart3rpl = 0;
                editor.putInt("starpart3rpl", starpart3rpl);
                editor.apply();
            }
            else if (scorepart3rpl == 30){
                int starpart3rpl = 1;
                editor.putInt("starpart3rpl", starpart3rpl);
                editor.apply();
            }
            else if (scorepart3rpl == 40){
                int starpart3rpl = 2;
                editor.putInt("starpart3rpl", starpart3rpl);
                editor.apply();
            }
            else if (scorepart3rpl == 50){
                int starpart3rpl = 3;
                editor.putInt("starpart3rpl", starpart3rpl);
                editor.apply();
            }
            Intent intent = new Intent(Part3RPL.this, MapsRPL.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    public void onClick(View view) {
        TextView answer = (TextView) view;
        countDownTimer.cancel();
        if (answer.getText() == mAnswer){
            scorepart3rpl = scorepart3rpl + 10;
            answer.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl_true));
            disableButton();
            correctDialog();
        }
        else {
            pointheart -= 1;
            answer.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl_false));
            disableButton();

            HeartPoint heartPoint = new HeartPoint(pointheart,heart);
            if (pointheart == 2){
                gameLostPlayAgain();
            } else if (pointheart == 1){;
                gameLostPlayAgain();
            } else if (pointheart == 0){
                gameOver();
            }
        }
        updateScore(scorepart3rpl);
    }

    public void correctDialog() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.correct);
        mediaPlayer.start();
        final Dialog dialogCorrect = new Dialog(Part3RPL.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_answer_true);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();

        Button next = dialogCorrect.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                dialogCorrect.dismiss();
                resetBackground();
                enableButton();
                updateQuestion();
            }
        });
    }

    public void gameLostPlayAgain() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mediaPlayer.start();
        final Dialog dialogFalse = new Dialog(Part3RPL.this);
        dialogFalse.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogFalse.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogFalse.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogFalse.setContentView(R.layout.dialog_answer_false);
        dialogFalse.setCancelable(false);
        dialogFalse.show();

        onPause();

        Button next = dialogFalse.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFalse.dismiss();
                resetBackground();
                enableButton();
                updateQuestion();
            }
        });
    }

    private void gameOver() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_over);
        mediaPlayer.start();
        final Dialog dialogGameOver = new Dialog(Part3RPL.this);
        dialogGameOver.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogGameOver.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogGameOver.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogGameOver.setContentView(R.layout.dialog_game_over);
        dialogGameOver.setCancelable(false);
        dialogGameOver.show();

        onPause();

        Button game_over = dialogGameOver.findViewById(R.id.game_over);

        game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogGameOver.dismiss();
                Intent menu = new Intent(Part3RPL.this, MenuPlay.class);
                startActivity(menu);
                finish();
            }
        });
    }

    private void updateScore(int scorepart3rpl) {
        koinText.setText("" +scorepart3rpl);
    }

    private void countDown() {
        countDownTimer = new CountDownTimer(16000, 1000) {
            public void onTick(long millisUntilFinished) {
                waktu.setText(String.valueOf(timeValue) + "\"");
                timeValue -= 1;
            }

            public void onFinish() {
                disableButton();
                gameOver();
            }
        }.start();
    }

    public void resetBackground() {
        choice1.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl));
        choice2.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl));
        choice3.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl));
        choice4.setBackground(getResources().getDrawable(R.drawable.bg_choice_rpl));
    }
    public void disableButton() {
        DisableButton disableButton = new DisableButton(choice1, choice2, choice3, choice4);
    }
    public void enableButton() {
        EnableButton enableButton = new EnableButton(choice1, choice2, choice3, choice4);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Part3RPL.this, MapsRPL.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
