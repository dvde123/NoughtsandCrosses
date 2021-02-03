package com.example.noughtsandcrosses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button btnBack = findViewById(R.id.backButton);

        int[] mass = new int[9];

        AtomicBoolean changePlayer = new AtomicBoolean(false);


        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            startActivity(intent);
        });

        final Button[] buttons = new Button[9];
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        buttons[4] = findViewById(R.id.btn5);
        buttons[5] = findViewById(R.id.btn6);
        buttons[6] = findViewById(R.id.btn7);
        buttons[7] = findViewById(R.id.btn8);
        buttons[8] = findViewById(R.id.btn9);

        final TextView text = findViewById(R.id.text);

        for (int i = 0; i < buttons.length; i++) {
            int finalI = i;
            buttons[i].setOnClickListener(v -> {
                if (!changePlayer.get()) {
                    changePlayer.set(true);
                    text.setText("There is a: Toes");
                    buttons[finalI].setText("X");
                    mass[finalI] = 1;
                } else {
                    changePlayer.set(false);
                    text.setText("There is a: Crescents");
                    buttons[finalI].setText("O");
                    mass[finalI] = 2;
                }
                buttons[finalI].setEnabled(false);
                if ( ( (mass[0]==1 | mass[1]==1 | mass[2]==1) & (mass[3]==1 | mass[4]==1 |mass[5]==1) & (mass[6]==1|mass[7]==1|mass[8]==1)) | ((mass[0]==1 | mass[3]==1 | mass[6]==1) & (mass[1]==1 | mass[4]==1 | mass[7]==1) & (mass[2]==1 | mass[5]==1 | mass[8]==1)) ) {
                    for (int j = 0; j < mass.length; j++)
                        mass[j] = 3;
                    text.setText("Win: Crescents");
                    for (int h = 0; h < buttons.length; h++)
                        buttons[h].setEnabled(false);
                }
                if ( ( (mass[0]==2 | mass[2]==2 | mass[2]==2) & (mass[3]==2 | mass[4]==2 |mass[5]==2) & (mass[6]==2|mass[7]==2|mass[8]==2)) | ((mass[0]==2 | mass[3]==2 | mass[6]==2) & (mass[2]==2 | mass[4]==2 | mass[7]==2) & (mass[2]==2 | mass[5]==2 | mass[8]==2)) ) {
                    for (int j = 0; j < mass.length; j++)
                        mass[j] = 3;
                    text.setText("Win: Toes");
                    for (int h = 0; h < buttons.length; h++)
                        buttons[h].setEnabled(false);
                }
            });
        }
    }
}