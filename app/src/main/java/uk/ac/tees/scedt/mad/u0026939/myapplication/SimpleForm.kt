package uk.ac.tees.scedt.mad.u0026939.myapplication

import androidx.compose.foundation.layout.Column
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
fun SimpleForm(person: Person = Person()) {
    Column {
        OutlinedTextField(
            value = person.name,
            modifier = Modifier.padding(all = 8.dp),
            onValueChange = { person.name = it },
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = person.age.toString(),
            modifier = Modifier.padding(all = 8.dp),
            onValueChange = { person.age = it.toIntOrNull() ?: 0 },
            label = { Text("Age") }
        )
    }
}

@Composable
fun DndCharacterForm(char: Character = Character()) {
    var name = remember(char) { mutableStateOf(char.name) }
    var classType = remember(char) { mutableStateOf(char.classType) }
    var STR = remember(char) { mutableIntStateOf(char.STR) }
    var DEX = remember(char) { mutableIntStateOf(char.DEX) }
    var CON = remember(char) { mutableIntStateOf(char.CON) }
    var INT = remember(char) { mutableIntStateOf(char.INT) }
    var WIS = remember(char) { mutableIntStateOf(char.WIS) }
    var CHA = remember(char) { mutableIntStateOf(char.CHA) }

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
            value = STR.intValue.toString(),
            onValueChange = { it: String -> STR.intValue = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Strength") }
        )
        OutlinedTextField(
            value = DEX.intValue.toString(),
            onValueChange = { it: String -> DEX.intValue = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Dexterity") }
        )
        OutlinedTextField(
            value = CON.intValue.toString(),
            onValueChange = { it: String -> CON.intValue = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Constitution") }
        )
        OutlinedTextField(
            value = INT.intValue.toString(),
            onValueChange = { it: String -> char.INT = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Intelligence") }
        )
        OutlinedTextField(
            value = WIS.intValue.toString(),
            onValueChange = { it: String -> WIS.intValue = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Wisdom") }
        )
        OutlinedTextField(
            value = CHA.toString(),
            onValueChange = { it: String -> CHA.intValue = it.toIntOrNull() ?: 0 },
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            label = { Text("Charisma") }
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Text("Save")
        }
    }
}