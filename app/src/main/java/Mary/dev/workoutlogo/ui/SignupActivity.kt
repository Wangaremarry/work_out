package Mary.dev.workoutlogo.ui

import Mary.dev.workoutlogo.R
import Mary.dev.workoutlogo.databinding.ActivitySignupBinding
import Mary.dev.workoutlogo.model.*
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
import retrofit2.Call
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        castView()
    }

    override fun onResume() {
        super.onResume()
        userViewModel.signupLiveData.observe(this, Observer{ registerResponse ->
            Toast.makeText(baseContext, registerResponse?.message, Toast.LENGTH_LONG).show()
            persistsignupDetails(registerResponse!!)
            startActivity(Intent(baseContext, Homeactivity::class.java))
        })
        userViewModel.signupError.observe(this, Observer { errorMsg ->
            Toast.makeText(baseContext, errorMsg, Toast.LENGTH_LONG).show()
        })
    }
        fun castView() {
            binding.tvlogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
           binding.btnsignup.setOnClickListener {
                validateSignup()
                val intent = Intent(this, Homeactivity::class.java)
                startActivity(intent)
            }
    }
    fun  validateSignup() {
        var firstname=binding.etfirstname.text.toString()
        var lastname=binding.etlastname.text.toString()
        var email = binding.etmailaddress.text.toString()
        var password = binding.etpassword.text.toString()
        var confirmpassword=binding.etconfirmpassword.text.toString()
        var phonenumber=binding.etphone.text.toString()
        var error=false
        binding.tilfirstname.error=null
        binding.tillastname.error=null
        binding.tilemailddress.error=null
        binding.tilpassword.error=null
        binding.tilconfirmpassword.error=null
        binding.tilphone.error=null


        if (firstname.isBlank()){
            error=true
            binding.tilfirstname.error="First name required"

        }
        if (lastname.isBlank()){
            error=true
            binding.tillastname.error="Last name is required"
        }
        if (email.isBlank()){
            error=true
            binding.tilemailddress.error = "Email is required"
        }
        if (password.isBlank()){
            error=true
            binding.tilpassword.error = "Password is required"
        }
        if (confirmpassword.isBlank()){
            binding.tilconfirmpassword.error="Confirm password is required"
        }
        if(confirmpassword!=password){
            error=true
            binding.tilconfirmpassword.error="Password does not match"
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilemailddress.error="Email is invalid"
        }
        if (phonenumber.isBlank()){
            binding.tilphone.error="Phone number is required"
        }
        if(!error){
            binding.pvregister.visibility=View.VISIBLE
            var registerRequest= RegisterRequest(firstname,lastname,phonenumber,email,password)
            userViewModel.signup(registerRequest)

        }
    }
    fun persistsignupDetails(registerResponse: RegisterResponse) {
        val editor = sharedPrefs.edit()
        editor.putString("first_name", registerResponse.firstName)
        editor.putString("last_name", registerResponse.lastName)
        editor.putString("phone_number", registerResponse.phone_number)
        editor.apply()
    }

}

