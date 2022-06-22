package Mary.dev.workoutlogo

import Mary.dev.workoutlogo.databinding.ActivityLoginBinding
import Mary.dev.workoutlogo.databinding.ActivitySignupBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.DisplayNameSources.EMAIL
import android.provider.ContactsContract.Intents.Insert.EMAIL
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding
//    lateinit var tvlogin: TextView
//    lateinit var etfirstname:TextInputEditText
//    lateinit var tilfirstname:TextInputLayout
//    lateinit var etlastname:TextInputEditText
//    lateinit var tillastname:TextInputLayout
//    lateinit var etemailaddress: TextInputEditText
//    lateinit var etpassword: TextInputEditText
//    lateinit var etconfirmpassword:TextInputEditText
//    lateinit var tilconfirmpassword:TextInputLayout
//    lateinit var tilemailaddress: TextInputLayout
//    lateinit var tilpassword: TextInputLayout
//    lateinit var btnsignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //        tvlogin = findViewById(R.id.tvlogin)
//        etfirstname=findViewById(R.id.etfirstname)
//        tilfirstname=findViewById(R.id.tilfirstname)
//        etlastname=findViewById(R.id.etlastname)
//        tillastname=findViewById(R.id.tillastname)
//        etemailaddress= findViewById(R.id.etemailaddress)
//        etpassword = findViewById(R.id.etpassword)
//        etconfirmpassword= findViewById(R.id.etconfirmpassword)
//        btnsignup = findViewById(R.id.btnsignup)
//        tilemailaddress = findViewById(R.id.tilemailaddress)
//        tilpassword = findViewById(R.id.tilpassword)
//        tilconfirmpassword= findViewById(R.id.tilconfirmpassword)
        castView()
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
        var email = binding.etemailaddress.text.toString()
        var password = binding.etpassword.text.toString()
        var confirmpassword=binding.etconfirmpassword.text.toString()
        var error=false
        binding.tilfirstname.error=null
        binding.tillastname.error=null
        binding.tilemailaddress.error=null
        binding.tilpassword.error=null
        binding.tilconfirmpassword.error=null


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
            binding.tilemailaddress.error = "Email is required"
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
            binding.tilemailaddress.error="Email is invalid"
        }
        if(!error){

        }
    }
}

