package com.example.quicknote.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quicknote.R
import com.example.quicknote.adapter.ActionClickAdapter
import com.example.quicknote.databinding.ActivityAddNotesBinding
import com.example.quicknote.model.ActionClick

class AddNotesActivity : AppCompatActivity(), View.OnClickListener, ActionClickAdapter.Callback {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var adapterActionClickAdapter: ActionClickAdapter
    private lateinit var listActionClick: List<ActionClick>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        loadLanguage()
        initView()

    }

    private fun initView() {
        binding.undoBack.setOnClickListener(this)
        binding.undoForward.setOnClickListener(this)

        adapterActionClickAdapter = ActionClickAdapter(this, listActionClick);
        binding.actionBar.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.actionBar.adapter = adapterActionClickAdapter

    }

    private fun loadLanguage() {
        listActionClick = listOf(
            ActionClick(1, R.drawable.ic_text_aa_bold_svgrepo_com),
            ActionClick(2, R.drawable.ic_check_box_svgrepo_com),
            ActionClick(3, R.drawable.ic_mic_svgrepo_com),
            ActionClick(4, R.drawable.ic_pen_edit_line_svgrepo_com),
            ActionClick(5, R.drawable.ic_image_circle_plus_line_svgrepo_com),
            ActionClick(6, R.drawable.ic_emoji_round_svgrepo_com),
            ActionClick(7, R.drawable.ic_color_palette_outline_svgrepo_com),
            ActionClick(8, R.drawable.ic_list_check_svgrepo_com),
            ActionClick(9, R.drawable.ic_list_number_svgrepo_com)
        )
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

    override fun onCLick(id: Int) {
       Toast.makeText(this, " text", Toast.LENGTH_SHORT).show()
    }
}