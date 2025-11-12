package com.example.bmilearningproject.callback

import android.widget.TextView
import com.example.bmilearningproject.model.BlogTopModel

interface BlogTopMenuListener {
    fun onMenuClick(model: BlogTopModel,text : TextView)
}