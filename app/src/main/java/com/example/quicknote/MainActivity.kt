package com.example.quicknote

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.quicknote.databinding.ActivityMainBinding
import com.example.quicknote.ui.activity.AddNotesActivity
import com.example.quicknote.ui.fragment.HomeFragment
import com.example.quicknote.ui.fragment.NotificationFragment
import com.example.quicknote.ui.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideSystemUI(binding.coordinatorLayout, true)

        loadFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home_fragment -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.item_dashboard -> {
//                    loadFragment(ChatFragment())
                    true
                }
                R.id.item_notification -> {
                    loadFragment(NotificationFragment())
                    true
                }
                R.id.item_account -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnApplyWindowInsetsListener { view, insets ->
            view.updatePadding(bottom = 0)

            insets
        }

        val navController = findNavController(R.id.container)

        val handler = Handler()
        handler.postDelayed({

        }, 1000)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when (destination.id) {
                R.id.fragment2_6ExpandCollapseList -> {
                    binding.fab.setImageState(intArrayOf(-android.R.attr.state_activated), true)
                    binding.fab.show()
                    binding.bottomAppBar.performShow()
                }

                R.id.fragment2_6ExpandCollapseDetails -> {
                    binding.fab.setImageState(intArrayOf(android.R.attr.state_activated), true)

                }

                R.id.fragment_add_notes -> {
                }
            }
        }

        binding.fab.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, AddNotesActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
//            loadFragment(AddNoteFragment())
        }
    }

    private fun hideSystemUI(view: View = window.decorView, isFullScreen: Boolean) {

        var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (isFullScreen) {
            uiOptions = (
                    uiOptions
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    )
        }

        view.systemUiVisibility = uiOptions
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }


}