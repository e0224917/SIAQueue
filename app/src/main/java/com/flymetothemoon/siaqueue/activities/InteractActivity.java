package com.flymetothemoon.siaqueue.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.mobileconnectors.lex.interactionkit.Response;
import com.amazonaws.mobileconnectors.lex.interactionkit.config.InteractionConfig;
import com.amazonaws.mobileconnectors.lex.interactionkit.listeners.AudioPlaybackListener;
import com.amazonaws.mobileconnectors.lex.interactionkit.ui.InteractiveVoiceView;
import com.amazonaws.regions.Regions;
import com.flymetothemoon.siaqueue.QueueManager;
import com.flymetothemoon.siaqueue.R;
import com.flymetothemoon.siaqueue.adapter.MessagesListAdapter;
import com.flymetothemoon.siaqueue.model.Conversation;
import com.flymetothemoon.siaqueue.model.TextMessage;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class InteractActivity extends AppCompatActivity implements InteractiveVoiceView.InteractiveVoiceListener {


    private static final String TAG = "InteractActivity";
    private Context appContext;
    private MessagesListAdapter listAdapter;
    private ListView messagesListView;

    private boolean inConversation;
    private InteractiveVoiceView voiceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact);

        initToolbar();
        initViews();

    }

    private void initViews() {
        appContext = getApplicationContext();

        voiceView = findViewById(R.id.voiceInterface);
        voiceView.setInteractiveVoiceListener(this);

        // Initialize the Amazon Cognito credentials provider
        CognitoCredentialsProvider credentialsProvider = new CognitoCredentialsProvider(
                appContext.getResources().getString(R.string.identity_id_test),
                Regions.US_EAST_1);


        voiceView.getViewAdapter().setCredentialProvider(credentialsProvider);
        voiceView.getViewAdapter().setInteractionConfig(
                new InteractionConfig(appContext.getString(R.string.bot_name),
                        appContext.getString(R.string.bot_alias)));
        voiceView.getViewAdapter().setAwsRegion(Regions.US_EAST_1.getName());

        messagesListView = findViewById(R.id.conversationListView);

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.interact_activity_toolbar);
        this.setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void startNewConversation() {
        Log.d(TAG, "Starting new conversation");
        Conversation.clear();
        inConversation = false;
    }

    /**
     * Pass user input to Lex client.
     */
    private void readUserText() {
        inConversation = true;
    }

    /**
     * Show the text message on the screen.
     *
     * @param userMessage, botMessage
     */
    private void addMessages(TextMessage userMessage, TextMessage botMessage) {
        Conversation.add(userMessage);
        Conversation.add(botMessage);
        listAdapter = new MessagesListAdapter(getApplicationContext());
        messagesListView.setAdapter(listAdapter);
//        messagesListView.setSelection(listAdapter.getCount() - 1);
    }

    /**
     * Current time stamp.
     *
     * @return
     */
    private String getCurrentTimeStamp() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }

    /**
     * Implementing {@link AudioPlaybackListener}.
     */
    final AudioPlaybackListener audioPlaybackListener = new AudioPlaybackListener() {
        @Override
        public void onAudioPlaybackStarted() {
            Log.d(TAG, " -- Audio playback started");
        }

        @Override
        public void onAudioPlayBackCompleted() {
            Log.d(TAG, " -- Audio playback ended");
        }

        @Override
        public void onAudioPlaybackError(Exception e) {
            Log.d(TAG, " -- Audio playback error", e);
        }
    };

    @Override
    public void dialogReadyForFulfillment(Map<String, String> slots, String intent) {
        Log.d(TAG, String.format(
                Locale.US,
                "Dialog ready for fulfillment:\n\tIntent: %s\n\tSlots: %s",
                intent,
                slots.toString()));

        if(Objects.equals(intent, "GetInfo")){
            QueueManager.getInstance().setCustomerName(slots.get("Name"));
        }

    }

    @Override
    public void onResponse(Response response) {
        Log.d(TAG, "Bot response: " + response.getTextResponse());
        Log.d(TAG, "Transcript: " + response.getInputTranscript());

        startNewConversation();

        TextMessage userMessage = new TextMessage(response.getInputTranscript(), "tx", getCurrentTimeStamp());
        TextMessage botMessage = new TextMessage(response.getTextResponse(), "rx", getCurrentTimeStamp());
        addMessages(userMessage, botMessage);

    }

    @Override
    public void onError(String responseText, Exception e) {
        Log.e(TAG, "Error: " + responseText, e);

        showToast("Error: " + responseText);
        Log.e(TAG, "Interaction error", e);
        inConversation = false;

    }

    /**
     * Show a toast.
     *
     * @param message - Message text for the toast.
     */
    private void showToast(final String message) {
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Log.d(TAG, message);
    }
}
