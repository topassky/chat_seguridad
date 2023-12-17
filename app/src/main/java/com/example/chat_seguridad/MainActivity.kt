package com.example.chat_seguridad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chat_seguridad.ui.screens.login.LoginScreen
import com.example.chat_seguridad.ui.theme.Chat_seguridadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chat_seguridadTheme {
                LoginScreen()
            }
        }
    }
}


