package Mary.dev.workoutlogo.ui

import Mary.dev.workoutlogo.R
import Mary.dev.workoutlogo.databinding.ActivityLoginBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

castView()
    }
    fun castView(){
        binding.tvsignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
    }
        fun  validateLogin() {
            var error=false
            binding.tilemail.error=null
            binding.tilpassword.error=null
            var email = binding.etemail.text.toString()
            var password = binding.etpassword.text.toString()
            if (email.isBlank()){
                binding.tilemail.error = "Email is required"
                error=true
        }
        if (password.isBlank()){
        binding.tilpassword.error = "Password is required"
            error=true
    }
            if(!error){
         startActivity(Intent(this, Homeactivity::class.java))
            }
            }
    }






