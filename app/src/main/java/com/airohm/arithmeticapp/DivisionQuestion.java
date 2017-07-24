package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


class DivisionQuestion {

    private String dividend;
    private String divisor;
    private char[] ans;
    private int answerIndex;
    private DivisionHolder UIHolder;


    // To avoid any GUI issues and make questions manageable, the divisor is limited to 1 digit,
    // and the answer to 3
    DivisionQuestion() {
        Random random = new Random();

        int divisor = random.nextInt(9) + 1;
        int answer = random.nextInt(999) + 1;
        int dividend = divisor * answer;

        this.dividend = Integer.toString(dividend);
        this.divisor = Integer.toString(divisor);
        ans = Integer.toString(answer).toCharArray();
        answerIndex = 0;
    }

    View renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View question = inflater.inflate(R.layout.division, questionArea);

        DivisionHolder holder = new DivisionHolder(question);
        question.setTag(holder);
        holder.question = question;
        holder.num1.setText(dividend);
        holder.num2.setText(divisor);
        UIHolder = holder;

        return question;
    }

    void prepAnswerWidgets(LayoutInflater inflater, ViewGroup answerArea) {
        for (char c : ans) {
            TextView answerWidget = (TextView) inflater.inflate(R.layout.input_widget, answerArea, false);
            answerArea.addView(answerWidget);
            UIHolder.answer.add(answerWidget);
        }
    }

    TextView getInputWidget() {
        return UIHolder.answer.get(answerIndex);
    }

    boolean checkInput(String input) {
        if (answerIndex < ans.length && String.valueOf(ans[answerIndex]).equals(input)) {
            answerIndex++;
            return true;
        } else {
            return false;
        }
    }

    boolean isAnswered() {
        return (answerIndex == ans.length);
    }

}
