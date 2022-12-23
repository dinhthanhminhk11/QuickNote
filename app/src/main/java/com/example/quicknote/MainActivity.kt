package com.example.quicknote

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.transition.Transition
import androidx.transition.TransitionListenerAdapter
import androidx.transition.TransitionManager
import com.example.quicknote.databinding.ActivityMainBinding
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideSystemUI(binding.coordinatorLayout, true)

        val navHostFragment = findViewById<View>(R.id.nav_host_fragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            navHostFragment.visibility = View.INVISIBLE

            val transition: Transition = when (it.itemId) {
                R.id.item_home_fragment -> {
                    MaterialFadeThrough()
                }
                R.id.item_dashboard -> {
                    MaterialSharedAxis(MaterialSharedAxis.X, true)
                }
                R.id.item_notification -> {
                    MaterialSharedAxis(MaterialSharedAxis.Y, true)
                }
                else -> {
                    MaterialElevationScale(true)
                }
            }

            /*
                🔥 This is deliberately slow to show how Material Transitions work.
                MaterialFadeThrough, MaterialElevationScale, and MaterialSharedAxis with Z
                almost look like each other
             */

            transition.apply {
                duration = 900
            }
                .addListener(object : TransitionListenerAdapter() {

                    override fun onTransitionEnd(transition: Transition) {
                        super.onTransitionEnd(transition)
                        Toast.makeText(
                            applicationContext,
                            "Activity ${transition::class.java.simpleName} transition end",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

            TransitionManager.beginDelayedTransition(binding.coordinatorLayout, transition)
            navHostFragment.visibility = View.VISIBLE
            true
        }

        binding.bottomNavigation.setOnApplyWindowInsetsListener { view, insets ->
            view.updatePadding(bottom = 0)

            insets
        }

        val navController = findNavController(R.id.nav_host_fragment)

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

                R.id.fragment2_6Compose -> {


                }
            }
        }

        binding.fab.setOnClickListener {
            if (navController.currentDestination?.id == R.id.fragment2_6ExpandCollapseList) {
                Toast.makeText(applicationContext, "Compose", Toast.LENGTH_SHORT).show()


                // Set a custom animation for showing and hiding the FAB
                binding.fab.setShowMotionSpecResource(R.animator.fab_show)
                binding.fab.setHideMotionSpecResource(R.animator.fab_hide)
                binding.bottomAppBar.performHide()
                binding.fab.hide()

                findNavController(R.id.nav_host_fragment).navigate(R.id.action_fragment2_6ExpandCollapseList_to_fragment2_6Compose)
            } else if (navController.currentDestination?.id == R.id.fragment2_6ExpandCollapseDetails) {
                onBackPressed()

            }
        }
    }

    private fun hideSystemUI(view: View = window.decorView, isFullScreen: Boolean) {

        var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (isFullScreen) {
            uiOptions = (
                    uiOptions
//                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Views can use nav bar space if set
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            // Removes Status bar
//                            or View.SYSTEM_UI_FLAG_FULLSCREEN
//                            // Removes nav bar
//                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    )
        }

        view.systemUiVisibility = uiOptions
    }

}