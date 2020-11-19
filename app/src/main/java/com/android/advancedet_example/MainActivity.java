package com.android.advancedet_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.advancedet.AdvancedEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdvancedEditText advancedEditText = findViewById(R.id.example);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //advancedEditText.checkMinimum(5, "Not enough chars!");
                //advancedEditText.checkMaximum(6, "Too many chars!");
                //advancedEditText.checkEmail("That's not an email!");
                advancedEditText.checkNotEmpty("The string cannot be empty!");

            }
        });
    }
}