package com.airohm.arithmeticapp;

import java.util.Random;

class SubtractionQuestion extends ArithmeticQuestion {

    SubtractionQuestion() {
        Random random = new Random();

        int minuend = random.nextInt(999) + 1;
        int subtrahend = random.nextInt(minuend) + 1;
        int ans = minuend - subtrahend;

        super.setNum1(minuend);
        super.setNum2(subtrahend);
        super.setAns(new RTLSingleLineAnswer(ans));
        super.setOpString(R.string.subtraction);
        super.setLayoutResource(R.layout.vertical_arithmetic_question);
    }
}
