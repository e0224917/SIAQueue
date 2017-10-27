package com.flymetothemoon.siaqueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.dialogs.InputKrisFlyerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton haveKrisFlyerButton;
    private AppCompatButton forgotKrisFlyerButton;
    private AppCompatButton noKrisFlyerButton;
    private Button speakButton;
    private ImageView siaLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        haveKrisFlyerButton = findViewById(R.id.have_krisflyer_button);
        forgotKrisFlyerButton = findViewById(R.id.forgot_krisflyer_button);
        noKrisFlyerButton = findViewById(R.id.no_krisflyer_button);
        speakButton = findViewById(R.id.speak_button);
        siaLogo = findViewById(R.id.sia_logo);

        haveKrisFlyerButton.setOnClickListener(this);
        forgotKrisFlyerButton.setOnClickListener(this);
        noKrisFlyerButton.setOnClickListener(this);
        speakButton.setOnClickListener(this);
        siaLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.have_krisflyer_button:
                startActivity(new Intent(this, InputKrisFlyerDialog.class));
                break;
            case R.id.forgot_krisflyer_button:
                startActivity(new Intent(this, ForgotKrisFlyerActivity.class));
                break;
            case R.id.no_krisflyer_button:
                startActivity(new Intent(this, NoKrisFlyerActivity.class));
                break;
            case R.id.submit_button:
                startActivity(new Intent(this, VoiceActivity.class));
                break;
            case R.id.sia_logo:
            case R.id.speak_button:
                startActivity(new Intent(MainActivity.this, InteractActivity.class));
                break;
        }
    }

}
