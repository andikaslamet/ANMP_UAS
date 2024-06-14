package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentDetailBinding
import com.example.uas_anmp.viewmodel.DetailHobbyViewModel
import com.example.uas_anmp.viewmodel.ListHobbyViewModel

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailHobbyViewModel
    private lateinit var databinding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail,container,false)
        // Inflate the layout for this fragment
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailHobbyViewModel::class.java)
        val uuid = DetailFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)


        observerViewModel()
    }
    fun observerViewModel() {
        viewModel.hobbyLD.observe(viewLifecycleOwner, Observer {
            databinding.hobby = it
        })
    }


}