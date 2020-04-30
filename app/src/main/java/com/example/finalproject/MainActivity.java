package com.example.finalproject;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ArrayList<Block>> grid;
    private static TextView zeroZero;
    private static TextView zeroOne;
    private static TextView zeroTwo;
    private static TextView zeroThree;
    private static TextView oneZero;
    private static TextView oneOne;
    private static TextView oneTwo;
    private static TextView oneThree;
    private static TextView twoZero;
    private static TextView twoOne;
    private static TextView twoTwo;
    private static TextView twoThree;
    private static TextView threeZero;
    private static TextView threeOne;
    private static TextView threeTwo;
    private static TextView threeThree;
    private static Button newgame;
    private static Button left;
    private static Button right;
    private static Button up;
    private static Button down;
    private static int score;
    private static TextView scoreBoard;
    private static TextView annoucement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        grid = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            grid.add(new ArrayList(4));
        }
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                grid.get(i).add(new Block(0));
            }
        }
        zeroZero = findViewById(R.id.zeroZero);
        zeroOne = findViewById(R.id.zeroOne);
        zeroTwo = findViewById(R.id.zeroTwo);
        zeroThree = findViewById(R.id.zeroThree);
        oneZero = findViewById(R.id.oneZero);
        oneOne = findViewById(R.id.oneOne);
        oneTwo = findViewById(R.id.oneTwo);
        oneThree = findViewById(R.id.oneThree);
        twoZero = findViewById(R.id.twoZero);
        twoOne = findViewById(R.id.twoOne);
        twoTwo = findViewById(R.id.twoTwo);
        twoThree = findViewById(R.id.twoThree);
        threeZero = findViewById(R.id.threeZero);
        threeOne= findViewById(R.id.threeOne);
        threeTwo = findViewById(R.id.threeTwo);
        threeThree = findViewById(R.id.threeThree);
        newgame = findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                startNewGame();
            }
        } );
        left = findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                onAction("left");
            }
        } );
        right = findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                onAction("right");
            }
        } );
        up = findViewById(R.id.up);
        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                onAction("up");
            }
        } );
        down = findViewById(R.id.down);
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                onAction("down");
            }
        } );
        scoreBoard = findViewById(R.id.scoreBoard);
        annoucement = findViewById(R.id.annoucement);
    }
    public static void startNewGame() {
        // Erase the current grid and modify all blocks to 0.
        score = 0;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                grid.get(i).get(j).setValue(0);

            }

        }
        left.setVisibility(View.VISIBLE);
        right.setVisibility(View.VISIBLE);
        up.setVisibility(View.VISIBLE);
        down.setVisibility(View.VISIBLE);
        annoucement.setText("");
        grid.get(RandomHelper.random(4)).get(RandomHelper.random(4)).upgrade();
        grid.get(RandomHelper.random(4)).get(RandomHelper.random(4)).upgrade();


        updateGrids();

    }
    public static void youwin() {
        left.setVisibility(View.GONE);
        right.setVisibility(View.GONE);
        up.setVisibility(View.GONE);
        down.setVisibility(View.GONE);
        annoucement.setText("You win!");
    }
    public static void youloss() {
        left.setVisibility(View.GONE);
        right.setVisibility(View.GONE);
        up.setVisibility(View.GONE);
        down.setVisibility(View.GONE);
        annoucement.setText("You lose!");
    }

    public static void updateGrids() {
        scoreBoard.setText(String.valueOf(score));
        zeroZero.setText(String.valueOf(grid.get(0).get(0).getValue()));
        zeroOne.setText(String.valueOf(grid.get(0).get(1).getValue()));
        zeroTwo.setText(String.valueOf(grid.get(0).get(2).getValue()));
        zeroThree.setText(String.valueOf(grid.get(0).get(3).getValue()));
        oneZero.setText(String.valueOf(grid.get(1).get(0).getValue()));
        oneOne.setText(String.valueOf(grid.get(1).get(1).getValue()));
        oneTwo.setText(String.valueOf(grid.get(1).get(2).getValue()));
        oneThree.setText(String.valueOf(grid.get(1).get(3).getValue()));
        twoZero.setText(String.valueOf(grid.get(2).get(0).getValue()));
        twoOne.setText(String.valueOf(grid.get(2).get(1).getValue()));
        twoTwo.setText(String.valueOf(grid.get(2).get(2).getValue()));
        twoThree.setText(String.valueOf(grid.get(2).get(3).getValue()));
        threeZero.setText(String.valueOf(grid.get(3).get(0).getValue()));
        threeOne.setText(String.valueOf(grid.get(3).get(1).getValue()));
        threeTwo.setText(String.valueOf(grid.get(3).get(2).getValue()));
        threeThree.setText(String.valueOf(grid.get(3).get(3).getValue()));
        zeroZero.setBackgroundColor(grid.get(0).get(0).getColor());
        zeroOne.setBackgroundColor(grid.get(0).get(1).getColor());
        zeroTwo.setBackgroundColor(grid.get(0).get(2).getColor());
        zeroThree.setBackgroundColor(grid.get(0).get(3).getColor());
        oneZero.setBackgroundColor(grid.get(1).get(0).getColor());
        oneOne.setBackgroundColor(grid.get(1).get(1).getColor());
        oneTwo.setBackgroundColor(grid.get(1).get(2).getColor());
        oneThree.setBackgroundColor(grid.get(1).get(3).getColor());
        twoZero.setBackgroundColor(grid.get(2).get(0).getColor());
        twoOne.setBackgroundColor(grid.get(2).get(1).getColor());
        twoTwo.setBackgroundColor(grid.get(2).get(2).getColor());
        twoThree.setBackgroundColor(grid.get(2).get(3).getColor());
        threeZero.setBackgroundColor(grid.get(3).get(0).getColor());
        threeOne.setBackgroundColor(grid.get(3).get(1).getColor());
        threeTwo.setBackgroundColor(grid.get(3).get(2).getColor());
        threeThree.setBackgroundColor(grid.get(3).get(3).getColor());
    }

    public static void onAction(String direction) {

        if (direction.equals("right")) {

            moveAllToRight();
            combineRight();
            RandomHelper.randomBlock(getEmptyBlocks()).upgrade();
            updateGrids();

        } else if (direction.equals("left")) {

            moveAllToLeft();
            combineLeft();
            RandomHelper.randomBlock(getEmptyBlocks()).upgrade();
            updateGrids();

        } else if (direction.equals("up")) {

            moveAllToUp();
            combineUp();
            RandomHelper.randomBlock(getEmptyBlocks()).upgrade();
            updateGrids();

        } else if (direction.equals("down")) {

            moveAllToDown();
            combineDown();
            RandomHelper.randomBlock(getEmptyBlocks()).upgrade();
            updateGrids();

        }

    }

    public static void moveAllToRight() {

        if (allToRight()) {

            return;

        } else {

            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < 3; j++) {

                    if (grid.get(i).get(j).getValue() != 0 && grid.get(i).get(j + 1).getValue() == 0) {

                        // Swap.

                        grid.get(i).get(j + 1).setValue(grid.get(i).get(j).getValue());
                        grid.get(i).get(j).setValue(0);

                    }

                }

            }

            moveAllToRight();

        }

    }

    public static boolean allToRight() {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 3; j++) {

                if (grid.get(i).get(j).getValue() != 0 && grid.get(i).get(j + 1).getValue() == 0) {

                    return false;

                }

            }

        }

        return true;

    }

    public static void moveAllToLeft() {

        if (allToLeft()) {

            return;

        } else {

            for (int i = 0; i < 4; i++) {

                for (int j = 1; j < 4; j++) {

                    if (grid.get(i).get(j).getValue() != 0 && grid.get(i).get(j - 1).getValue() == 0) {

                        // Swap.

                        grid.get(i).get(j - 1).setValue(grid.get(i).get(j).getValue());
                        grid.get(i).get(j).setValue(0);

                    }

                }

            }

            moveAllToLeft();

        }

    }

    public static boolean allToLeft() {

        for (int i = 0; i < 4; i++) {

            for (int j = 1; j < 4; j++) {

                if (grid.get(i).get(j).getValue() != 0 && grid.get(i).get(j - 1).getValue() == 0) {

                    return false;

                }

            }

        }

        return true;

    }

    public static void moveAllToUp() {

        if (allToUp()) {

            return;

        } else {

            for (int i = 1; i < 4; i++) {

                for (int j = 0; j < 4; j++) {

                    if (grid.get(i).get(j).getValue() != 0 && grid.get(i - 1).get(j).getValue() == 0) {

                        // Swap.

                        grid.get(i - 1).get(j).setValue(grid.get(i).get(j).getValue());
                        grid.get(i).get(j).setValue(0);

                    }

                }

            }

            moveAllToUp();

        }

    }

    public static boolean allToUp() {

        for (int i = 1; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (grid.get(i).get(j).getValue() != 0 && grid.get(i - 1).get(j).getValue() == 0) {

                    return false;

                }

            }

        }

        return true;

    }

    public static void moveAllToDown() {

        if (allToDown()) {

            return;

        } else {

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 4; j++) {

                    if (grid.get(i).get(j).getValue() != 0 && grid.get(i + 1).get(j).getValue() == 0) {

                        // Swap.

                        grid.get(i + 1).get(j).setValue(grid.get(i).get(j).getValue());
                        grid.get(i).get(j).setValue(0);

                    }

                }

            }

            moveAllToDown();

        }

    }

    public static boolean allToDown() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {

                if (grid.get(i).get(j).getValue() != 0 && grid.get(i + 1).get(j).getValue() == 0) {

                    return false;

                }

            }

        }

        return true;

    }

    public static void combineRight() {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 3; j++) {

                if (grid.get(i).get(j).getValue() != 0 &&
                        (grid.get(i).get(j).getValue() == grid.get(i).get(j + 1).getValue())) {

                    grid.get(i).get(j + 1).upgrade();
                    grid.get(i).get(j).setValue(0);
                    moveAllToRight();
                    score += grid.get(i).get(j + 1).getValue();
                    if (grid.get(i).get(j + 1).getValue() == 128) {
                        youwin();
                    }
                }

            }

        }

    }

    public static void combineLeft() {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 3; j++) {

                if (grid.get(i).get(j).getValue() != 0 &&
                        (grid.get(i).get(j).getValue() == grid.get(i).get(j + 1).getValue())) {

                    grid.get(i).get(j).upgrade();
                    grid.get(i).get(j + 1).setValue(0);
                    moveAllToLeft();
                    score += grid.get(i).get(j).getValue();
                    if (grid.get(i).get(j).getValue() == 128) {
                        youwin();
                    }
                }

            }

        }

    }

    public static void combineUp() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {

                if (grid.get(i).get(j).getValue() != 0 &&
                        (grid.get(i).get(j).getValue() == grid.get(i + 1).get(j).getValue())) {

                    grid.get(i).get(j).upgrade();
                    grid.get(i + 1).get(j).setValue(0);
                    moveAllToUp();
                    score += grid.get(i).get(j).getValue();
                    if (grid.get(i).get(j).getValue() == 128) {
                        youwin();
                    }
                }

            }

        }

    }

    public static void combineDown() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {

                if (grid.get(i).get(j).getValue() != 0 &&
                        (grid.get(i).get(j).getValue() == grid.get(i + 1).get(j).getValue())) {

                    grid.get(i).get(j).upgrade();
                    grid.get(i + 1).get(j).setValue(0);
                    score += grid.get(i).get(j).getValue();
                    if (grid.get(i).get(j).getValue() == 128) {
                        youwin();
                    }
                    moveAllToDown();
                }

            }

        }

    }


    public static ArrayList<Block> getEmptyBlocks() {

        ArrayList<Block> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (grid.get(i).get(j).getValue() == 0) {

                    list.add(grid.get(i).get(j));

                }

            }

        }

        return list;

    }

}
