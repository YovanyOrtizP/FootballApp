package com.example.footballapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.footballapp.R
import com.example.footballapp.ui.football.FootballFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_info, FootballFragment())
            .commit()
    }
}