package org.example.bballmulti.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bball_app_multi.composeapp.generated.resources.Res
import bball_app_multi.composeapp.generated.resources.ic_connection_error
import org.jetbrains.compose.resources.painterResource

@Composable
fun ErrorScreen(message:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_connection_error),
            contentDescription = ""
        )
        Text(text = message, modifier = Modifier.padding(16.dp))
    }
}