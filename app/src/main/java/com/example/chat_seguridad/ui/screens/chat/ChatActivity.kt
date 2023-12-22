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
    // Inicializa con un mensaje de ejemplo como mensaje entrante
    var messages by remember { mutableStateOf(listOf(Triple("Other User", "Hola, ¿cómo estás?", true))) }
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        // Lista de mensajes
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { triple ->
                // Usa el parámetro isIncoming para alinear los mensajes
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
            // Cuando agregues un mensaje, asegúrate de especificar si es entrante o saliente
            Button(onClick = {
                if (textState.text.isNotEmpty()) {
                    // Aquí asumo que los mensajes enviados no son entrantes, por lo tanto, el booleano es 'false'
                    messages = messages + Triple("User Name", textState.text, false)
                    textState = TextFieldValue("")
                }
            }) {
                Text("Enviar")
            }
        }
    }
}
