package com.radenmas.educationtrip.multimedia;

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

import com.radenmas.educationtrip.function.DisableButton;
import com.radenmas.educationtrip.function.EnableButton;
import com.radenmas.educationtrip.function.HeartPoint;
import com.radenmas.educationtrip.MenuPlay;
import com.radenmas.educationtrip.R;

public class Part2Multimedia extends AppCompatActivity {

    private BankSoalMultimedia bankSoalMultimedia = new BankSoalMultimedia();
    private TextView koinText, question, choice1, choice2, choice3, choice4, waktu;
    private String mAnswer;
    private int timeValue = 15;
    private int pointheart = 3;
    private int mQuestionNumber = 0;
    private int scorepart2multimedia = 0;
    private CountDownTimer countDownTimer;
    private ImageView heart, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_multimedia);

        init();
        updateScore(scorepart2multimedia);
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
                Intent intent = new Intent(Part2Multimedia.this, MapsMultimedia.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    private void updateQuestion() {
        if(mQuestionNumber< bankSoalMultimedia.getLength2() ){
            timeValue = 15;
            countDownTimer.cancel();
            countDownTimer.start();

            question.setText(bankSoalMultimedia.getQuestion2(mQuestionNumber));
            choice1.setText(bankSoalMultimedia.getChoice2(mQuestionNumber, 1));
            choice2.setText(bankSoalMultimedia.getChoice2(mQuestionNumber, 2));
            choice3.setText(bankSoalMultimedia.getChoice2(mQuestionNumber, 3));
            choice4.setText(bankSoalMultimedia.getChoice2(mQuestionNumber,4));
            mAnswer = bankSoalMultimedia.getCorrectAnswer2(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            SharedPreferences mystar = this.getSharedPreferences("myStar", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mystar.edit();

            if (scorepart2multimedia >=0 && scorepart2multimedia < 30){
                int starpart2multimedia = 0;
                editor.putInt("starpart2multimedia", starpart2multimedia);
                editor.apply();
            }
            else if (scorepart2multimedia == 30){
                int starpart2multimedia = 1;
                editor.putInt("starpart2multimedia", starpart2multimedia);
                editor.apply();
            }
            else if (scorepart2multimedia == 40){
                int starpart2multimedia = 2;
                editor.putInt("starpart2multimedia", starpart2multimedia);
                editor.apply();
            }
            else if (scorepart2multimedia == 50){
                int starpart2multimedia = 3;
                editor.putInt("starpart2multimedia", starpart2multimedia);
                editor.apply();
            }
            Intent intent = new Intent(Part2Multimedia.this, MapsMultimedia.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    public void onClick(View view) {
        TextView answer = (TextView) view;
        countDownTimer.cancel();
        if (answer.getText() == mAnswer){
            scorepart2multimedia = scorepart2multimedia + 10;
            answer.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia_true));
            disableButton();
            correctDialog();
        }
        else {
            pointheart -= 1;
            answer.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia_false));
            disableButton();

            HeartPoint heartPoint = new HeartPoint(pointheart,heart);
            if (pointheart == 2){
                gameLostPlayAgain();
            } else if (pointheart == 1){
                gameLostPlayAgain();
            } else if (pointheart == 0){
                gameOver();
            }
        }
        updateScore(scorepart2multimedia);
    }

    public void correctDialog() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.correct);
        mediaPlayer.start();
        final Dialog dialogCorrect = new Dialog(Part2Multimedia.this);
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
        final Dialog dialogFalse = new Dialog(Part2Multimedia.this);
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
        final Dialog dialogGameOver = new Dialog(Part2Multimedia.this);
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
                Intent menu = new Intent(Part2Multimedia.this, MenuPlay.class);
                startActivity(menu);
                finish();
            }
        });
    }

    private void updateScore(int scorepart2multimedia) {
        koinText.setText("" +scorepart2multimedia);
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
        choice1.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia));
        choice2.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia));
        choice3.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia));
        choice4.setBackground(getResources().getDrawable(R.drawable.bg_choice_multimedia));
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
        Intent intent = new Intent(Part2Multimedia.this, MapsMultimedia.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
