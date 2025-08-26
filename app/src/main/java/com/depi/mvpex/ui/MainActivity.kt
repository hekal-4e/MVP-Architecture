package com.depi.mvpex.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.depi.mvpex.R
import com.depi.mvpex.databinding.ActivityMainBinding
import com.depi.mvpex.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setup()
    }

    private fun setup() {
        viewModel.getUserInfo()
        binding.buttonFetchWisdom.setOnClickListener { viewModel.getWisdom() }

        viewModel.currentUser.observe(this, {
            binding.textUserName.text = it.userName
        })

        viewModel.wisdom.observe(this, {
            binding.apply {
                textDate.text = it.publishDate
                contentHere.text = it.content
            }
        })
    }

}