package com.flymetothemoon.siaqueue;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyPresigningClient;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechPresignRequest;
import com.amazonaws.services.polly.model.Voice;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by nhatton on 10/26/17.
 */

public class PollyControl {

    private static PollyControl sInstance;

    private AmazonPollyPresigningClient client;
    private List<Voice> voices;
    private MediaPlayer mediaPlayer;
    private SynthesizeSpeechPresignRequest synthesizeSpeechPresignRequest;
    private URL presignedSynthesizeSpeechUrl;

    static {
        sInstance = new PollyControl();
    }

    private PollyControl() {
        setupNewMediaPlayer();
    }

    public static PollyControl getInstance(){
        return sInstance;
    }

    public void initPolly(Context context) {
        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                context,
                context.getResources().getString(R.string.identity_id_test),
                Regions.US_EAST_1);

        // Create a client that supports generation of presigned URLs.
        client = new AmazonPollyPresigningClient(credentialsProvider);

        getPollyVoices.start();

    }

    public void playSound(String input) {
        // Create speech synthesis request.
        synthesizeSpeechPresignRequest =
                new SynthesizeSpeechPresignRequest()
                        // Set the text to synthesize.
                        .withText(input)
                        // Select voice for synthesis.
                        .withVoiceId(voices.get(0).getId()) // "Joanna", female
                        // Set format to MP3.
                        .withOutputFormat(OutputFormat.Mp3);

        // Get the presigned URL for synthesized speech audio stream.
        presignedSynthesizeSpeechUrl =
                client.getPresignedSynthesizeSpeechUrl(synthesizeSpeechPresignRequest);

        mediaPlayer.reset();
        setupNewMediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            // Set media player's data source to previously obtained URL.
            mediaPlayer.setDataSource(presignedSynthesizeSpeechUrl.toString());
        } catch (IOException e) {
            Log.e("Error", "Unable to set data source for the media player! " + e.getMessage());
        }

        // Prepare the MediaPlayer asynchronously (since the data source is a network stream).
        mediaPlayer.prepareAsync();

    }

    private void setupNewMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        // Set the callback to start the MediaPlayer when it's prepared.
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        // Set the callback to release the MediaPlayer after playback is completed.
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                setupNewMediaPlayer();
            }
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
    }

    private Thread getPollyVoices = new Thread(new Runnable() {
        @Override
        public void run() {
            // Create describe voices request.
            DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest();

            // Synchronously ask Amazon Polly to describe available TTS voices.
            DescribeVoicesResult describeVoicesResult = client.describeVoices(describeVoicesRequest);
            voices = describeVoicesResult.getVoices();
        }
    });
}
