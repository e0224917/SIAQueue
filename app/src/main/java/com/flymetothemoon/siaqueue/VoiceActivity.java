package com.flymetothemoon.siaqueue;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.mobileconnectors.lex.interactionkit.Response;
import com.amazonaws.mobileconnectors.lex.interactionkit.config.InteractionConfig;
import com.amazonaws.mobileconnectors.lex.interactionkit.ui.InteractiveVoiceView;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.StringUtils;

import java.util.Locale;
import java.util.Map;

public class VoiceActivity extends AppCompatActivity implements InteractiveVoiceView.InteractiveVoiceListener {

    private static final String TAG = "VoiceActivity";
    private Context appContext;
    private InteractiveVoiceView voiceView;
    private TextView transcriptTextView;
    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        transcriptTextView = findViewById(R.id.transcriptTextView);
        responseTextView = findViewById(R.id.responseTextView);
        init();
        StringUtils.isBlank("notempty");

        // Create Lex interaction client.
//        InteractionClient lexInteractionClient = new InteractionClient(getApplicationContext(),
//                credentialsProvider,
//                Regions.US_EAST_1,
//                "SIA Customer Service Bot",
//            "SIA CS");
//        lexInteractionClient.setAudioPlaybackListener(audioPlaybackListener);
//        lexInteractionClient.setInteractionListener(interactionListener);

    }

    private void init() {
        appContext = getApplicationContext();

        voiceView = findViewById(R.id.voiceInterface);
        voiceView.setInteractiveVoiceListener(this);

        // Initialize the Amazon Cognito credentials provider
        CognitoCredentialsProvider credentialsProvider = new CognitoCredentialsProvider(
                appContext.getResources().getString(R.string.identity_id_test),
                Regions.US_EAST_1);

//        // Initialize the Cognito Sync client
//        CognitoSyncManager syncClient = new CognitoSyncManager(
//                getApplicationContext(),
//                Regions.US_EAST_1, // Region
//                credentialsProvider);
//
//        // Create a record in a dataset and synchronize with the server
//        Dataset dataset = syncClient.openOrCreateDataset("myDataset");
//        dataset.put("myKey", "myValue");
//        dataset.synchronize(new DefaultSyncCallback() {
//            @Override
//            public void onSuccess(Dataset dataset, List newRecords) {
//                //Your handler code here
//            }
//        });

        voiceView.getViewAdapter().setCredentialProvider(credentialsProvider);
        voiceView.getViewAdapter().setInteractionConfig(
                new InteractionConfig(appContext.getString(R.string.bot_name),
                        appContext.getString(R.string.bot_alias)));
        voiceView.getViewAdapter().setAwsRegion(Regions.US_EAST_1.getName());
    }

    @Override
    public void dialogReadyForFulfillment(final Map<String, String> slots, final String intent) {
        Log.d(TAG, String.format(
                Locale.US,
                "Dialog ready for fulfillment:\n\tIntent: %s\n\tSlots: %s",
                intent,
                slots.toString()));
    }

    @Override
    public void onResponse(Response response) {
        Log.d(TAG, "Bot response: " + response.getTextResponse());
        Log.d(TAG, "Transcript: " + response.getInputTranscript());

        responseTextView.setText(response.getTextResponse());
        transcriptTextView.setText(response.getInputTranscript());
    }

    @Override
    public void onError(final String responseText, final Exception e) {
        Log.e(TAG, "Error: " + responseText, e);
    }
}
