package uk.ac.tees.scedt.mad.u0026939.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DndCharacterForm(char: Character = Character()) {
    val name = remember(char) { mutableStateOf(char.name) }
    val classType = remember(char) { mutableStateOf(char.classType) }
    val race = remember(char) { mutableStateOf(char.race) }
    val STR = remember(char) { mutableIntStateOf(char.STR) }
    val DEX = remember(char) { mutableIntStateOf(char.DEX) }
    val CON = remember(char) { mutableIntStateOf(char.CON) }
    val INT = remember(char) { mutableIntStateOf(char.INT) }
    val WIS = remember(char) { mutableIntStateOf(char.WIS) }
    val CHA = remember(char) { mutableIntStateOf(char.CHA) }

    Column {
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Name") },
        ) // Name
        OutlinedTextField(
            value = classType.value,
            onValueChange = { classType.value = it },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Class") },
        )
        OutlinedTextField(
            value = race.value,
            onValueChange = { race.value = it },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Race") },
        )
        FillableStat(label = "Strength",
            value = STR.intValue,
            onValueChange = { STR.intValue = it })
        FillableStat(label = "Dexterity",
            value = DEX.intValue,
            onValueChange = { DEX.intValue = it })
        FillableStat(label = "Constitution",
            value = CON.intValue,
            onValueChange = { CON.intValue = it })
        FillableStat(label = "Intelligence",
            value = INT.intValue,
            onValueChange = { INT.intValue = it })
        FillableStat(label = "Wisdom",
            value = WIS.intValue,
            onValueChange = { WIS.intValue = it })
        FillableStat(label = "Charisma",
            value = CHA.intValue,
            onValueChange = { CHA.intValue = it })
        Row {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(all = 8.dp)
            ) {
                Text("Save")
            }
            Button(
                onClick = {
                    STR.intValue = rollStat()
                    DEX.intValue = rollStat()
                    CON.intValue = rollStat()
                    INT.intValue = rollStat()
                    WIS.intValue = rollStat()
                    CHA.intValue = rollStat()
                },
                modifier = Modifier
                    .padding(all = 8.dp)
            ) {
                Text("Randomize")
            }
        }

    }
}

fun rollStat(): Int {
    return (1..4).map { (1..6).random() }.sorted().drop(1).sum()
}

@Composable
fun FillableStat(
    label: String,
    value: Int,
    onValueChange: (Int) -> Unit
) {
    OutlinedTextField(
        value = value.toString(),
        onValueChange = { onValueChange(it.toIntOrNull() ?: 0) },
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        label = { Text(label) }
    )
}