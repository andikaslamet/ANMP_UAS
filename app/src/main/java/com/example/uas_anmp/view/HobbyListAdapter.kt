package com.example.uas_anmp.view

import android.util.Size
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_anmp.databinding.HobbyItemLayoutBinding
import com.example.uas_anmp.model.Hobby

class HobbyListAdapter(val hobbyList:ArrayList<Hobby>,val adapterOnClick:(Any) -> Unit)
    :RecyclerView.Adapter<HobbyListAdapter.HobbyViewHolder>() {
    class HobbyViewHolder(var binding: HobbyItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        var binding = HobbyItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,false)
        return HobbyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return hobbyList.size
    }

    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        holder.binding.checkBox.text = hobbyList[position].judul

        holder.binding.checkBox.setOnCheckedChangeListener{ compoundButton,b ->
            adapterOnClick(hobbyList[position])
        }

    }
    fun updateHobbyList(newHobbyList: List<Hobby>) {
        hobbyList.clear()
        hobbyList.addAll(newHobbyList)
        notifyDataSetChanged()
    }

}