package com.airohm.arithmeticapp;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2017-07-22.
 */

public class DivisionHolder {

    protected View question;
    protected TextView num1;
    protected TextView num2;
    protected ArrayList<TextView> answer;

    DivisionHolder(View question){
        this.question = question;
        this.num1 = (TextView) question.findViewById(R.id.num1);
        this.num2 = (TextView) question.findViewById(R.id.num2);
        answer = new ArrayList<TextView>();
    }
}
