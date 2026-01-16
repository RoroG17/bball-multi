package org.example.bballmulti.ui.layout

import org.example.bballmulti.network.GamesApiImpl
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.bballmulti.provideHttpClient
import org.example.bballmulti.ui.page.CalendarScreen
import org.example.bballmulti.ui.page.HomeScreen
import org.example.bballmulti.ui.page.PlayerScreen
import org.example.bballmulti.viewmodels.CalendarVM

@Composable
fun TemplateLayout() {
    val navController = rememberNavController()

    val httpClient = provideHttpClient()
    Scaffold(
        topBar = {
            AppTopBar(
                onLogoutClick = {  }
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Accueil.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Accueil.route) {
                HomeScreen()
            }

            composable(BottomNavItem.Calendrier.route) {
                CalendarScreen(CalendarVM(api = GamesApiImpl(httpClient)))
            }

            composable(BottomNavItem.Stats.route) {
                PlayerScreen()
            }

//            composable(
//                route = "match_detail/{matchId}",
//                arguments = listOf(
//                    navArgument("matchId") { type = NavType.IntType }
//                )
//            ) { backStackEntry ->
//                val matchId = backStackEntry.arguments?.getInt("matchId")
//                    ?: return@composable
//
//                MatchDetailScreen(id = matchId)
//            }
        }
    }
}