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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.ejemploenclase1.data.model.controller.LoginState
import com.example.ejemploenclase1.data.model.controller.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
//import coil.compose.AsyncImage

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {

    val loginState by viewModel.loginState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginForm(navController, viewModel, loginState)
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoginForm() {
    LoginForm(
        navController = rememberNavController(),
        viewModel = LoginViewModel(),
        loginState = LoginState.Idle
    )
}

@Composable
fun LoginForm(
    navController: NavController,
    viewModel: LoginViewModel,
    loginState: LoginState
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color.DarkGray
        ),
        modifier = Modifier
            .padding(40.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            // Cargar recursos desde una URL
            AsyncImage(
                model = "https://www.pngkey.com/png/full/183-1838196_github-white-logo-png.png",
                contentDescription = "Github logo",
                contentScale = ContentScale.Fit
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                value = user,
                onValueChange = { user = it },
                label = { Text("User", color = Color.White) },
                textStyle = TextStyle(color = Color.White) // Cambiamos el color del texto ingresado
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                textStyle = TextStyle(color = Color.White), // Cambiamos el color del texto ingresado
                visualTransformation = PasswordVisualTransformation()
            )

            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                onClick = {
                    viewModel.login(user, password)
                }
            ) {
                Text("Login")
            }


            when (loginState) {
                is LoginState.Idle -> Text("Insert your user and password")
                is LoginState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                is LoginState.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate("menu")
                    }
                }
                is LoginState.Error -> Text(
                    text = (loginState as LoginState.Error).message,
                    color = Color.White,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}