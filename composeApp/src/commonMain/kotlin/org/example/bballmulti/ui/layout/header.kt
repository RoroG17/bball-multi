package org.example.bballmulti.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bball_app_multi.composeapp.generated.resources.Res
import bball_app_multi.composeapp.generated.resources.app_name
import bball_app_multi.composeapp.generated.resources.label_logout
import org.example.bballmulti.ui.theme.Primary
import org.example.bballmulti.ui.theme.TextColor
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 8.dp, vertical = 25.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
//            Image(
//                painter = painterResource(Res.drawable.ic_title),
//                contentDescription = stringResource(Res.string.app_name)
//            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(Res.string.app_name),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        IconButton(onClick = onLogoutClick) {
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = stringResource(Res.string.label_logout),
                tint = TextColor
            )
        }
    }
}