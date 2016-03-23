package com.willycode.gdgnumberextraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Tracks the number of players
    int playersNumber = 0;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView) findViewById(R.id.result_textView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Increase the number of players by 1.
     */
    public void incrementPlayers(View v) {
       playersNumber = playersNumber + 1;
        displayPlayerNumber(playersNumber);
    }

    /**
     * Increase the number of players by 50.
     */
    public void increment50Players(View v) {
        playersNumber = playersNumber + 50;
        displayPlayerNumber(playersNumber);
    }

    /**
     * Decrease the number of players by 1.
     */
    public void decrementPlayers(View v) {
        if(playersNumber > 0)
            playersNumber = playersNumber - 1;
        displayPlayerNumber(playersNumber);
    }

    /**
     * Resets the number of players back to 0.
     */
    public void resetPlayerNumber(View v) {
        playersNumber = 0;
        displayPlayerNumber(playersNumber);
        resultView.setText("");
    }

    /**
     * Number extraction.
     */
    public void extractWinner(View v) {
        if(playersNumber > 1) {
            int winner = (int) Math.random() * playersNumber;
            //Using Random class in Java.
            Random rand = new Random();
            // For 1 to 50: rand.nextInt(50) + 1;
            displayResult(rand.nextInt(playersNumber) + 1);
        }
        else
        {
          displayError();
        }
    }

    /**
     * Displays the error.
     */
    private void displayError() {

        String result = "...............We need at least 2 players to extract a winner...........";
        resultView.setText(result);
    }

    /**
     * Displays the result.
     */
    private void displayResult(int number) {
        String result = "And the Winner is .........\n"+"Player "+number;
        resultView.setText(result);
    }

    /**
     * Displays the given players number.
     */
    private void displayPlayerNumber(int number) {
            TextView numberView = (TextView) findViewById(R.id.player_number_textView);
            numberView.setText(String.valueOf(number));
    }
}
