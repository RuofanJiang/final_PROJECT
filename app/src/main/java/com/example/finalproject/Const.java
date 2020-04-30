package com.example.finalproject;

import android.graphics.Color;

public class Const {

    public static final int getTextColor(int value) {

        if (value == 0) {

            return 0xffffffff;

        } else if (value == 2) {

            return 0xffeee4da;

        } else if (value == 4) {

            return 0xffede0c8;

        } else if (value == 8) {

            return 0xfff2b179;

        } else if (value == 16) {

            return 0xfff59563;

        } else if (value == 32) {

            return 0xfff67c5f;

        } else if (value == 64) {

            return 0xfff65e3b;

        } else if (value == 128) {

            return 0xffedcf72;

        } else {

            return 0xff000000;

        }

    }
}

