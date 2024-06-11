package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentLoginBinding
import com.example.uas_anmp.model.User
import com.example.uas_anmp.viewmodel.UserViewModel

class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var viewmodel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewmodel.loginSuccess.observe(viewLifecycleOwner) { success ->
            if (success) {

                findNavController().navigate(R.id.actionloginTolistHobby)
            } else {
                Toast.makeText(requireContext(), "Username atau Password Salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.txtusernameLGN.text.toString()
            val password = binding.txtpasswordLGN.text.toString()
            viewmodel.login(username, password)
        }

    }

}