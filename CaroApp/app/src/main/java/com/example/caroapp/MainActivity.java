package com.example.caroapp;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];
    private boolean playerXTurn = true;
    private int[] board = new int[9]; // 0: empty, 1: X, 2: O

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            buttons[i] = (Button) gridLayout.getChildAt(i);
            final int index = i;
            buttons[i].setOnClickListener(v -> onButtonClick(index));
        }

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(v -> resetGame());
    }

    private void onButtonClick(int index) {
        if (board[index] == 0) {
            board[index] = playerXTurn ? 1 : 2;
            buttons[index].setText(playerXTurn ? "X" : "O");
            if (checkWinner()) {
                Toast.makeText(this, "Player " + (playerXTurn ? "X" : "O") + " wins!", Toast.LENGTH_LONG).show();
                disableButtons();
            } else if (isBoardFull()) {
                Toast.makeText(this, "It's a draw!", Toast.LENGTH_LONG).show();
            }
            playerXTurn = !playerXTurn;
        }
    }

    private boolean checkWinner() {
        int[][] winPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}  // diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == board[pos[1]] && board[pos[1]] == board[pos[2]] && board[pos[0]] != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int cell : board) {
            if (cell == 0) {
                return false;
            }
        }
        return true;
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    private void resetGame() {
        playerXTurn = true;
        for (int i = 0; i < board.length; i++) {
            board[i] = 0;
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }
}
