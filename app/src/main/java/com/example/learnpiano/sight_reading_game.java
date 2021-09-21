package com.example.learnpiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class sight_reading_game extends AppCompatActivity {

    private ButtonClickListener onClickButtonListener = new ButtonClickListener();
    String[] noteArray = {"A", "B", "C", "D", "E", "F", "G"};
    Random noteGenerator = new Random();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int btnID = view.getId();
            switch(btnID) {
                case R.id.btnA:
                case R.id.btnB:
                case R.id.btnC:
                case R.id.btnD:
                case R.id.btnE:
                case R.id.btnF:
                case R.id.btnG:
                    changeScore(btnID);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_reading_game);
        changeNote(noteGenerator);



        // On click listeners for each button
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);
        Button btnG = findViewById(R.id.btnG);

        btnA.setOnClickListener(onClickButtonListener);
        btnB.setOnClickListener(onClickButtonListener);
        btnC.setOnClickListener(onClickButtonListener);
        btnD.setOnClickListener(onClickButtonListener);
        btnE.setOnClickListener(onClickButtonListener);
        btnF.setOnClickListener(onClickButtonListener);
        btnG.setOnClickListener(onClickButtonListener);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void changeScore(int btnID) {
        TextView txtScore = findViewById(R.id.txtScore);
        String string = txtScore.getText().toString();
        int score = Integer.parseInt(string);
        if (checkAnswer(btnID)) {
            score++;
        } else {
            score--;
        }
        txtScore.setText(Integer.toString(score));
        changeNote(noteGenerator);

    }

    private boolean checkAnswer(int btnID) {
        TextView txtDisplayNote = findViewById(R.id.txtDisplayNote);
        String answer = txtDisplayNote.getText().toString();

        Button btnAnswer = findViewById(btnID);
        String btnAnswerString = btnAnswer.getText().toString();

        return answer.equals(btnAnswerString);
    }

    private void changeNote(Random noteGenerator) {
        int randomIndex = noteGenerator.nextInt(noteArray.length);
        TextView txtDisplayNote = findViewById(R.id.txtDisplayNote);
        txtDisplayNote.setText(noteArray[randomIndex]);
        changeNoteImage();
    }

    private void changeNoteImage() {
        ImageView img = findViewById(R.id.imgViewNote);
        int currentX = Math.round(img.getX());
        int currentY = Math.round(img.getY());

        img.setX(currentX + 10);
        img.setY(currentY + 10);

    }

}