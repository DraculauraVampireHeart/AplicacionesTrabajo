package com.example.ejemploenclase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemploenclase1.ui.theme.EjemploEnClase1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                Text(text = "Simple text")
                ModifierExample()
                ModifierExample2()
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