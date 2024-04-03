package com.example.tipcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.rbOpitionOne.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 10
            }
        }

       binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
           if(isChecked){
               percentage = 15
           }
       }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 20
            }
        }


        binding.btnClean.setOnClickListener{
            binding.tvResult.text = ""
            binding.tietTotal.setText("")
            binding.tietNumPeople.setText("")
            binding.rbOpitionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
            binding.rbOptionThree.isChecked = false
        }

        binding.btnDone.setOnClickListener{
            val totalTable: Float = binding.tietTotal.text.toString().toFloat()
            val nPeople: Int = binding.tietNumPeople.text.toString().toInt()

            val totalTemp = totalTable / nPeople
            val tips = totalTemp * percentage / 100
            val totalWithTip = totalTemp + tips
            binding.tvResult.text = "Valor por pessoa: $totalWithTip"

        }

        }
    }
