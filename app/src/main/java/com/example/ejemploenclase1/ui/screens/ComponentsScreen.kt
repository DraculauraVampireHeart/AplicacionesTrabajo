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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
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
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.ejemploenclase1.data.model.MenuModel
import com.example.ejemploenclase1.data.model.PostModel
import com.example.ejemploenclase1.ui.components.PostCard
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import com.example.ejemploenclase1.R
import com.example.ejemploenclase1.ui.components.PostCardCompact


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Components(navController: NavController) {
    var menuOptions = arrayOf(
        MenuModel(1,"Content 1","Content1",Icons.Filled.Home),
        MenuModel(2,"Content 2","Content2",Icons.Filled.FavoriteBorder),
        MenuModel(3,"Buttons","Buttons",Icons.Filled.AccountBox),
        MenuModel(4,"Floating Buttons","Floating",Icons.Filled.CheckCircle),
        MenuModel(5,"Chips","Chips",Icons.Filled.Check),
        MenuModel(6,"Progress","Progress",Icons.Filled.Refresh),
        MenuModel(7,"Sliders","Sliders",Icons.Filled.KeyboardArrowDown),
        MenuModel(8,"Switches","Switches",Icons.Filled.Warning),
        MenuModel(9,"Badges","Badges",Icons.Filled.ShoppingCart),
        MenuModel(10,"TimePickers","TimePickers",Icons.Filled.Notifications),
        MenuModel(11,"DatePickers","DatePickers",Icons.Filled.DateRange),
        MenuModel(12,"AlertDialogs","AlertDialogs",Icons.Filled.Warning),
        MenuModel(13,"SnackBars","SnackBars",Icons.Filled.Settings),
        MenuModel(14,"Bars","Bars",Icons.Filled.Favorite),
        MenuModel(15,"Adaptative","Adaptative",Icons.Filled.Menu),
    )
    // In order to support horizontal page view change, remember Saveable
    var component by rememberSaveable{ mutableStateOf("") } //Can assign a value
    // A reactive component to UI COMPONENTS
    // A global variable that its state can by updated using buttons

    var drawerState = rememberDrawerState(initialValue= DrawerValue.Closed)
    val scope = rememberCoroutineScope() //Update drawer state, is it closed?
    ModalNavigationDrawer( //Screen that displays above our content
        drawerState=drawerState, //Current state of drawer
        // drawer content
        drawerContent = { //Content of menu
            ModalDrawerSheet {
                Text("Menu",
                    modifier = Modifier
                        .padding(16.dp))
                HorizontalDivider() // Line
                LazyColumn{
                    items(menuOptions){
                            item ->
                        NavigationDrawerItem(
                            icon = {Icon(item.icon, contentDescription = null)},
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                component=item.option
                                scope.launch {
                                    drawerState.apply {
                                        close() // Close drawer or side menu
                                    }
                                }
                            }
                        )
                    }
                }
                //Show content 1
                /*NavigationDrawerItem(label = { Text("Content 1") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Content1"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )
                // Show content 2
                NavigationDrawerItem(label = { Text("Content 2") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Content2"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )*/
                //Buttons
                /*NavigationDrawerItem(label = { Text("Buttons") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Buttons"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //Floating
                NavigationDrawerItem(label = { Text("Floating Buttons") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Floating"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                // Chips
                NavigationDrawerItem(label = { Text("Chips") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Chips"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )


                //Progress()
                NavigationDrawerItem(label = { Text("Progress") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Progress"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )
                //Sliders()
                NavigationDrawerItem(label = { Text("Sliders") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Sliders"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )
                //Switches()
                NavigationDrawerItem(label = { Text("Switches") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Switches"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //Badges
                NavigationDrawerItem(label = { Text("Badges") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Badges"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )


                //TimePickers
                NavigationDrawerItem(label = { Text("TimePickers") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="TimePickers"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //DatePickers
                NavigationDrawerItem(label = { Text("DatePickers") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="DatePickers"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //AlertDialogs
                NavigationDrawerItem(label = { Text("AlertDialogs") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="AlertDialogs"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //SnackBars
                NavigationDrawerItem(label = { Text("SnackBars") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="SnackBars"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )

                //Bars
                NavigationDrawerItem(label = { Text("Bars") }, //TITLE OF BUTTON //fist item
                    selected = false //is selected?
                    , onClick = {
                        component="Bars"
                        scope.launch {
                            drawerState.apply {
                                close() // Close drawer or side menu
                            }
                        }
                    }
                )*/
            }

        }) {
        Column{
            when(component){
                "Content1" -> {
                    Content1()
                }
                "Content2" ->{
                    Content2()
                }
                "Buttons" ->{
                    Buttons()
                }
                "Floating" ->{
                    FloatingButtons()
                }
                "Chips" ->{
                    Chips()
                }
                "Progress"->{
                    Progress()
                }
                "Sliders"->{
                    Sliders()
                }
                "Switches"->{
                    Switches()
                }
                "Badges"->{
                    Badges()
                }
                "TimePickers" ->{
                    TimePickers()
                }
                "DatePickers"->{
                    DatePickers()
                }
                "AlertDialogs"->{
                    AlertDialogs()
                }
                "SnackBars"->{
                    SnackBars()
                }
                "Bars"->{
                    Bars()
                }
                "Adaptative"->{
                    Adaptative()
                }


            }
            /*Text(text = component)
            Text(text="This is the Components")
            Button(onClick = { navController.navigate("menu")}) {
            }
            Content1()
            Content2()*/
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

@Preview(showBackground = true)
@Composable
private fun Bars() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
    ){
        Row( //Custom Header
            modifier= Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(Icons.Filled.Menu, "", tint = Color.White)
            Text(
                "App Title",
                color=Color.White,
                fontWeight = FontWeight.Bold,
                fontSize=20.sp
            )
            Icon(Icons.Filled.Settings, "", tint = Color.White)
        }

        var post = arrayOf(
            PostModel(1,"Title1","Text1",painterResource(R.drawable.blackpink)),
            PostModel(2,"Title2","Text2",painterResource(R.drawable.j0b8jkwfohdd1)),
            PostModel(3,"Title3","Text3",painterResource(R.drawable.j0b8jkwfohdd1)),
            PostModel(4,"Title4","Text4",painterResource(R.drawable.zb1pfp)),
            PostModel(5,"Title5","Text5",painterResource(R.drawable.lisapfp))
        )

        PostGrid(arrayPosts = post)


        Row( //Bottom Nav Bar
            modifier= Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .height(60.dp)
                .padding(2.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){ //Bottom Bar
            /**
             * Icons on the bottom nav bar
             */
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Favorite,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Search", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Menu,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Men", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Home,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Home", color=Color.White)
            }
            Column{
                IconButton(onClick={}, modifier = Modifier.size(30.dp)){
                    Icon(Icons.Outlined.Settings,
                        contentDescription="",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text("Settings", color=Color.White)
            }
        }
    }
}

@Composable
fun Posts(arrayPosts : Array<PostModel>, adaptive:String) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(arrayPosts) { post ->
            when(adaptive){
                "PhonePort  rait" ->{
                    PostCardCompact(post.id, post.title, post.text, post.image)
                }
                "PhoneLandscape" ->{
                    PostCard(post.id, post.title, post.text, post.image)
                }

            }

        }
    }
}

