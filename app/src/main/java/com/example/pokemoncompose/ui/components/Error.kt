package com.example.pokemoncompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(onClick: () -> Unit) {
    Box(Modifier.fillMaxSize(1f)) {
        Button(onClick = onClick, Modifier.align(Alignment.Center)) {
            Text(text = "Retry")
        }
    }
}