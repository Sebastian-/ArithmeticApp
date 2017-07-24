package com.airohm.arithmeticapp;

import android.content.res.ColorStateList;
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
    ColorStateList defaultTextColors;
    ViewGroup questionArea;
    ViewGroup answerArea;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();
        questionArea = (ViewGroup) findViewById(R.id.question_area);
        assembleQuestion();
        defaultTextColors = currentInputWidget.getTextColors();
    }

    public void numButtonPress(View numButton) {
        Button b = (Button) numButton;
        String input = b.getText().toString();
        if (currentQuestion.checkInput(input)) {
            // Input is correct
            currentInputWidget.setTextColor(defaultTextColors);
            currentInputWidget.setText(input);
            if (currentQuestion.isAnswered()) {
                questionArea.removeAllViews();
                assembleQuestion();
            }
            currentInputWidget = currentQuestion.getInputWidget();
        } else {
            currentInputWidget.setText(b.getText());
            currentInputWidget.setTextColor(Color.RED);
        }
    }

    private void assembleQuestion() {
        currentQuestion = new DivisionQuestion();
        currentQuestion.renderQuestion(inflater, questionArea);
        answerArea = (ViewGroup) findViewById(R.id.answer_area);
        currentQuestion.prepAnswerWidgets(inflater, answerArea);
        currentInputWidget = currentQuestion.getInputWidget();
    }
}
