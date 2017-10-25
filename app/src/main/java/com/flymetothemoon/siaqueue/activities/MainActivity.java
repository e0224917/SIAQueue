package com.flymetothemoon.siaqueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.retrofit.SIAClient;
import com.flymetothemoon.siaqueue.retrofit.model.FTResponse;
import com.flymetothemoon.siaqueue.retrofit.model.GetProfile;
import com.flymetothemoon.siaqueue.retrofit.model.KrisflyerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton haveKrisFlyerButton;
    private AppCompatButton forgotKrisFlyerButton;
    private AppCompatButton noKrisFlyerButton;
    private EditText krisFlyerNumberInput;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        haveKrisFlyerButton = findViewById(R.id.have_krisflyer_button);
        krisFlyerNumberInput = findViewById(R.id.krisflyer_number_input);
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
                String krisFlyerNumber = krisFlyerNumberInput.getText().toString();
                if (!krisFlyerNumber.isEmpty()) {
                    Call<FTResponse<GetProfile>> message = SIAClient.getApiService()
                            .getKrisflyerProfile(new KrisflyerRequest(krisFlyerNumber));
                    message.enqueue(new Callback<FTResponse<GetProfile>>() {
                        @Override
                        public void onResponse(Call<FTResponse<GetProfile>> call, Response<FTResponse<GetProfile>> response) {
                            if (response.isSuccessful()) {
                                Log.e("Response", response.toString());
                            } else {
                                Log.e("Error", "eeeerrrorrr");
                            }
                        }

                        @Override
                        public void onFailure(Call<FTResponse<GetProfile>> call, Throwable t) {
                            Log.e("Error", t.getMessage());
                        }
                    });
                }
                break;
            case R.id.forgot_krisflyer_button:
                startActivity(new Intent(this, ForgotKrisFlyerActivity.class));
                break;
            case R.id.no_krisflyer_button:
                startActivity(new Intent(this, NoKrisFlyerActivity.class));
                break;
            case R.id.continue_button:
                startActivity(new Intent(this, VoiceActivity.class));
        }
    }
}
