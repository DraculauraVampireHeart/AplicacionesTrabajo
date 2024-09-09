package com.example.ejemploenclase1

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemploenclase1.ui.theme.EjemploEnClase1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){

                Text(text = "Simple text")
                ModifierExample()
                ModifierExample2()
                ModifierExample3()

                CustomText()
                Picture1()
                Content1()

            }
           //layouts
           /** Column {
                Text(text = "First Row")
                Text(text = "Second Row")
                Text(text = "Third Row")
                Row{
                    Text(text = "BLACKPINK")
                    Text(text = "ROW 2")
                }
                Box{
                    Text(text = "Label 1")
                    Text(text = "Label 2")
                }
                Greeting(name = "BLACKPINK in your area")
            }**/
            
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploEnClase1Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable 
fun ModifierExample(){
    Column (
        modifier = Modifier
            .padding(24.dp)

    ){
        Text(text = "Hello World")
    }
    
}

@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World")
    }

}

fun clickAction(){
    println("Column Clicked")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier

            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Magenta)
            .border(width = 2.dp, color = Color.Blue)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }

}

@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column {
        Text(
            stringResource(R.string.Hello_World_Text),
            color = colorResource(R.color.Pink),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Cyan, Blue)
        Text(
            stringResource(R.string.Hello_World_Text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))

        )
    }
}

@Preview(showBackground = true)
@Composable
fun Picture1(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.j0b8jkwfohdd1),
            contentDescription = "Logo BLACKPINK",
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview (showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = "THIS IS A TITLE",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            painter = painterResource(id = R.drawable.blackpink),
            contentDescription = "Blackpink logo, espero funcione",
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.Style),
            textAlign = TextAlign.Center,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

