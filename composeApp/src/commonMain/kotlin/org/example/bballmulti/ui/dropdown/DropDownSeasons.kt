package org.example.bballmulti.ui.dropdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.example.bballmulti.models.Season
import org.example.bballmulti.viewmodels.CalendarVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownSeasons(
    vm: CalendarVM,
    seasons: List<Season>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            value = vm.selectedSeason.value?.getText() ?: "Error",
            onValueChange = {},
            readOnly = true,
            label = { Text("Saison") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            seasons.forEach { season ->
                DropdownMenuItem(
                    text = { Text(season.getText()) },
                    onClick = {
                        expanded = false
                        vm.onSelectedSeason(season)
                    }
                )
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DropDownSeasons(
//    vm: PlayerViewModel,
//    seasons: List<Season>,
//    modifier: Modifier = Modifier
//) {
//    var expanded by remember { mutableStateOf(false) }
//
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = { expanded = !expanded },
//        modifier = modifier.fillMaxWidth()
//    ) {
//
//        OutlinedTextField(
//            value = vm.season?.getText() ?: stringResource(R.string.label_error),
//            onValueChange = {},
//            readOnly = true,
//            label = { Text("Saison") },
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//            },
//            modifier = Modifier
//                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
//                .fillMaxWidth()
//        )
//
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            seasons.forEach { season ->
//                DropdownMenuItem(
//                    text = { Text(season.getText()) },
//                    onClick = {
//                        expanded = false
//                        vm.onSeasonSelected(season)
//                    }
//                )
//            }
//        }
//    }
//}

