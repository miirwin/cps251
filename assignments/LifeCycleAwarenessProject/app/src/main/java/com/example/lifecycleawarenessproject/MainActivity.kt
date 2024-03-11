package com.example.lifecycleawarenessproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var demoOwner: DemoOwner
    private lateinit var textView: TextView
    private lateinit var viewModel: DemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        viewModel = ViewModelProvider(this)[DemoViewModel::class.java]

        demoOwner = DemoOwner(lifecycle, DemoObserver(textView, viewModel))
        demoOwner.startOwner()
    }

    override fun onPause() {
        super.onPause()
        demoOwner.stopOwner()
    }

    override fun onResume() {
        super.onResume()
        demoOwner.startOwner()
    }

    override fun onDestroy() {
        super.onDestroy()
        demoOwner.destroyOwner()
    }
}