package com.project.frontMobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.frontMobile.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupNav()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    private fun setupNav() {
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(bottomNavView, navController)
        setupActionBarWithNavController(navController)

        manageBottomNavigationVisibility(bottomNavView)
        manageToolbarVisibility()
        manageStatusBar()
    }

    private fun manageBottomNavigationVisibility(bottomNavView: BottomNavigationView) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.libraryFragment -> bottomNavView.visibility = View.VISIBLE
                R.id.upcomingFragment -> bottomNavView.visibility = View.VISIBLE
                R.id.suggestionFragment -> bottomNavView.visibility = View.VISIBLE
                R.id.menuFragment -> bottomNavView.visibility = View.VISIBLE
                else -> bottomNavView.visibility = View.GONE
            }
        }
    }

    private fun manageToolbarVisibility() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.bookFragment -> supportActionBar?.show()
                R.id.authorFragment -> {
                    supportActionBar?.show()
                    supportActionBar?.title = getString(R.string.button_author)
                }
                R.id.settingsFragment -> {
                    supportActionBar?.show()
                    supportActionBar?.title = getString(R.string.button_settings)
                }
                R.id.RGPDFragment -> {
                    supportActionBar?.show()
                    supportActionBar?.title = getString(R.string.button_rgpd)
                }
                R.id.helpFragment -> {
                    supportActionBar?.show()
                    supportActionBar?.title = getString(R.string.button_help)
                }
                else -> {
                    supportActionBar?.hide()
                    supportActionBar?.title = ""
                }
            }
        }
    }

    private fun manageStatusBar() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.authenticationFragment -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                R.id.logInFragment -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                R.id.signUpFragment -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                R.id.forgotPasswordFragment -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                R.id.createProfileFragment -> window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
                else -> window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}