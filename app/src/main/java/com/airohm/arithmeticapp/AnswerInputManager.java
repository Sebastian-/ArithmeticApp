package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sebastian on 2017-07-29.
 */

public interface AnswerInputManager {

    public TextView getCurrentInputWidget();

    public void insertAnswerWidgets(LayoutInflater inflater, ViewGroup answerArea);

    public boolean checkInput(String input);

    public boolean isAnswered();
}
