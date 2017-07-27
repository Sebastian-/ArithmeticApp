package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2017-07-26.
 */

abstract class VerticalArithmeticQuestion implements Question {
    private String topNumber;
    private String bottomNumber;
    private int opStringResource;
    private char[] ans;
    private ArrayList<TextView> answerWidgets = new ArrayList<>();
    private int answerIndex;

    public View renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View subtractionQuestion = inflater.inflate(R.layout.vertical_arithmetic_question, questionArea, false);

        TextView topNumber = (TextView) subtractionQuestion.findViewById(R.id.topNumber);
        topNumber.setText(this.topNumber);
        TextView bottomNumber = (TextView) subtractionQuestion.findViewById(R.id.bottomNumber);
        bottomNumber.setText(this.bottomNumber);
        TextView operation = (TextView) subtractionQuestion.findViewById(R.id.operation);
        operation.setText(opStringResource);

        subtractionQuestion.findViewById(R.id.separator).setBackgroundColor(topNumber.getTextColors().getDefaultColor());

        ViewGroup answerArea = (ViewGroup) subtractionQuestion.findViewById(R.id.answer_area);

        for (char c : ans) {
            TextView inputWidget = (TextView) inflater.inflate(R.layout.digit_widget, answerArea, false);
            answerArea.addView(inputWidget);
            answerWidgets.add(inputWidget);
        }

        return subtractionQuestion;
    }

    public TextView getInputDisplayWidget() {
        return answerWidgets.get(answerIndex);
    }

    public boolean checkInput(String input) {
        if (answerIndex >= 0 && String.valueOf(ans[answerIndex]).equals(input)) {
            answerIndex--;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnswered() {
        return answerIndex < 0;
    }

    void setTopNumber(String topNumber) {
        this.topNumber = topNumber;
    }

    void setBottomNumber(String bottomNumber) {
        this.bottomNumber = bottomNumber;
    }

    void setOpString(int opStringResource) {
        this.opStringResource = opStringResource;
    }

    void setAns(char[] ans) {
        this.ans = ans;
        this.answerIndex = ans.length - 1;
    }
}
