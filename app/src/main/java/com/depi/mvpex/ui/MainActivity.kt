package com.depi.mvpex.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.depi.mvpex.R
import com.depi.mvpex.databinding.ActivityMainBinding
import com.depi.mvpex.model.domain.User
import com.depi.mvpex.model.domain.Wisdom
import com.depi.mvpex.presnter.MainPresenter

class MainActivity : AppCompatActivity(), IMainView {

    lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter()

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
        setup()
    }

    private fun setup() {
        presenter.view = this
        presenter.getUserInfo()
        binding.buttonFetchWisdom.setOnClickListener { presenter.getWisdom() }
    }

    override fun onUserInfoSuccess(user: User) {
        binding.textUserName.text = user.userName
    }

    override fun onWisdomSuccess(wisdom: Wisdom) {
        binding.apply {
            textDate.text = wisdom.publishDate
            contentHere.text = wisdom.content
        }
    }
}