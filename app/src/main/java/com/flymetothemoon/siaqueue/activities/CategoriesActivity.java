package com.flymetothemoon.siaqueue.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.flymetothemoon.siaqueue.QueueManager;
import com.flymetothemoon.siaqueue.R;

public class CategoriesActivity extends AppCompatActivity {

    private TextView voiceOuput;
    private EditText voiceInput;
    private Button speakButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        initViews();

        String greeting = QueueManager.getInstance().getGreeting();
        voiceOuput.setText(greeting);
        QueueManager.getInstance().playSound(greeting);
    }

    private void initViews() {
        voiceOuput = findViewById(R.id.voice_output);
        voiceInput = findViewById(R.id.voice_input);
        speakButton = findViewById(R.id.speak_button);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSpeak = voiceInput.getText().toString();
                voiceOuput.setText(textToSpeak);
                QueueManager.getInstance().playSound(textToSpeak);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
