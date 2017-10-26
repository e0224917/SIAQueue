package com.flymetothemoon.siaqueue.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flymetothemoon.siaqueue.R;

public class ConfirmKrisflyerDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm_krisflyer_dialog);

        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                onBackPressed();
            }
        });
    }
}
