package com.flymetothemoon.siaqueue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton haveKrisFlyerButton;
    private AppCompatButton forgotKrisFlyerButton;
    private AppCompatButton noKrisFlyerButton;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Call<FTResponse<GetProfile>> message = SIAClient.getApiService()
//                .getKrisflyerProfile( new KrisflyerRequest("8987011905"));
//        message.enqueue(new Callback<FTResponse<GetProfile>>() {
//            @Override
//            public void onResponse(Call<FTResponse<GetProfile>> call, Response<FTResponse<GetProfile>> response) {
//                Log.e("Response", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<FTResponse<GetProfile>> call, Throwable t) {
//                Log.e("Error", t.getMessage());
//            }
//        });

        init();
    }

    private void init() {
        haveKrisFlyerButton = findViewById(R.id.have_krisflyer_button);
        forgotKrisFlyerButton = findViewById(R.id.forgot_krisflyer_button);
        noKrisFlyerButton = findViewById(R.id.no_krisflyer_button);
        continueButton = findViewById(R.id.continue_button);

        haveKrisFlyerButton.setOnClickListener(this);
        forgotKrisFlyerButton.setOnClickListener(this);
        noKrisFlyerButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.have_krisflyer_button:
                break;
            case R.id.forgot_krisflyer_button:
                startActivity(new Intent(this, ForgotKrisFlyerActivity.class));
                break;
            case R.id.no_krisflyer_button:
                break;
            case R.id.next_button:
                startActivity(new Intent(this, VoiceActivity.class));
        }
    }
}
