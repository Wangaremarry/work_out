package Mary.dev.workoutlogo.ui

import Mary.dev.workoutlogo.R
import Mary.dev.workoutlogo.databinding.ActivityLoginBinding
import Mary.dev.workoutlogo.model.LoginRequest
import Mary.dev.workoutlogo.model.LoginRespond
import Mary.dev.workoutlogo.viewmodel.UserViewModel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        castView()
    }

    fun castView() {
        binding.tvsignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            validateLogin()
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginLiveData.observe(this, Observer{ loginRespond ->
            Toast.makeText(baseContext, loginRespond?.message, Toast.LENGTH_LONG).show()
            persistLoginDetails(loginRespond!!)
            startActivity(Intent(baseContext, Homeactivity::class.java))
        })
        userViewModel.loginError.observe(this, Observer { errorMsg ->
            Toast.makeText(baseContext, errorMsg, Toast.LENGTH_LONG).show()
        })
    }

    fun validateLogin() {
        var error = false
        binding.tilemail.error = null
        binding.tilpassword.error = null
        var email = binding.etemail.text.toString()
        var password = binding.etpassword.text.toString()
        if (email.isBlank()) {
            binding.tilemail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error = true
            binding.tilemail.error = "Email is requied"
        }

        if (!error) {
            binding.pvloginrequest.visibility= View.VISIBLE

            val loginRequest = LoginRequest(email, password)
           userViewModel.login(loginRequest)
        }
    }

    fun persistLoginDetails(loginRespond: LoginRespond) {
        val editor = sharedPrefs.edit()
        editor.putString("USER_ID", loginRespond.userId)
        editor.putString("ACCESS_TOKEN", loginRespond.accessToken)
        editor.putString("PROFILE_ID", loginRespond.profileId)
        editor.apply()
    }
}













