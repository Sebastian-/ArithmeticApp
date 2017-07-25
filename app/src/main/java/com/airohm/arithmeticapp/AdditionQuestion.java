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

class AdditionQuestion implements Question {

    private String addend1;
    private String addend2;
    private char[] ans;
    private ArrayList<TextView> answerWidgets;
    private int answerIndex;

    public AdditionQuestion() {
        Random random = new Random();

        int addend1 = random.nextInt(9999) + 1;
        int addend2 = random.nextInt(addend1) + 1;
        int ans = addend1 + addend2;

        this.addend1 = Integer.toString(addend1);
        this.addend2 = Integer.toString(addend2);
        this.ans = Integer.toString(ans).toCharArray();
        answerWidgets = new ArrayList<>();
        // vertical arithmetic questions are answered from right to left
        answerIndex = this.ans.length - 1;
    }

    public void renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View additionQuestion = inflater.inflate(R.layout.vertical_arithmetic_question, questionArea);

        TextView addend1 = (TextView) additionQuestion.findViewById(R.id.topNumber);
        addend1.setText(this.addend1);
        TextView addend2 = (TextView) additionQuestion.findViewById(R.id.bottomNumber);
        addend2.setText(this.addend2);
        TextView operation = (TextView) additionQuestion.findViewById(R.id.operation);
        operation.setText(R.string.addition);

        additionQuestion.findViewById(R.id.separator).setBackgroundColor(addend1.getTextColors().getDefaultColor());

        prepInputWidgets(inflater, (ViewGroup) additionQuestion.findViewById(R.id.answer_area));
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
