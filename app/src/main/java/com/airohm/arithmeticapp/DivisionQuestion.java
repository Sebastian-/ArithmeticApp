package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Sebastian on 2017-07-18.
 */

public class DivisionQuestion {

    private String dividend;
    private String divisor;
    private char[] ans;
    private DivisionHolder UIholder;

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
    }

    public View renderQuestion(LayoutInflater inflater, ViewGroup questionArea) {
        View question = inflater.inflate(R.layout.division, questionArea);

        DivisionHolder holder = new DivisionHolder(question);
        question.setTag(holder);
        holder.question = question;
        holder.num1.setText(dividend);
        holder.num2.setText(divisor);
        UIholder = holder;

        return question;
    }

    public void prepAnswerWidgets(LayoutInflater inflater, ViewGroup answerArea) {
        for (char c : ans) {
            TextView answerWidget = (TextView) inflater.inflate(R.layout.answer_widget, answerArea, false);
            answerArea.addView(answerWidget);
            UIholder.answer.add(answerWidget);
        }
    }

    public TextView getInputWidget(int index) {
        return UIholder.answer.get(index);
    }

    //TODO check for bounds for answer index
    public boolean checkInput(String input, int answerIndex) {
        if (answerIndex < ans.length) {
            return String.valueOf(ans[answerIndex]).equals(input);
        } else {
            return false;
        }

    }

}
