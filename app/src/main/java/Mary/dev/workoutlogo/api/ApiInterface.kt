package Mary.dev.workoutlogo.api

import Mary.dev.workoutlogo.model.LoginRequest
import Mary.dev.workoutlogo.model.LoginRespond
import Mary.dev.workoutlogo.model.RegisterRequest
import Mary.dev.workoutlogo.model.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
    @POST("/login")
    suspend  fun loginUser(@Body loginRequest: LoginRequest): Response<LoginRespond>
}