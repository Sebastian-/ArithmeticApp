package com.airohm.arithmeticapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView currentInputWidget;
    private View questionView;
    private Question currentQuestion;
    private int defaultTextColor;
    private ViewGroup questionArea;
    // used to suspend input while an animation is taking place
    private boolean suspendInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionArea = (ViewGroup) findViewById(R.id.question_area);
        setupQuestion();
        defaultTextColor = currentInputWidget.getTextColors().getDefaultColor();
    }

    public void numButtonPress(View numButton) {
        Button b = (Button) numButton;
        String input = b.getText().toString();
        if (currentQuestion.checkInput(input)) {
            // Input is correct
            currentInputWidget.setTextColor(defaultTextColor);
            currentInputWidget.setText(input);
            if (currentQuestion.isAnswered()) {
                suspendInput = true;
                ViewPropertyAnimator animator = questionView.animate().alpha(0);
                animator.setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        questionArea.removeAllViews();
                        setupQuestion();
                        suspendInput = false;
                    }
                });
            } else {
                currentInputWidget = currentQuestion.getInputDisplayWidget();
            }
        } else {
            currentInputWidget.setText(b.getText());
            currentInputWidget.setTextColor(Color.RED);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
            return suspendInput || super.dispatchTouchEvent(ev);
    }

    private void setupQuestion() {
        LayoutInflater inflater = getLayoutInflater();
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                currentQuestion = new DivisionQuestion();
                break;
            case 1:
                currentQuestion = new AdditionQuestion();
                break;
            case 2:
                currentQuestion = new SubtractionQuestion();
                break;
            case 3:
                currentQuestion = new MultiplicationQuestion();
                break;
        }
        questionView = currentQuestion.renderQuestion(inflater, questionArea);
        questionView.setAlpha(0);
        questionArea.addView(questionView);
        suspendInput = true;
        ViewPropertyAnimator animator = questionView.animate().alpha(1);
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                suspendInput = false;
            }
        });
        currentInputWidget = currentQuestion.getInputDisplayWidget();
    }
}
