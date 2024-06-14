package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentProfileBinding
import com.example.uas_anmp.model.User
import com.example.uas_anmp.model.UserDao
import com.example.uas_anmp.model.UserDatabase
import com.example.uas_anmp.viewmodel.ListHobbyViewModel
import com.example.uas_anmp.viewmodel.ProfileViewModel
import com.example.uas_anmp.viewmodel.UserViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding:FragmentProfileBinding
    private lateinit var viewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val user = viewModel.getLoggedInUser()
        updateUI(user)
        binding.btnLogout.setOnClickListener {
            viewModel.logout()
            findNavController().navigate(R.id.actionprofileToLogin)
        }
    }
    private fun updateUI(user: User) {
        binding.apply {
            txtUsernameProf.text = user.username
            txtPasswordProf.text = user.password
            txtEmailProf.text = user.email
            txtFirstNameProf.text = user.firstname
            txtLastNameProf.text = user.lastname
        }
    }
}