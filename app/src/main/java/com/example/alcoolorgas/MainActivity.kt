package com.example.alcoolorgas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editInputAlcool: TextInputEditText

    private lateinit var textInputGas: TextInputLayout
    private lateinit var editInputGas: TextInputEditText

    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeInterfaceComponents()

        btnCalculate.setOnClickListener {
            calculateBetterPrice()
        }

    }

    private fun calculateBetterPrice() {
        val alcoolPrice = editInputAlcool.text.toString()
        val gasPrice = editInputGas.text.toString()

        if (validatePriceFields(alcoolPrice, gasPrice)) {
             if (alcoolPrice.toDouble() / gasPrice.toDouble() >= 0.7 ) {
                 textResult.text = Constants.GAS
            } else {
                 textResult.text = Constants.ALCOOL
            }
        }
    }

    private fun validatePriceFields(alcoolPrice: String, gasPrice: String) : Boolean {
        textInputAlcool.error = null
        textInputGas.error = null

        var isValid = true
        if (alcoolPrice.isEmpty()) {
            textInputAlcool.error = Constants.ALCOOL_ERROR
            isValid = false
        } else if (gasPrice.isEmpty()) {
            textInputGas.error = Constants.GAS_ERROR
            isValid = false
        }

        return isValid
    }

    private fun initializeInterfaceComponents() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editInputAlcool = findViewById(R.id.edit_input_alcool)
        textInputGas = findViewById(R.id.text_input_gas)
        editInputGas = findViewById(R.id.edit_input_gas)
        btnCalculate = findViewById(R.id.button_calculate)
        textResult = findViewById(R.id.text_result)
    }
}