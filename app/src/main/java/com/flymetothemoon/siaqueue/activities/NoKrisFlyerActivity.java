package com.flymetothemoon.siaqueue.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.flymetothemoon.siaqueue.R;

public class NoKrisFlyerActivity extends AppCompatActivity {

    private Spinner titleInput;
    private EditText firstNameInput;
    private EditText lastNameInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_kris_flyer);

        initViews();
        Toolbar toolbar = findViewById(R.id.no_krisflyer_activity_toolbar);
        this.setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void initViews() {
        titleInput = findViewById(R.id.title_spinner);
        firstNameInput = findViewById(R.id.input_first_name);
        lastNameInput = findViewById(R.id.input_last_name);
        continueButton = findViewById(R.id.continue_button);

        ArrayAdapter<CharSequence> titleAdapter = ArrayAdapter.createFromResource(this,
                R.array.title_array, android.R.layout.simple_spinner_item);
        titleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        titleInput.setAdapter(titleAdapter);

        titleInput.setSelection(0);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
