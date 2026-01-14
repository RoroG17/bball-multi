package org.example.bballmulti

import androidx.compose.runtime.Composable
import org.example.bballmulti.ui.layout.AppTopBar
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App () {
    AppTopBar(onLogoutClick = {})
}
