package com.example.uas_anmp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.ActivityMainBinding
import com.example.uas_anmp.viewmodel.SharedPreference

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private lateinit var sharepf : SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}