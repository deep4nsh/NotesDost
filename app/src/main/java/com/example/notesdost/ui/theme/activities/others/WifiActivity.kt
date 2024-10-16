package com.example.notesdost.ui.theme.activities.others

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.others.SaveCredentialsActivity
import com.example.notesdost.ui.theme.activities.others.WebViewActivity

class WifiActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        sharedPreferences = getSharedPreferences("StudentInfo", Context.MODE_PRIVATE)

        val connectButton = findViewById<ImageButton>(R.id.btn_connect)
        val saveCredentialsButton = findViewById<ImageButton>(R.id.btn_save_credentials)

        connectButton.setOnClickListener {
            if (isWiFiEnabled()) {
                val username = sharedPreferences.getString("username", "")
                val password = sharedPreferences.getString("password", "")

                if (!username.isNullOrEmpty() && !password.isNullOrEmpty()) {
                    val intent = Intent(this, WebViewActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    startActivity(intent)
                } else {
                    // Show a message if credentials are not saved
                    toast("Please save credentials first.")
                }
            } else {
                // Show a message if Wi-Fi is not enabled
                toast("Please turn on Wi-Fi first.")
            }
        }

        saveCredentialsButton.setOnClickListener {
            val intent = Intent(this, SaveCredentialsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isWiFiEnabled(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
