package com.example.addnamesavedata1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesavedata1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        if (savedInstanceState != null) {
            viewModel.names.clear()
            viewModel.names.addAll(savedInstanceState.getStringArrayList("names") ?: emptyList())
            updateNameList()
        }

        binding.button.setOnClickListener {
            val name = binding.textView1.text.toString()
            if (name.isNotBlank()) {
                viewModel.addName(name)
                updateNameList()
            } else {
                binding.textView2.text = "No Name Entered"
            }
        }
        setContentView(binding.root)
    }

    private fun updateNameList() {
        binding.textView2.text = viewModel.getNames()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("names", ArrayList(viewModel.names))
    }
}