package com.example.ejemploenclase1.ui.screens

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.example.ejemploenclase1.data.model.PostModel
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@Composable
fun ComponentScreen(navController: NavController) {
    var component by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState, //current state of drawer
        //content of drawer
        drawerContent = { // diseño del menu
            ModalDrawerSheet {
                //Content 1
                NavigationDrawerItem(
                    label = { Text(text = "Content 1") },
                    selected = false,
                    onClick = {
                        component = "Content1"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 2
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Content 2") },
                    selected = false,
                    onClick = {
                        component = "Content2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 3
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Button") },
                    selected = false,
                    onClick = {
                        component = "Button"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 4
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "FloatingButtons") },
                    selected = false,
                    onClick = {
                        component = "FloatingButtons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 5
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Chips") },
                    selected = false,
                    onClick = {
                        component = "Chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 6
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "InputExample") },
                    selected = false,
                    onClick = {
                        component = "InputExample"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 7
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Progress") },
                    selected = false,
                    onClick = {
                        component = "Progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 8
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Sliders") },
                    selected = false,
                    onClick = {
                        component = "Sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 9
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Switches") },
                    selected = false,
                    onClick = {
                        component = "Switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 10
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Badges") },
                    selected = false,
                    onClick = {
                        component = "Badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 11
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "TimePickers") },
                    selected = false,
                    onClick = {
                        component = "TimePickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 12
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "DatePickers") },
                    selected = false,
                    onClick = {
                        component = "DatePickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 13
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "SnackBars") },
                    selected = false,
                    onClick = {
                        component = "SnackBars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 14
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "AlertDialogs") },
                    selected = false,
                    onClick = {
                        component = "AlertDialogs"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 15
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Bars") },
                    selected = false,
                    onClick = {
                        component = "Bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //Content 16
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Posts") },
                    selected = false,
                    onClick = {
                        component = "Posts"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

            }
        }) {
        Column {
            when (component) {
                "Content1" ->
                    Content1()

                "Content2" ->
                    Content2()

                "Button" ->
                    Buttons()

                "FloatingButtons" ->
                    FloatingButtons()

                "Chips" ->
                    Chips()

                "InputExample" ->
                    InputChipExample("Dimiss", {})

                "Progress" ->
                    Progress()

                "Sliders" ->
                    Sliders()

                "Switches" ->
                    Switches()

                "Badges" ->
                    Badges()

                "TimePickers" ->
                    TimePickers()

                "DatePickers" ->
                    DatePickers()

                "SnackBars" ->
                    SnackBars()

                "AlertDialogs" ->
                    AlertDialogs()

                "Bars" ->
                    Bars()
            }
            InputChipExample("Dismiss", {})

        }
    }
}



@Composable
fun Content1(){
    Text(text = "Content 1")
}

@Composable
fun Content2(){
    Text(text = "Content 2")
}

@Composable
fun Buttons(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        Button(onClick = { }) {
            Text(text = "Filled")
        }
        FilledTonalButton(onClick = { }) {
            Text(text = "Tonal")
        }
        OutlinedButton(onClick = { }) {
            Text(text = "Outlined")
        }
        ElevatedButton(onClick = { }) {
            Text(text = "Outlined")
        }
        TextButton(onClick = { }) {
            Text(text = "Outlined")
        }
    }
        
}

//@Preview
@Composable
fun FloatingButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.FavoriteBorder, "")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.FavoriteBorder, "")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.FavoriteBorder, "")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(Icons.Filled.FavoriteBorder, "")},
            text = { Text(text = "Extended FAB")}
        )
    }
}

//@Preview
@Composable
fun Chips() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        AssistChip(
            onClick = {},
            label = { Text(text = "Assist chip")},
            leadingIcon = {
                Icon(Icons.Filled.Star, "",
                    modifier = Modifier.size(AssistChipDefaults.IconSize))
            }
        )
        var selected by remember { mutableStateOf(false)}
        FilterChip(
            selected = selected,
            onClick = {},
            label = { Text(text = "Filter Chip")},
            leadingIcon = if (selected){
                {
                    Icon(
                        Icons.Filled.Star, "",
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            }else{
                null
            }
        )

    }
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true)}
    if (!enabled) return

    InputChip(
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled},
        label = { Text(text)},
        avatar = {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )

        }
        )

}

