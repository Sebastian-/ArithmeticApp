package com.airohm.arithmeticapp;

import java.util.Random;

class AdditionQuestion extends ArithmeticQuestion {

    AdditionQuestion() {
        Random random = new Random();

        int addend1 = random.nextInt(999) + 1;
        int addend2 = random.nextInt(addend1) + 1;
        int ans = addend1 + addend2;

        super.setNum1(addend1);
        super.setNum2(addend2);
        super.setAns(new RTLSingleLineAnswer(ans));
        super.setOpString(R.string.addition);
        super.setLayoutResource(R.layout.vertical_arithmetic_question);
    }
}
