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

class MultiplicationQuestion implements Question {

    private String factor1;
    private String factor2;
    private char[] ans;
    private ArrayList<TextView> answerWidgets;
    private int answerIndex;

    public MultiplicationQuestion() {
        Random random = new Random();

        int factor1 = random.nextInt(9999) + 1;
        int factor2 = random.nextInt(9) + 1;
        int ans = factor1 * factor2;

        this.factor1 = Integer.toString(factor1);
        this.factor2 = Integer.toString(factor2);
        this.ans = Integer.toString(ans).toCharArray();
        answerWidgets = new ArrayList<>();
        // vertical arithmetic questions are answered from right to left
        answerIndex = this.ans.length - 1;
    }

    public void renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View multiplicationQuestion = inflater.inflate(R.layout.vertical_arithmetic_question, questionArea);

        TextView factor1 = (TextView) multiplicationQuestion.findViewById(R.id.topNumber);
        factor1.setText(this.factor1);
        TextView factor2 = (TextView) multiplicationQuestion.findViewById(R.id.bottomNumber);
        factor2.setText(this.factor2);
        TextView operation = (TextView) multiplicationQuestion.findViewById(R.id.operation);
        operation.setText(R.string.multiplication);

        multiplicationQuestion.findViewById(R.id.separator).setBackgroundColor(factor1.getTextColors().getDefaultColor());

        prepInputWidgets(inflater, (ViewGroup) multiplicationQuestion.findViewById(R.id.answer_area));
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
