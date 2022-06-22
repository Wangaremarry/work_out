package Mary.dev.workoutlogo

import Mary.dev.workoutlogo.databinding.ActivityHomeactivityBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Homeactivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeactivityBinding
//    lateinit var bottom_navigation: BottomNavigationView
//    lateinit var fcvhome: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityHomeactivityBinding.inflate(layoutInflater)
    setContentView(binding.root)
        setupBottomNav()

    }

//    fun castView() {
////        binding.bottomNavigation = findViewById(R.id.bottom_navigation)
////        fcvhome= findViewById(R.id.fcvhome)
//
//    }

    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener{ item->
            when (item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvhome,PlanFragment()).commit()
                    true
                }
                R.id.track->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvhome,Track_Fragment()).commit()
                    true
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvhome,Profile_Fragment()).commit()
                    true
                }
                else-> false
            }
        }
    }
}