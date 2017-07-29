package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


abstract class ArithmeticQuestion implements Question {
    private String num1;
    private String num2;
    private int opStringResource;
    private int layoutResource;
    private AnswerInputManager ans;

    public View renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View arithmeticQuestion = inflater.inflate(layoutResource, questionArea, false);

        TextView topNumber = (TextView) arithmeticQuestion.findViewById(R.id.num1);
        topNumber.setText(this.num1);
        TextView bottomNumber = (TextView) arithmeticQuestion.findViewById(R.id.num2);
        bottomNumber.setText(this.num2);
        TextView operation = (TextView) arithmeticQuestion.findViewById(R.id.operation);
        operation.setText(opStringResource);

        ViewGroup answerArea = (ViewGroup) arithmeticQuestion.findViewById(R.id.answer_area);
        ans.insertAnswerWidgets(inflater, answerArea);

        return arithmeticQuestion;
    }

    public TextView getInputDisplayWidget() {
        return ans.getCurrentInputWidget();
    }

    public boolean checkInput(String input) {
        return ans.checkInput(input);
    }

    public boolean isAnswered() {
        return ans.isAnswered();
    }

    void setNum1(int num1) {
        this.num1 = Integer.toString(num1);
    }

    void setNum2(int num2) {
        this.num2 = Integer.toString(num2);
    }

    void setOpString(int opStringResource) {
        this.opStringResource = opStringResource;
    }

    void setLayoutResource(int layoutResource) { this.layoutResource = layoutResource; }

    void setAns(AnswerInputManager ans) { this.ans = ans; }
}
