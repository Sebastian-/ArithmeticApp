package com.airohm.arithmeticapp;

import java.util.Random;

/**
 * Created by Sebastian on 2017-07-26.
 */

class MultiplicationQuestion extends VerticalArithmeticQuestion {

    MultiplicationQuestion() {
        Random random = new Random();

        int factor1 = random.nextInt(9999) + 1;
        int factor2 = random.nextInt(9) + 1;
        int ans = factor1 * factor2;

        super.setTopNumber(Integer.toString(factor1));
        super.setBottomNumber(Integer.toString(factor2));
        super.setAns(Integer.toString(ans).toCharArray());
        super.setOpString(R.string.multiplication);
    }
}
