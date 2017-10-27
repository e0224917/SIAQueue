package com.flymetothemoon.siaqueue.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flymetothemoon.siaqueue.QueueManager;
import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.retrofit.SIAClient;
import com.flymetothemoon.siaqueue.retrofit.model.FTResponse;
import com.flymetothemoon.siaqueue.retrofit.model.GetPassenger;
import com.flymetothemoon.siaqueue.retrofit.model.PassengerRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputPNRDialog extends Activity implements View.OnClickListener {

    private EditText pnrInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_input_pnr);

        initViews();
    }

    private void initViews() {
        pnrInput = findViewById(R.id.pnr_input);
        Button okButton = findViewById(R.id.ok_button);
        Button forgotButton = findViewById(R.id.forgot_button);

        okButton.setOnClickListener(this);
        forgotButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_button:
                final String pnr = pnrInput.getText().toString();
                if (pnr.isEmpty() || pnr.length() < 6) {
                    pnrInput.setError(getString(R.string.error_pnr));
                    return;
                }

                Call<FTResponse<GetPassenger>> message = SIAClient.getApiService()
                        .getPassenger(new PassengerRequest(pnr));
                message.enqueue(new Callback<FTResponse<GetPassenger>>() {
                    @Override
                    public void onResponse(Call<FTResponse<GetPassenger>> call, Response<FTResponse<GetPassenger>> response) {
                        if (response.isSuccessful()) {
                            Log.e("Response", response.toString());

                            QueueManager.getInstance().setPNR(pnr);

                            setResult(RESULT_OK);
                            finish();
                        } else {
                            Log.e("Error", "eeeerrrorrr");
                            pnrInput.setError(getString(R.string.error_pnr));
                        }
                    }

                    @Override
                    public void onFailure(Call<FTResponse<GetPassenger>> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                        pnrInput.setError(getString(R.string.error_pnr));
                    }
                });

                break;
            case R.id.forgot_button:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
