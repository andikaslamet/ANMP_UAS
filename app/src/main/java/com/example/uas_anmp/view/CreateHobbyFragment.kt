package com.example.uas_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uas_anmp.databinding.FragmentCreateHobbyBinding
import com.example.uas_anmp.model.Hobby
import com.example.uas_anmp.viewmodel.HobbyViewModel

class CreateHobbyFragment : Fragment() {
    private lateinit var binding: FragmentCreateHobbyBinding
    private lateinit var viewmodel:HobbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateHobbyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this).get(HobbyViewModel::class.java)
        binding.btnCreateHobby.setOnClickListener {
            val selectedRadioButtonId = binding.radioGroupPriority.checkedRadioButtonId
            val selectedRadioButton = view.findViewById<RadioButton>(selectedRadioButtonId)

            val categoryText = selectedRadioButton?.text?.toString() ?: ""
            val namaAuthor = binding.txtnamaAuthor.text.toString()
            val emailAuthor = binding.txtemailAuthor.text.toString()

            val author = Hobby.Author(namaAuthor, emailAuthor)
            val hobby = Hobby(
                0,
                binding.txtjudul.text.toString(),
                binding.txtdeskripsiSingkat.text.toString(),
                arrayListOf(categoryText),
                author
            )
            val array = arrayOf(hobby)
            viewmodel.addHobby(array)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }




    }
}