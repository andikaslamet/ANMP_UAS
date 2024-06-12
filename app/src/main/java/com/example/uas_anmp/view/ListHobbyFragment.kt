package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.FragmentListHobbyBinding
import com.example.uas_anmp.model.Hobby
import com.example.uas_anmp.viewmodel.ListHobbyViewModel

class ListHobbyFragment : Fragment() {
    private lateinit var binding:FragmentListHobbyBinding
    private lateinit var viewModel: ListHobbyViewModel
    private val hobbyListAdapter:HobbyListAdapter = HobbyListAdapter(arrayListOf(),
        { item -> doClick(item)})
    fun doClick(item:Any){
        viewModel.clearTask(item as Hobby)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListHobbyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListHobbyViewModel::class.java)
        viewModel.refresh()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = hobbyListAdapter

        binding.floatingActionButton.setOnClickListener(){
            val action = ListHobbyFragmentDirections.actionlistTocreate()
            Navigation.findNavController(it).navigate(action)
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.hobbyLD.observe(viewLifecycleOwner, Observer {
            hobbyListAdapter.updateHobbyList(it)
            if(it.isEmpty()) {
                binding.recyclerView?.visibility = View.GONE
                binding.txtEmpty.visibility = View.VISIBLE
            } else {
                binding.recyclerView?.visibility = View.VISIBLE
                binding.txtEmpty.visibility = View.GONE
            }
        })

    }
}