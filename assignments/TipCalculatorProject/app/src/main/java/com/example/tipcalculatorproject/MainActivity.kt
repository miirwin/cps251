package com.example.tipcalculatorproject


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculatorproject.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var resultText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextNumberDecimal: EditText = binding.editTextNumberDecimal
        val convertButton: Button = binding.button
        val resultTextView: TextView = binding.textView

        convertButton.setOnClickListener {
            val enteredAmount: String = editTextNumberDecimal.text.toString()

            if (enteredAmount.isNotEmpty()) {
                val amount: Double = enteredAmount.toDouble()

                val tip10Percent = amount * 1.10
                val tip15Percent = amount * 1.15
                val tip20Percent = amount * 1.20

                val currencyFormat = NumberFormat.getCurrencyInstance()

                resultText = getString(
                    R.string.result_format,
                    currencyFormat.format(amount),
                    currencyFormat.format(tip10Percent),
                    currencyFormat.format(tip15Percent),
                    currencyFormat.format(tip20Percent)
                )

                resultTextView.text = resultText
            } else {
                resultText = getString(R.string.enter_valid_amount)
                resultTextView.text = resultText
            }
        }

        if (savedInstanceState != null) {
            resultText = savedInstanceState.getString("resultText", "")
            resultTextView.text = resultText
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("resultText", resultText)
    }

    fun buttonClick(view: View) {}


}


