package com.example.uas_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_anmp.R
import com.example.uas_anmp.databinding.HobbyItemLayoutBinding
import com.example.uas_anmp.model.Hobby

class HobbyListAdapter(val hobbyList:ArrayList<Hobby>,val adapterOnClick:(Any) -> Unit)
    :RecyclerView.Adapter<HobbyListAdapter.HobbyViewHolder>(),HobbyCheckedChangeListener,HobbyDetailClickListener {

    class HobbyViewHolder(var binding: HobbyItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = DataBindingUtil.inflate<HobbyItemLayoutBinding>(inflater,
            R.layout.hobby_item_layout, parent, false)

        return HobbyViewHolder(view)


    }

    override fun getItemCount(): Int {
        return hobbyList.size
    }
    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        holder.binding.hobby = hobbyList[position]
        holder.binding.listener = this
        holder.binding.detailListener = this
        /*holder.binding.checkBox.text = hobbyList[position].judul
        holder.binding.textView.text = hobbyList[position].author.nama

        holder.binding.checkBox.setOnCheckedChangeListener{ compoundButton, b ->
            adapterOnClick(hobbyList[position])
        }*/

    }
    fun updateHobbyList(newHobbyList: List<Hobby>) {
        hobbyList.clear()
        hobbyList.addAll(newHobbyList)
        notifyDataSetChanged()
    }

    override fun onHobbyCheckedChanged(cb: CompoundButton, isChecked: Boolean, obj: Hobby) {
        if(isChecked){
            adapterOnClick(obj)
        }
    }

    override fun onHobbyDetailClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = ListHobbyFragmentDirections.actionlistToDetail(uuid)

        Navigation.findNavController(v).navigate(action)

    }

}