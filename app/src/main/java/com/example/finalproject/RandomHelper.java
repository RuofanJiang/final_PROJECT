package com.example.finalproject;

import java.util.ArrayList;
import java.util.Random;

public class RandomHelper {

    private static Random random = new Random();

    public static int random(int max) {

        return random.nextInt(max);

    }

    public static Block randomBlock(ArrayList<Block> list) {

        return list.get(random(list.size()));

    }

}

