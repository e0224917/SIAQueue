package com.flymetothemoon.siaqueue.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flymetothemoon.siaqueue.QueueManager;
import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.activities.CategoriesActivity;
import com.flymetothemoon.siaqueue.retrofit.SIAClient;
import com.flymetothemoon.siaqueue.retrofit.model.FTResponse;
import com.flymetothemoon.siaqueue.retrofit.model.GetProfile;
import com.flymetothemoon.siaqueue.retrofit.model.KrisflyerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputKrisFlyerDialog extends Activity implements View.OnClickListener {

    private EditText krisFlyerNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_input_kris_flyer);

        init();

    }

    private void init() {
        krisFlyerNumberInput = findViewById(R.id.krisflyer_number_input);
        Button okButton = findViewById(R.id.ok_button);
        Button cancelButton = findViewById(R.id.cancel_button);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_button:
                final String krisFlyerNumber = krisFlyerNumberInput.getText().toString();
                if (!krisFlyerNumber.isEmpty()) {
                    Call<FTResponse<GetProfile>> message = SIAClient.getApiService()
                            .getKrisflyerProfile(new KrisflyerRequest(krisFlyerNumber));
                    message.enqueue(new Callback<FTResponse<GetProfile>>() {
                        @Override
                        public void onResponse(Call<FTResponse<GetProfile>> call, Response<FTResponse<GetProfile>> response) {
                            if (response.isSuccessful()) {
                                Log.e("Response", response.toString());
                                GetProfile profile = response.body().getResponse();

                                QueueManager.getInstance().setCustomerTitle(profile.getTitle());
                                QueueManager.getInstance().setCustomerName(profile.getFirstName());
                                QueueManager.getInstance().setKrisFlyerName(krisFlyerNumber);

                                startActivity(new Intent(InputKrisFlyerDialog.this, CategoriesActivity.class));
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
            case R.id.cancel_button:
                onBackPressed();
                break;
        }
    }
}
