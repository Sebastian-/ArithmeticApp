package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sebastian on 2017-07-24.
 */

class SubtractionQuestion implements Question {

    private String minuend;
    private String subtrahend;
    private char[] ans;
    private ArrayList<TextView> answerWidgets;
    private int answerIndex;

    public SubtractionQuestion() {
        Random random = new Random();

        int minuend = random.nextInt(9999) + 1;
        int subtrahend = random.nextInt(minuend) + 1;
        int ans = minuend - subtrahend;

        this.minuend = Integer.toString(minuend);
        this.subtrahend = Integer.toString(subtrahend);
        this.ans = Integer.toString(ans).toCharArray();
        answerWidgets = new ArrayList<>();
        // vertical_arithmetic_question questions are answered from right to left
        answerIndex = this.ans.length - 1;
    }

    public void renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View subtractionQuestion = inflater.inflate(R.layout.vertical_arithmetic_question, questionArea);

        TextView minuend = (TextView) subtractionQuestion.findViewById(R.id.topNumber);
        minuend.setText(this.minuend);
        TextView subtrahend = (TextView) subtractionQuestion.findViewById(R.id.bottomNumber);
        subtrahend.setText(this.subtrahend);
        TextView operation = (TextView) subtractionQuestion.findViewById(R.id.operation);
        operation.setText(R.string.subtraction);

        subtractionQuestion.findViewById(R.id.separator).setBackgroundColor(minuend.getTextColors().getDefaultColor());

        prepInputWidgets(inflater, (ViewGroup) subtractionQuestion.findViewById(R.id.answer_area));
    }

    private void prepInputWidgets(LayoutInflater inflater, ViewGroup answerArea) {
        for (char c : ans) {
            TextView inputWidget = (TextView) inflater.inflate(R.layout.digit_widget, answerArea, false);
            answerArea.addView(inputWidget);
            answerWidgets.add(inputWidget);
        }
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
}
