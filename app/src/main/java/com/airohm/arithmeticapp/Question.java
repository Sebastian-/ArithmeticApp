package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sebastian on 2017-07-24.
 */

interface Question {

    /* Parameters: inflater     - an instance of LayoutInflater
     *             questionArea - a reference to the parent container where the question will be displayed
     * Effect:     the question view is added as a child of the question area container */
    View renderQuestion(LayoutInflater inflater, ViewGroup questionArea);

    /* Returns a reference to the widget currently meant to display the next digit of input */
    TextView getInputDisplayWidget();

    /* Returns true if the given input digit matches the corresponding digit of the answer */
    boolean checkInput(String input);

    /* Returns true when the question has been fully answered */
    boolean isAnswered();
}
