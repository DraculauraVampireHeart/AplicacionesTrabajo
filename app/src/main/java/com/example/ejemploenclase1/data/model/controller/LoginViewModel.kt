package com.example.ejemploenclase1.data.model.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejemploenclase1.data.model.network.LoginRequest
import com.example.ejemploenclase1.data.model.network.RetrofitClient
import com.example.ejemploenclase1.data.model.network.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading
        viewModelScope.launch {
            try {

                val response = RetrofitClient.api.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    val body = response.body()
                    // if para verificar que el proceso fue exitoso
                    if (body != null && body.login == "success" && body.user.isNotEmpty()) {
                        _loginState.value = LoginState.Success(body.user[0]) // válido
                    } else {
                        _loginState.value = LoginState.Error("Informacion Incorrecta") // incorrecto
                    }
                } else {
                    _loginState.value = LoginState.Error("Error en la solicitud: ${response.code()}") // Error de respuesta
                }
            } catch (e: HttpException) {
                _loginState.value = LoginState.Error("Error HTTP: ${e.message}") // Error en la red
            } catch (e: IOException) {
                _loginState.value = LoginState.Error("Error de conexión: ${e.message}") // Problema de conexión
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Error desconocido: ${e.message}") // Otros errores
            }
        }
    }
}



sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val user: User) : LoginState()
    data class Error(val message: String) : LoginState()
}