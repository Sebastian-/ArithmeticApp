package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2017-07-29.
 */

public class LTRSingleLineAnswer implements AnswerInputManager {

    private char[] answer;
    private ArrayList<TextView> answerWidgets;
    private int answerIndex;

    LTRSingleLineAnswer(int answer) {
        this.answer = Integer.toString(answer).toCharArray();
        answerIndex = 0;
        answerWidgets = new ArrayList<>();
    }

    public TextView getCurrentInputWidget() {
        return answerWidgets.get(answerIndex);
    }

    public void insertAnswerWidgets(LayoutInflater inflater, ViewGroup answerArea) {
        for (char c : answer) {
            TextView inputWidget = (TextView) inflater.inflate(R.layout.digit_widget, answerArea, false);
            answerArea.addView(inputWidget);
            answerWidgets.add(inputWidget);
        }
    }

    public boolean checkInput(String input) {
        if (answerIndex < answer.length && String.valueOf(answer[answerIndex]).equals(input)) {
            answerIndex++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnswered() {
        return (answerIndex == answer.length);
    }
}
