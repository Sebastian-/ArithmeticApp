package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


class DivisionQuestion implements Question {

    private String dividend;
    private String divisor;
    private char[] ans;
    private ArrayList<TextView> answerWidgets;
    private int answerIndex;


    // To avoid any GUI issues and make questions manageable, the divisor is limited to 1 digit,
    // and the answer to 3
    public DivisionQuestion() {
        Random random = new Random();

        int divisor = random.nextInt(9) + 1;
        int answer = random.nextInt(999) + 1;
        int dividend = divisor * answer;

        this.dividend = Integer.toString(dividend);
        this.divisor = Integer.toString(divisor);
        ans = Integer.toString(answer).toCharArray();
        answerWidgets = new ArrayList<>();
        answerIndex = 0;
    }

    public void renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View divisionQuestion = inflater.inflate(R.layout.division, questionArea);

        TextView dividend = (TextView) divisionQuestion.findViewById(R.id.dividend);
        dividend.setText(this.dividend);
        TextView divisor = (TextView) divisionQuestion.findViewById(R.id.divisor);
        divisor.setText(this.divisor);

        prepInputWidgets(inflater, (ViewGroup) divisionQuestion.findViewById(R.id.answer_area));
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
        if (answerIndex < ans.length && String.valueOf(ans[answerIndex]).equals(input)) {
            answerIndex++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnswered() {
        return (answerIndex == ans.length);
    }

}
