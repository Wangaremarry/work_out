package Mary.dev.workoutlogo

import Mary.dev.workoutlogo.databinding.ActivityLoginBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.NullPointerException
import java.util.logging.LogManager

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
//    lateinit var tvsignup: TextView
//    lateinit var etemail: TextInputEditText
//    lateinit var etpassword: TextInputEditText
//    lateinit var tilemail: TextInputLayout
//    lateinit var tilpassword: TextInputLayout
//    lateinit var btnlogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val intent = Intent(this, LoginActivity::class.java)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        tvsignup = findViewById(R.id.tvsignup)
//        etemail = findViewById(R.id.etemail)
//        etpassword = findViewById(R.id.etpassword)
//        btnlogin = findViewById(R.id.btnlogin)
//        tilemail = findViewById(R.id.tilemail)
//        tilpassword = findViewById(R.id.tilpassword)
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
         startActivity(Intent(this,Homeactivity::class.java))
            }
            }
    }






