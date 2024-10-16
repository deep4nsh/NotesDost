package com.example.notesdost.ui.theme.activities.others

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R

class SaveCredentialsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_credentials)

        sharedPreferences = getSharedPreferences("StudentInfo", Context.MODE_PRIVATE)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val saveButton = findViewById<Button>(R.id.btn_save)

        saveButton.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                sharedPreferences.edit().apply {
                    putString("username", username)
                    putString("password", password)
                    apply()
                }
                Toast.makeText(this, "Credentials saved successfully!", Toast.LENGTH_SHORT).show()
                finish() // Close the activity
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
