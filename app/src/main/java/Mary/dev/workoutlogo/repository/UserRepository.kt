package Mary.dev.workoutlogo.repository

import Mary.dev.workoutlogo.api.ApiClient
import Mary.dev.workoutlogo.api.ApiInterface
import Mary.dev.workoutlogo.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class UserRepository {
    var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest) = withContext(Dispatchers.IO){
            val respond= apiClient.loginUser(loginRequest)
            return@withContext respond
    }

    suspend fun signupUser(registerRequest: RegisterRequest)= withContext(Dispatchers.IO){
        val respond= apiClient.registerUser(registerRequest)
        return@withContext respond
    }
}