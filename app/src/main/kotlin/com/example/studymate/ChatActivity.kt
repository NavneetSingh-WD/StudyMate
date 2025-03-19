package com.example.studymate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var messageList: MutableList<Message>
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView = findViewById(R.id.recyclerView)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)

        // Initialize the message list and chat adapter
        messageList = mutableListOf()
        chatAdapter = ChatAdapter(messageList)

        // Set up the RecyclerView with a LinearLayoutManager and the chat adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        // Set the click listener for the send button
        buttonSend.setOnClickListener {
            val messageText = editTextMessage.text.toString().trim()
            if (messageText.isNotEmpty()) {
                // Create a new message object with the user's message
                val message = Message(messageText, "User")
                // Add the message to the message list
                messageList.add(message)
                // Notify the adapter that a new item has been inserted
                chatAdapter.notifyItemInserted(messageList.size - 1)
                // Scroll the RecyclerView to the last message
                recyclerView.scrollToPosition(messageList.size - 1)
                // Clear the input field
                editTextMessage.setText("")
            }
        }
    }
}
