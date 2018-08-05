package com.example.xervice111.tictactoe;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    int turn = 0;
    int tag;
    int[] board = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[] win = {3, 4, 5, 6, 7, 8, 9, 10, 11};
    ImageView isTapped;


    public void imageTapped(View view) {

        isTapped = (ImageView) view;

        tag = Integer.parseInt(isTapped.getTag().toString());
        win[tag] = turn;
        if ((!gameOver())) {

            if (board[tag] == 2) {

                board[tag] = turn;

                if (turn == 0) {

                    isTapped.setImageResource(R.drawable.cross);
                    isTapped.animate().rotationY(360).setDuration(1000);
                    turn = 1;
                } else {
                    isTapped.setImageResource(R.drawable.circle);
                    isTapped.animate().rotationY(360).setDuration(1000);
                    turn = 0;
                }
            } else {
                Toast.makeText(this, "Place already filled", Toast.LENGTH_SHORT).show();
            }
        } else {
            TextView textView = findViewById(R.id.congo);
            if (win[0] == 0 && win[1] == 0 && win[2] == 0 || win[3] == 0 && win[4] == 0 && win[5] == 0 || win[6] == 0 && win[7] == 0 && win[8] == 0
                    || win[0] == 0 && win[3] == 0 && win[6] == 0 || win[1] == 0 && win[4] == 0 && win[7] == 0 || win[2] == 0 && win[5] == 0 && win[8] == 0
                    || win[0] == 0 && win[4] == 0 && win[8] == 0 || win[8] == 0 && win[4] == 0 && win[2] == 0 || win[2] == 0 && win[4] == 0 && win[6] == 0 ||
                    win[6] == 0 && win[4] == 0 && win[2] == 0) {

                textView.setText("CONGRATULATIONS 'X' WINS");
                isTapped.animate().rotationY(360).setDuration(1000);
                textView.animate().rotationX(360).setDuration(1000).setStartDelay(1000);
            } else if ((win[0] == 1 && win[1] == 1 && win[2] == 1) || (win[3] == 1 && win[4] == 1 && win[5] == 1) || (win[6] == 1 && win[7] == 1 && win[8] == 1)
                    || (win[0] == 1 && win[3] == 1 && win[6] == 1) || (win[1] == 1 && win[4] == 1 && win[7] == 1) || (win[2] == 0 && win[5] == 0 && win[8] == 1)
                    || (win[0] == 1 && win[4] == 1 && win[8] == 1) || (win[8] == 1 && win[4] == 1 && win[0] == 1) || (win[2] == 0 && win[4] == 1 && win[6] == 1) ||
                    (win[6] == 0 && win[4] == 1 && win[2] == 1)) {
                textView.setText("CONGRATULATIONS 'O' WINS");
                isTapped.animate().rotationY(360).setDuration(1000).rotation(1000);
                textView.animate().rotationY(360).setDuration(1000);
            } else {
                textView.setText("CONGRATULATIONS 'O' WINS");
                isTapped.animate().rotationY(360).setDuration(1000);
                textView.animate().rotationY(360).setDuration(1000).setStartDelay(1000);
            }
            LinearLayout layout1 = findViewById(R.id.line1);
            for (int j = 0; j < layout1.getChildCount(); j++) {

                ((ImageView) layout1.getChildAt(j)).setImageResource(R.drawable.yippe);
                layout1.animate().rotationX(360).setDuration(3000).setStartDelay(1000);
            }
            LinearLayout layout2 = findViewById(R.id.line2);
            for (int j = 0; j < layout2.getChildCount(); j++) {

                ((ImageView) layout2.getChildAt(j)).setImageResource(R.drawable.yippe);
                layout2.animate().rotationX(360).setDuration(3000).setStartDelay(1000);
            }
            LinearLayout layout3 = findViewById(R.id.line3);
            for (int j = 0; j < layout3.getChildCount(); j++) {

                ((ImageView) layout3.getChildAt(j)).setImageResource(R.drawable.yippe);
                layout3.animate().rotationX(360).setDuration(3000).setStartDelay(1000);
            }

        }

    }


    private boolean gameOver() {
        if (win[0] == win[1] && win[1] == win[2] || win[3] == win[4] && win[4] == win[5] || win[6] == win[7] && win[7] == win[8]) {
            return true;
        } else if (win[0] == win[3] && win[3] == win[6] || win[1] == win[4] && win[4] == win[7] || win[2] == win[5] && win[5] == win[8]) {
            return true;
        } else
            return win[0] == win[4] && win[4] == win[8] || win[2] == win[4] && win[4] == win[6];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button button = findViewById(R.id.restart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}

