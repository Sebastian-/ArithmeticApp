package com.airohm.arithmeticapp;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


class DivisionHolder {

    View question;
    TextView num1;
    TextView num2;
    ArrayList<TextView> answer;

    DivisionHolder(View question){
        this.question = question;
        this.num1 = (TextView) question.findViewById(R.id.num1);
        this.num2 = (TextView) question.findViewById(R.id.num2);
        answer = new ArrayList<>();
    }
}
