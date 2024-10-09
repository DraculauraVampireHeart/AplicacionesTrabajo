package com.example.ejemploenclase1.ui.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import com.example.ejemploenclase1.R

@Composable
fun PostCard(id:Int,title:String,text:String,image:Painter){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ){
        Text(text = "Card Title",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            painter = image,
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "This is the card text",
            fontSize = 10.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun PostCardCompact (id:Int,title:String,text:String,image:Painter){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ){
        Row (){
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(100.dp)
                    .padding(5.dp),
                painter = image,
                contentDescription = "Imagen random",
                contentScale = ContentScale.FillBounds
            )
            Column {
                Text(text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = text,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Justify,
                    maxLines = 3,

                )

            }

        }
    }

}