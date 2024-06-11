package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentRegisterBinding
import com.example.uas_anmp.model.User
import com.example.uas_anmp.viewmodel.UserViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewmodel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.buttonRegister.setOnClickListener {
            var user = User(
                binding.txtusername.text.toString(),
                binding.txtpassword.text.toString(),
                binding.txtemail.text.toString(),
                binding.txtfirstname.text.toString(),
                binding.txtlastname.text.toString(),
            )
            viewmodel.addUser(user)
            //Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
        }
        binding.btnToLogin.setOnClickListener(){
            findNavController().navigate(R.id.actionregistologin)
        }
    }
}