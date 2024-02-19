package com.example.addnamesavedata1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val names = mutableListOf<String>()

    fun addName(name: String) {
        names.add(name)
    }

    fun getNames(): String {
        return names.joinToString("\n")
    }
}
