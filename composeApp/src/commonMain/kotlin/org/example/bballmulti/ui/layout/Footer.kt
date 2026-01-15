package org.example.bballmulti.ui.layout

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import bball_app_multi.composeapp.generated.resources.Res
import bball_app_multi.composeapp.generated.resources.ic_calendar
import bball_app_multi.composeapp.generated.resources.ic_home
import bball_app_multi.composeapp.generated.resources.ic_stat
import org.jetbrains.compose.resources.DrawableResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

sealed class BottomNavItem(val route: String, val icon: DrawableResource, val label: String) {
    object Accueil : BottomNavItem("accueil", Res.drawable.ic_home, "Accueil")
    object Calendrier : BottomNavItem("calendrier", Res.drawable.ic_calendar, "Calendrier")
    object Stats : BottomNavItem("stats", Res.drawable.ic_stat, "Stats")
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Accueil,
        BottomNavItem.Calendrier,
        BottomNavItem.Stats
    )

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Accueil.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.label,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun FooterPreview() {
    val navController = rememberNavController()
    BottomNavBar(navController)
}
