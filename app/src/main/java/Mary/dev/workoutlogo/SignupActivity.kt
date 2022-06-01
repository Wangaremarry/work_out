package Mary.dev.workoutlogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tvlogin: TextView
    lateinit var etfirstname:TextInputEditText
    lateinit var tilfirstname:TextInputLayout
    lateinit var etlastname:TextInputEditText
    lateinit var tillastname:TextInputLayout
    lateinit var etemailaddress: TextInputEditText
    lateinit var etpassword: TextInputEditText
    lateinit var etconfirmpassword:TextInputEditText
    lateinit var tilconfirmpassword:TextInputLayout
    lateinit var tilemailaddress: TextInputLayout
    lateinit var tilpassword: TextInputLayout
    lateinit var btnsignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        tvlogin = findViewById(R.id.tvlogin)
        etfirstname=findViewById(R.id.etfirstname)
        tilfirstname=findViewById(R.id.tilfirstname)
        etlastname=findViewById(R.id.etlastname)
        tillastname=findViewById(R.id.tillastname)
        etemailaddress= findViewById(R.id.etemailaddress)
        etpassword = findViewById(R.id.etpassword)
        btnsignup = findViewById(R.id.btnsignup)
        tilemailaddress = findViewById(R.id.tilemailaddress)
        tilpassword = findViewById(R.id.tilpassword)

        tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnsignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            validateSignup()
        }
    }
    fun  validateSignup() {
        var firstname=etfirstname.text.toString()
        var lastname=etlastname.text.toString()
        var email = etemailaddress.text.toString()
        var password = etpassword.text.toString()
        var confirmpassword=etconfirmpassword.text.toString()

        if (firstname.isBlank()){
            tilfirstname.error="First name required"
        }
        if (lastname.isBlank()){
            tillastname.error="Last name is required"
        }
        if (email.isBlank()){
            tilemailaddress.error = "Email is required"
        }
        if (password.isBlank()){
            tilpassword.error = "Password is required"
        }
        if (confirmpassword.isBlank()){
            tilconfirmpassword.error="Confirm password is required"
        }
    }

}
