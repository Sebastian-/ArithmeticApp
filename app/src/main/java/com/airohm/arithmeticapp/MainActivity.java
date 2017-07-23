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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();

        currentQuestion = new DivisionQuestion();
        currentQuestion.renderQuestion(inflater, (ViewGroup) findViewById(R.id.question_area));
        currentQuestion.prepAnswerWidgets(inflater, (ViewGroup) findViewById(R.id.answer_area));
        currentInputWidget = currentQuestion.getInputWidget();
    }


    public void numButtonPress(View numButton) {
        Button b = (Button) numButton;
        String input = b.getText().toString();
        if (currentQuestion.checkInput(input)) {
            currentInputWidget.setText(input);
            currentInputWidget = currentQuestion.getInputWidget();
        } else {
            currentInputWidget.setText(b.getText());
            currentInputWidget.setTextColor(Color.RED);
        }
    }
}
