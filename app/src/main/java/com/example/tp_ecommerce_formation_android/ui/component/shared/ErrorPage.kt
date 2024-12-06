package com.example.tp_ecommerce_formation_android.ui.component.shared

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ErrorPage(
    reason: String,
    userMessage: String,
) {
    Toast.makeText(LocalContext.current, "Error due to $reason", Toast.LENGTH_SHORT).show()
    Text(text = userMessage)
}