@Composable
fun PostGrid(arrayPosts: Array<PostModel>){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(arrayPosts) { post ->
            PostCard(post.id, post.title, post.text, post.image)
        }
    }
}

@Preview(showBackground = true, device = "spec:id=reference_tablet,shape=Normal,width=1280,height=800,unit=dp,dpi=240")
@Composable
fun Adaptative(){
    var WindowSize = currentWindowAdaptiveInfo()
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    // Compact height < 600dp phones in portrait mode
    // Medium width >= 600dp < 840dp Tablets in portrait mode
    // Expanded width > 840dp Tblet in landscape mode

    //Compact height < 480dp Phone in landscape mode
    //Medium height >= 480dp < 900dp Tablet landscape or Phone in portrait
    //Expanded > 900dp Tablet in portrait

    var post = arrayOf(
        PostModel(1, "Title 1", "Text1", painterResource(R.drawable.j0b8jkwfohdd1)),
        PostModel(2, "Title 2", "Text2", painterResource(R.drawable.blackpink)),
        PostModel(3, "Title 3", "Text3", painterResource(R.drawable.blackpink)),
        PostModel(4, "Title 4", "Text4", painterResource(R.drawable.blackpink))
    )

    if (width == WindowWidthSizeClass.COMPACT){
        Posts(post,"PhonePortrait")
    }else if (height == WindowHeightSizeClass.COMPACT){
        Posts(post,"PhoneLandscape")

    }else{
        Posts(post, "Otros dispositivos")
    }

    //Text(text = WindowSize.toString())
}

