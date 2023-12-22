package com.example.chat_seguridad.ui.screens.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.chat_seguridad.ui.components.MessageCard
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import android.content.Intent
import androidx.compose.ui.res.vectorResource
import com.example.chat_seguridad.R

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    var messages by remember { mutableStateOf(listOf(Triple("Other User", "Hola, ¿cómo estás?", true))) }
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Chat") },
                actions = {
                    // Botón de cerrar sesión
                    IconButton(onClick = { /* TODO: Acción para cerrar sesión */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_logout), // Reemplaza ic_logout con tu icono de cerrar sesión
                            contentDescription = "Cerrar Sesión"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(8.dp)) {
            // Lista de mensajes
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(messages) { triple ->
                    MessageCard(userName = triple.first, message = triple.second, isIncoming = triple.third)
                }
            }

            // Campo de texto y botón de envío
            Row(modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Escribe un mensaje") }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    if (textState.text.isNotEmpty()) {
                        messages = messages + Triple("User Name", textState.text, false)
                        textState = TextFieldValue("")
                    }
                }) {
                    Text("Enviar")
                }
            }
        }
    }
}