//@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
            )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
fun Sliders() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var sliderPosition by remember { mutableStateOf(50) }
        Column {
            Slider(
                value = sliderPosition.toFloat(),
                onValueChange = {sliderPosition = it.toInt() },
                steps = 10,
                valueRange = 0f..100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = sliderPosition.toString()
            )
        }

    }
}

//@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if (checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else{
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}

@Composable
fun Badges() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White

                        ){
                        Text("$itemCount")
                    }
                }
            }
        ) {
           Icon(
               imageVector = Icons.Filled.ShoppingCart,
               contentDescription = "h"
           )
        }
        Button(
            onClick = { itemCount++ }
        ){
            Text("Add item")
        }

    }
}

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickers() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { },
                label = { Text("DOB") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = !showDatePicker }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )

            if (showDatePicker) {
                Popup(
                    onDismissRequest = { showDatePicker = false },
                    alignment = Alignment.TopStart
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 64.dp)
                            .shadow(elevation = 4.dp)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(16.dp)
                    ) {
                        DatePicker(
                            state = datePickerState,
                            showModeToggle = false
                        )
                    }
                }
            }
        }
    }

}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickers(
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val currenTime = Calendar.getInstance()

        val timePickerState = rememberTimePickerState(
            initialHour = currenTime.get(Calendar.HOUR_OF_DAY),
            initialMinute = currenTime.get(Calendar.MINUTE),
            is24Hour = true
        )

        Column {
            TimePicker(state = timePickerState)
        }
    }
}

@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Dismiss")
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("OK")
            }
        },
        text = { content() }
    )
}

//@Preview(showBackground = true)
@Composable
fun SnackBars() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState, Modifier)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }

        Button(:: launchSnackBar) {
            Text("Show SnackBar")

        }

    }
}

//@Preview(showBackground = true)
@Composable
fun AlertDialogs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "f")},
                title = { Text(text = "Confirm Deletion") },
                text = { Text(text = "Are you sure you want to delete this file?") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirm"
                            showAlertDialog = false
                        }
                        )
                    {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Dismiss"
                            showAlertDialog = false
                        }
                    )
                    {
                        Text(text = "Dismiss")
                    }
                }

            )
        }

        Text(selectedOption)

        Button(onClick = {showAlertDialog = true}){
            Text(text = "Show alert dialog")
        }

    }
}

@Composable
fun Bars() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                text = "App Title",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                Icons.Filled.Settings,
                contentDescription = "",
                tint = Color.White
            )
        }

        var post = arrayOf(
            PostModel(1, "Title 1", "Text1"),
            PostModel(2, "Title 2", "Text2"),
            PostModel(3, "Title 3", "Text3"),
            PostModel(4, "Title 4", "Text4")
        )

        Column(
            modifier = Modifier
                .padding(10.dp, 90.dp, 10.dp, 50.dp)
                .fillMaxSize()
        ){
            Posts(post)
        }


        Row(
            modifier = Modifier
                //alinier al top center falta **
                .fillMaxWidth()
                .height(65.dp)
                .background(Color.Black)
                .padding(2.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        Icons.Outlined.Home, contentDescription = "", tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }
                Text(text = "Home", color = Color.White)
            }
            Column {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        Icons.Outlined.Home, contentDescription = "", tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }
                Text(text = "Alerts", color = Color.White)
            }
            Column {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        Icons.Outlined.Home, contentDescription = "", tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }
                Text(text = "XD", color = Color.White)
            }
            Column {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        Icons.Outlined.Home, contentDescription = "", tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }
                Text(text = "other", color = Color.White)
            }
            Column {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        Icons.Outlined.Home, contentDescription = "", tint = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                    )

                }
                Text(text = "Other", color = Color.White)
            }
        }
    }
}

@Composable
fun Posts(arrayPosts : Array<PostModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(arrayPosts) { post ->
            Text(
                text = post.title,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 2.dp)
        }
    }
}

