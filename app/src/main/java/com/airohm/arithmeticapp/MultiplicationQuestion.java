package com.airohm.arithmeticapp;

import java.util.Random;

class MultiplicationQuestion extends ArithmeticQuestion {

    MultiplicationQuestion() {
        Random random = new Random();

        int factor1 = random.nextInt(999) + 1;
        int factor2 = random.nextInt(9) + 1;
        int ans = factor1 * factor2;

        super.setNum1(factor1);
        super.setNum2(factor2);
        super.setAns(new RTLSingleLineAnswer(ans));
        super.setOpString(R.string.multiplication);
        super.setLayoutResource(R.layout.vertical_arithmetic_question);
    }
}
