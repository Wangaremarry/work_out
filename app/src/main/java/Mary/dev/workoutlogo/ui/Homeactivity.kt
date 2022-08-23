package Mary.dev.workoutlogo.ui

import Mary.dev.workoutlogo.R
import Mary.dev.workoutlogo.databinding.ActivityHomeactivityBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Homeactivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityHomeactivityBinding.inflate(layoutInflater)
    setContentView(binding.root)
        setupBottomNav()

    }


    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener{ item->
            when (item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvhome, PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvhome,
                        Track_Fragment()
                    ).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvhome,
                        Profile_Fragment()
                    ).commit()
                    true
                }
                else-> false
            }
        }
    }
}