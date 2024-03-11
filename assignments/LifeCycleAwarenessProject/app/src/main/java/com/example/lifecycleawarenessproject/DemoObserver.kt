package com.example.lifecycleawarenessproject

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DemoObserver(private val textView: TextView, private val viewModel: DemoViewModel) : DefaultLifecycleObserver {

    private val TAG = "DemoObserver"

    private fun getCurrentTime(): String {
        val time = SimpleDateFormat("HH:mm:ss.SSS", Locale.US)
        return time.format(Date())
    }

    private fun updateTextView(event: String) {
        val currentText = viewModel.getData()
        val newText = "$currentText\n$event was fired on ${getCurrentTime()}"
        viewModel.setData(newText)
        textView.text = newText
    }

    private fun logEvent(event: String) {
        Log.i(TAG, event)
        updateTextView(event)
    }

    override fun onCreate(owner: LifecycleOwner) {
        logEvent("onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        logEvent("onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        logEvent("onPause")
    }

    override fun onStart(owner: LifecycleOwner) {
        logEvent("onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        logEvent("onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        logEvent("onDestroy")
    }
}