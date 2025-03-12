package com.example.studymate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.cloud.dialogflow.v2.QueryResult
import com.google.cloud.dialogflow.v2.SessionsClient
import com.google.cloud.dialogflow.v2.SessionsSettings
import com.google.cloud.dialogflow.v2.TextInput
import com.google.cloud.dialogflow.v2.TextInput.Builder
import com.google.cloud.dialogflow.v2.QueryInput
import com.google.cloud.dialogflow.v2.DetectIntentRequest
import com.google.cloud.dialogflow.v2.DetectIntentResponse
import com.google.cloud.dialogflow.v2.SessionName
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.auth.oauth2.GoogleCredentials
import java.io.InputStream
import java.util.UUID

class AIChatbotActivity : AppCompatActivity() {

    private lateinit var userInput: EditText
    private lateinit var chatbotResponse: TextView
    private lateinit var sendButton: Button
    private lateinit var sessionsClient: SessionsClient
    private lateinit var sessionName: SessionName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_chatbot)

        userInput = findViewById(R.id.user_input)
        chatbotResponse = findViewById(R.id.chatbot_response)
        sendButton = findViewById(R.id.send_button)

        try {
            val stream: InputStream = resources.openRawResource(R.raw.credentials)
            val credentials = GoogleCredentials.fromStream(stream)
            val sessionsSettings = SessionsSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build()
            sessionsClient = SessionsClient.create(sessionsSettings)
            sessionName = SessionName.of(getString(R.string.project_id), UUID.randomUUID().toString())
        } catch (e: Exception) {
            e.printStackTrace()
        }

        sendButton.setOnClickListener {
            val text = userInput.text.toString()
            if (text.isNotEmpty()) {
                sendMessageToChatbot(text)
            }
        }
    }

    private fun sendMessageToChatbot(text: String) {
        Thread {
            try {
                val textInput = TextInput.newBuilder().setText(text).setLanguageCode("en-US")
                val queryInput = QueryInput.newBuilder().setText(textInput).build()
                val detectIntentRequest = DetectIntentRequest.newBuilder()
                    .setSession(sessionName.toString())
                    .setQueryInput(queryInput)
                    .build()
                val response = sessionsClient.detectIntent(detectIntentRequest)
                val result = response.queryResult
                runOnUiThread {
                    chatbotResponse.text = result.fulfillmentText
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}
