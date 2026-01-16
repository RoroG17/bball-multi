package org.example.bballmulti.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.example.bballmulti.models.Game

@Composable
fun GameCard(
    game : Game,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {  }, // TODO
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Journée ${game.number} - ${game.gameDate}",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }

        // Content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

//                Logo(game.homeLogo)

                Text(
                    text = if (game.homeTeam.length > 10) {
                        game.homeTeam.take(10) + "..."
                    } else {
                        game.homeTeam
                    },
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )

            }

            // Score
            Text(
                text = game.getScore(),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

//                Logo(game.awayLogo)

                Text(
                    text = if (game.awayTeam.length > 10) {
                        game.awayTeam.take(10) + "..."
                    } else {
                        game.awayTeam
                    },
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
