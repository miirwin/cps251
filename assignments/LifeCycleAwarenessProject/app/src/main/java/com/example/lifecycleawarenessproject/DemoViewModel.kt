package com.example.lifecycleawarenessproject

import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel() {

    private var data: String = ""

    fun getData(): String {
        return data
    }

    fun setData(newData: String) {
        data = newData
    }
}