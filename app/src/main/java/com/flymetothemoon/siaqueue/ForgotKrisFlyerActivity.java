package com.flymetothemoon.siaqueue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotKrisFlyerActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText dayInput;
    private EditText monthInput;
    private EditText yearInput;
    private EditText emailInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_kris_flyer);

        initViews();
        Toolbar toolbar = findViewById(R.id.forgot_krisflyer_activity_toolbar);
        this.setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void initViews() {
        firstNameInput = findViewById(R.id.input_first_name);
        lastNameInput = findViewById(R.id.input_last_name);
        dayInput = findViewById(R.id.input_day);
        monthInput = findViewById(R.id.input_month);
        yearInput = findViewById(R.id.input_year);
        emailInput = findViewById(R.id.input_email);
        continueButton = findViewById(R.id.continue_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
