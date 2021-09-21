package com.example.learnpiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  ButtonClickListener onClickButtonListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btnStart:
                    btnStartOnClick(R.id.btnStart);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On click listeners for each button
        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(onClickButtonListener);
    }
    public void btnStartOnClick(int id) {
        startActivity(new Intent(this, sight_reading_game.class));
        finish();
    }
}

