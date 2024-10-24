package com.example.ejemploenclase1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun LoginScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginForm(navController)

    }
}

@Composable
fun LoginForm(navController: NavController){
    var user by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color.Gray
        ),
        modifier = Modifier
            .padding(40.dp, 0.dp)
    ){
        Column(modifier = Modifier
            .padding(20.dp)
        ){
            AsyncImage(
                model = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/d082a537-9a45-4512-af54-08c87b335298/db1elsa-d4d90e83-c6c9-488e-bde0-3894eb30958c.png/v1/fill/w_1423,h_562/_blackpink__logo___png_by_tsukinofleur_db1elsa-pre.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTA2NiIsInBhdGgiOiJcL2ZcL2QwODJhNTM3LTlhNDUtNDUxMi1hZjU0LTA4Yzg3YjMzNTI5OFwvZGIxZWxzYS1kNGQ5MGU4My1jNmM5LTQ4OGUtYmRlMC0zODk0ZWIzMDk1OGMucG5nIiwid2lkdGgiOiI8PTI3MDAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.ddMtEYC6cKZaEQSYzSusQI3Qf0QO0CmJEyIcsIvEbUw",
                contentDescription = "My band",
                contentScale = ContentScale.Fit
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = user,
                maxLines = 1,
                onValueChange = {user = it},
                label = { Text("User") }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                maxLines = 1,
                onValueChange = {password = it},
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                onClick = {}
            ) {
                Text("LogIn")
            }
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                onClick = {navController.navigate("home")}
            ) {
                Text("Create an Account")
            }
        }
    }
}