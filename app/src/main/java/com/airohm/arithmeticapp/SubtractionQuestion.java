package com.airohm.arithmeticapp;

import java.util.Random;

/**
 * Created by Sebastian on 2017-07-26.
 */

class SubtractionQuestion extends VerticalArithmeticQuestion {

    SubtractionQuestion() {
        Random random = new Random();

        int minuend = random.nextInt(9999) + 1;
        int subtrahend = random.nextInt(minuend) + 1;
        int ans = minuend - subtrahend;

        super.setTopNumber(Integer.toString(minuend));
        super.setBottomNumber(Integer.toString(subtrahend));
        super.setAns(Integer.toString(ans).toCharArray());
        super.setOpString(R.string.subtraction);
    }
}
