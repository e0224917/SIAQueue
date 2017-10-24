package com.flymetothemoon.siaqueue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton haveKrysFlyerButton;
    private AppCompatButton forgotKrysFlyerButton;
    private AppCompatButton noKrysFlyerButton;
    private Button nextButton;

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
        haveKrysFlyerButton = findViewById(R.id.have_krysflyer_button);
        forgotKrysFlyerButton = findViewById(R.id.forgot_krysflyer_button);
        noKrysFlyerButton = findViewById(R.id.no_krysflyer_button);
        nextButton = findViewById(R.id.next_button);

        haveKrysFlyerButton.setOnClickListener(this);
        forgotKrysFlyerButton.setOnClickListener(this);
        noKrysFlyerButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.have_krysflyer_button:
                break;
            case R.id.forgot_krysflyer_button:
                break;
            case R.id.no_krysflyer_button:
                break;
            case R.id.next_button:
                startActivity(new Intent(this, VoiceActivity.class));
        }
    }
}
