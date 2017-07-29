package com.airohm.arithmeticapp;

import java.util.Random;


class DivisionQuestion extends ArithmeticQuestion {

    // To avoid any GUI issues and make questions manageable, the divisor is limited to 1 digit,
    // and the answer to 2
    DivisionQuestion() {
        Random random = new Random();

        int divisor = random.nextInt(9) + 1;
        int ans = random.nextInt(99) + 1;
        int dividend = divisor * ans;

        super.setNum1(dividend);
        super.setNum2(divisor);
        super.setAns(new LTRSingleLineAnswer(ans));
        super.setLayoutResource(R.layout.division);
        super.setOpString(R.string.division);
    }

}
