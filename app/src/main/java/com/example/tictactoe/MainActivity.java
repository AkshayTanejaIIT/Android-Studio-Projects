package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0: 0, 1:x, 2: no
    int curr_player = 0;
    int[] curr_state = {2,2,2,2,2,2,2,2,2};

    boolean gameActive = true;

    public void clicked(View V)
    {
        if(gameActive == false)
        {
            gameActive = true;
            for(int i=0;i<9;++i) curr_state[i] = 2;
            curr_player = 0;

            TextView tv = findViewById(R.id.status);
            tv.setText("Player 0's turn");

            ImageView img = (ImageView) findViewById(R.id.imageView1);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView2);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView3);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView4);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView5);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView6);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView7);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView8);
            img.setImageResource(0);

            img = (ImageView) findViewById(R.id.imageView9);
            img.setImageResource(0);

            return;
        }
        ImageView img = (ImageView) V;
        int id = Integer.parseInt(img.getTag().toString().substring(1));
        if(curr_state[id] != 2)
        {
            Toast.makeText(this, "Can't move here..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            curr_state[id] = curr_player;
            if(curr_player == 0) {
                img.setImageResource(R.drawable.zero);
                curr_player = 1;
                TextView tv = findViewById(R.id.status);
                tv.setText("Player X's turn");
            }
            else
            {
                img.setImageResource(R.drawable.cross);
                curr_player = 0;
                TextView tv = findViewById(R.id.status);
                tv.setText("Player 0's turn");
            }

            if(curr_state[0] == curr_state[1] && curr_state[1]==curr_state[2]
                && curr_state[2] != 2) gameActive = false;
            if(curr_state[3] == curr_state[4] && curr_state[3]==curr_state[5]
                    && curr_state[3] != 2) gameActive = false;
            if(curr_state[6] == curr_state[7] && curr_state[6]==curr_state[8]
                    && curr_state[6] != 2) gameActive = false;
            if(curr_state[0] == curr_state[3] && curr_state[3]==curr_state[6]
                    && curr_state[0] != 2) gameActive = false;
            if(curr_state[1] == curr_state[4] && curr_state[1]==curr_state[7]
                    && curr_state[1] != 2) gameActive = false;
            if(curr_state[2] == curr_state[5] && curr_state[8]==curr_state[2]
                    && curr_state[2] != 2) gameActive = false;
            if(curr_state[0] == curr_state[4] && curr_state[0]==curr_state[8]
                    && curr_state[0] != 2) gameActive = false;
            if(curr_state[2] == curr_state[4] && curr_state[6]==curr_state[2]
                    && curr_state[2] != 2) gameActive = false;

            if(curr_state[0] != 2 && curr_state[1] != 2 && curr_state[2] != 2
                    && curr_state[3] != 2 && curr_state[4] != 2 && curr_state[5] != 2
                    && curr_state[6] != 2 && curr_state[7] != 2 && curr_state[8] != 2)
            {
                gameActive = false;
                TextView tv = findViewById(R.id.status);
                tv.setText("Game Draw. Tap grid to reboot");
                //continue;
            }
            else if(gameActive == false)
            {
                TextView tv = findViewById(R.id.status);
                if(curr_player == 0) tv.setText("Player X has won. Tap grid to reboot");
                if(curr_player == 1) tv.setText("Player 0 has won. Tap grid to reboot");
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}