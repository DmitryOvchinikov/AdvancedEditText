package com.android.advancedet_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.advancedet.AdvancedEditText;

public class MainActivity extends AppCompatActivity {

    private AdvancedEditText example_not_empty;
    private AdvancedEditText example_minimum;
    private AdvancedEditText example_maximum;
    private AdvancedEditText example_email;
    private AdvancedEditText example_custom;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example_not_empty.check();
                example_minimum.check();
                example_maximum.check();
                example_email.check();
                example_custom.check();
            }
        });
    }

    private void findViews() {
        example_not_empty = findViewById(R.id.example_not_empty);
        example_minimum = findViewById(R.id.example_minimum);
        example_maximum = findViewById(R.id.example_maximum);
        example_email = findViewById(R.id.example_email);
        example_custom = findViewById(R.id.example_custom);
        button = findViewById(R.id.button);
    }
}