package com.example.quicknote.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quicknote.R
import com.example.quicknote.databinding.ActivityAddNotesBinding
import com.example.quicknote.ui.view.SlideBackLayout

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationIconTint(R.drawable.ic_round_done_24)

        binding.toolbar.title = ""
        binding.toolbar.setNavigationOnClickListener{

        }
    }
}