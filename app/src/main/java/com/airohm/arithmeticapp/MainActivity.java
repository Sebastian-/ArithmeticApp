package com.airohm.arithmeticapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText currentInputBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentInputBox = (EditText) findViewById(R.id.editText);
    }

    public void numButtonPress(View numButton) {
        Button b = (Button) numButton;
        currentInputBox.setText(b.getText());
    }
}
