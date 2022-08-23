package Mary.dev.workoutlogo.viewmodel

import Mary.dev.workoutlogo.model.LoginRequest
import Mary.dev.workoutlogo.model.LoginRespond
import Mary.dev.workoutlogo.model.RegisterRequest
import Mary.dev.workoutlogo.model.RegisterResponse
import Mary.dev.workoutlogo.repository.UserRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class UserViewModel:ViewModel() {
    val userRepository= UserRepository()
    val loginLiveData = MutableLiveData<LoginRespond>()
    val loginError = MutableLiveData<String>()
    val signupLiveData=MutableLiveData<RegisterResponse>()
    val signupError=MutableLiveData<String>()

     fun login(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }

    fun signup(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.signupUser(registerRequest)
            if (response.isSuccessful){
                signupLiveData.postValue(response.body())
            }
                else{
                    signupError.postValue(response.errorBody()?.string())
                }
            }
        }
    }





