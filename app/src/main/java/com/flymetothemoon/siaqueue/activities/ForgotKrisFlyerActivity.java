package com.flymetothemoon.siaqueue.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.dialogs.ConfirmKrisflyerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class ForgotKrisFlyerActivity extends AppCompatActivity {

    private static final int REQUEST_CONFIRM = 1;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText dobInput;
    private EditText emailInput;
    private Button submitButton;

    private Calendar myCalendar = Calendar.getInstance();

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
        dobInput = findViewById(R.id.input_dob);
        emailInput = findViewById(R.id.input_email);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkValid()) return;
                Intent intent = new Intent(ForgotKrisFlyerActivity.this, ConfirmKrisflyerDialog.class);
                startActivityForResult(intent, REQUEST_CONFIRM);
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/mm/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

                dobInput.setText(sdf.format(myCalendar.getTime()));
            }

        };

        dobInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ForgotKrisFlyerActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CONFIRM && resultCode == RESULT_OK) {
            onBackPressed();
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    private boolean checkValid() {

        if (firstNameInput.getText().toString().isEmpty()) {
            firstNameInput.setError(getString(R.string.error_first_name));
            return false;
        }

        if (lastNameInput.getText().toString().isEmpty()) {
            lastNameInput.setError(getString(R.string.error_last_name));
            return false;
        }

        if (dobInput.getText().toString().isEmpty()) {
            dobInput.setError(getString(R.string.error_dob));
            return false;
        }

        String email = emailInput.getText().toString();
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            emailInput.setError(getString(R.string.error_email));
            return false;
        }

        return true;
    }
}
