package com.example.quicknote.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quicknote.R
import com.example.quicknote.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        initView()

    }

    private fun initView() {
        binding.undoBack.setOnClickListener(this)
        binding.undoForward.setOnClickListener(this)
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationIcon(R.drawable.ic_round_done_24)
        supportActionBar?.setBackgroundDrawable(null)
        supportActionBar?.title = ""
        binding.toolbar.setNavigationOnClickListener {
            Toast.makeText(this@AddNotesActivity, "texxt", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            true
        }

        R.id.action_share -> {

            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.undo_back -> {
                Toast.makeText(this, "check 1", Toast.LENGTH_LONG).show()
            }

            R.id.undo_forward -> {
                Toast.makeText(this, "check 1", Toast.LENGTH_LONG).show()
            }
        }
    }
}