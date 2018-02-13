package com.airohm.arithmeticapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

interface Question {

    /* Parameters: inflater     - an instance of LayoutInflater
     *             questionArea - a reference to the parent container where the question will be displayed
     * Returns: A view containing all widgets required to display the question*/
    View renderQuestion(LayoutInflater inflater, ViewGroup questionArea);

    /* Returns a reference to the widget currently meant to display the next digit of input */
    TextView getInputDisplayWidget();

    /* Returns true if the given input digit matches the corresponding digit of the answer */
    boolean checkInput(String input);

    /* Returns true when the question has been fully answered */
    boolean isAnswered();
}
