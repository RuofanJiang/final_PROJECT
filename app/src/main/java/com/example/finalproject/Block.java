package com.example.finalproject;

import android.graphics.Color;

public class Block {

    private int value;
    private int color;

    public Block(int setValue) {

        value = setValue;
        color = Const.getTextColor(value);

    }

    public int getValue() {

        return value;

    }

    public int getColor() {

        return color;

    }

    public void setValue(int setValue) {

        value = setValue;
        color = Const.getTextColor(value);

    }

    public void upgrade() {

        if (value == 0) {

            value = 2;
            color = Const.getTextColor(value);

        } else {

            value *= 2;
            color = Const.getTextColor(value);

        }
    }

}

