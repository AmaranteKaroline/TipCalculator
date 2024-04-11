package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClean.setOnClickListener {
            clean()
        }

        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tietTotal.text
            val numPeopleTemp = binding.tietNumPeople.text
            val percentageTemp = binding.tietPercentage.text

            if (totalTableTemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true
            ) {
                Snackbar
                    .make(binding.tietTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numPeopleTemp.toString().toInt()
                val percentage : Int = percentageTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTip = totalTemp + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalWithTip)
                }
                clean()
                startActivity(intent)
            }

        }
    }
    private fun clean(){
        binding.tietTotal.setText("")
        binding.tietPercentage.setText("")
        binding.tietNumPeople.setText("")

    }
    }


