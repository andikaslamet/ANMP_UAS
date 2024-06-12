package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentListHobbyBinding

class ListHobbyFragment : Fragment() {
    private lateinit var binding:FragmentListHobbyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListHobbyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener(){
            val action = ListHobbyFragmentDirections.actionlistTocreate()
            Navigation.findNavController(it).navigate(action)
        }
    }
}