package com.example.graduationproject.Ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.graduationproject.R
import com.example.graduationproject.Ui.home.fragment.alarm.AlarmFragment
import com.example.graduationproject.Ui.home.fragment.settings.SettingsFragment
import com.example.graduationproject.Ui.onBoarding.OnBoardingActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), BottomNavigationVisibilityListener {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var floatingButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushFragment(HomeActivity())
       initViews()
      /*  bottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController=findNavController(R.id.fragmentContainerView)
        bottomNavigationView.setupWithNavController(navController)*/
      //  val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
       // val navController = navHostFragment.navController
        floatingButton=findViewById(R.id.floating_butt)

      /*  floatingButton.setOnClickListener {
            navController.navigate(R.id.action_alarmFragment_to_homeActivity)
            navController.navigate(R.id.action_settingsFragment_to_homeActivity)


        }*/
    }

  private fun initViews() {
     //   loadHomeScreen()
        //button home
        floatingButton=findViewById(R.id.floating_butt)
         pushFragment(HomeActivity())
            floatingButton.setOnClickListener {
                loadHomeScreen()
            }
        //button alarm and button setting
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.alarmFragment) {
                pushFragment(AlarmFragment())

            } else if (it.itemId == R.id.settingsFragment) {
                pushFragment(SettingsFragment())

            }

            return@setOnItemSelectedListener true
        }
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment)
            .addToBackStack(null)
            .commit()
    }

   private fun loadHomeScreen() {
       val intent = Intent(this, HomeActivity ::class.java)
       startActivity(intent)
   }
    override fun hideBottomNavigation() {
        findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.GONE
        findViewById<FloatingActionButton>(R.id.floating_butt).visibility = View.GONE
    }

    override fun showBottomNavigation() {
        findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility = View.VISIBLE
        findViewById<FloatingActionButton>(R.id.floating_butt).visibility = View.VISIBLE
    }


}