package com.airohm.arithmeticapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView currentInputWidget;
    DivisionQuestion currentQuestion;
    //TODO move answerIndex into question class, make calls to checkInput update accordingly
    int answerIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();

        currentQuestion = new DivisionQuestion();
        currentQuestion.renderQuestion(inflater, (ViewGroup) findViewById(R.id.question_area));
        currentQuestion.prepAnswerWidgets(inflater, (ViewGroup) findViewById(R.id.answer_area));
        currentInputWidget = currentQuestion.getInputWidget(answerIndex);
    }


    //TODO check for out of bounds for answer index
    public void numButtonPress(View numButton) {
        Button b = (Button) numButton;
        String input = b.getText().toString();
        if (currentQuestion.checkInput(input, answerIndex)) {
            currentInputWidget.setText(input);
            answerIndex++;
            currentInputWidget = currentQuestion.getInputWidget(answerIndex);
        } else {
            currentInputWidget.setText(b.getText());
            currentInputWidget.setTextColor(Color.RED);
        }
    }
}
