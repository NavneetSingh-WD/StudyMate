package com.example.attendanceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.InputStream;
import java.util.UUID;

public class AIChatbotActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView chatbotResponse;
    private Button sendButton;
    private SessionsClient sessionsClient;
    private SessionName sessionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_chatbot);

        userInput = findViewById(R.id.user_input);
        chatbotResponse = findViewById(R.id.chatbot_response);
        sendButton = findViewById(R.id.send_button);

        try {
            InputStream stream = getResources().openRawResource(R.raw.credentials);
            GoogleCredentials credentials = GoogleCredentials.fromStream(stream);
            SessionsSettings sessionsSettings = SessionsSettings.newBuilder()
                    .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                    .build();
            sessionsClient = SessionsClient.create(sessionsSettings);
            sessionName = SessionName.of(getString(R.string.project_id), UUID.randomUUID().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = userInput.getText().toString();
                if (!text.isEmpty()) {
                    sendMessageToChatbot(text);
                }
            }
        });
    }

    private void sendMessageToChatbot(String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode("en-US");
                    QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
                    DetectIntentRequest detectIntentRequest = DetectIntentRequest.newBuilder()
                            .setSession(sessionName.toString())
                            .setQueryInput(queryInput)
                            .build();
                    DetectIntentResponse response = sessionsClient.detectIntent(detectIntentRequest);
                    QueryResult result = response.getQueryResult();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            chatbotResponse.setText(result.getFulfillmentText());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
