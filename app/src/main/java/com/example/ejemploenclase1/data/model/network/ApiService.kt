package com.example.ejemploenclase1.data.model.network

import com.example.ejemploenclase1.data.model.ServiceModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @POST("user")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("service")
    suspend fun getServices(): Response<List<ServiceModel>>

    @GET("service/{id}")
    suspend fun getService(@Path("id") id: Int): Response<ServiceModel>

    @POST("service")
    suspend fun createService(@Body service: ServiceModel): Response<ServiceModel>

    @PUT("service/{id}")
    suspend fun updateService(@Path("id") id:Int, @Body service: ServiceModel): Response<ServiceModel>

    @DELETE("service/{id}")
    suspend fun deleteService(@Path("id") id:Int):Response<ServiceModel>

}

data class LoginResponse(
    val login: String,
    val user: List<User>
)
data class LoginRequest(
    val username: String,
    val password: String
)
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val password: String
)