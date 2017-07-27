package com.airohm.arithmeticapp;

import java.util.Random;

/**
 * Created by Sebastian on 2017-07-26.
 */

class AdditionQuestion extends VerticalArithmeticQuestion {

    AdditionQuestion() {
        Random random = new Random();

        int addend1 = random.nextInt(9999) + 1;
        int addend2 = random.nextInt(addend1) + 1;
        int ans = addend1 + addend2;

        super.setTopNumber(Integer.toString(addend1));
        super.setBottomNumber(Integer.toString(addend2));
        super.setAns(Integer.toString(ans).toCharArray());
        super.setOpString(R.string.addition);
    }
}
