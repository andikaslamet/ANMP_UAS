package com.example.uas_anmp.view

import android.view.View
import android.widget.CompoundButton
import com.example.uas_anmp.model.Hobby

interface HobbyCheckedChangeListener {
    fun onHobbyCheckedChanged(cb: CompoundButton,
                         isChecked:Boolean,
                         obj: Hobby)
}
interface  HobbyDetailClickListener{
    fun onHobbyDetailClick(v:View)
}
