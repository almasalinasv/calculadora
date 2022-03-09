package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: Char = '0'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonAC.setOnClickListener{
            binding.editTextNumber.text.clear()
        }

        binding.buttonDEL.setOnClickListener{
         binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }

        binding.buttonIgual.setOnClickListener{
            when(operator){
                '+' -> {binding.editTextNumber.setText("${firstValue + binding.editTextNumber.text.toString().toDouble()}")                }
                '-' -> {binding.editTextNumber.setText("${firstValue - binding.editTextNumber.text.toString().toDouble()}")}
                '*' -> {binding.editTextNumber.setText("${firstValue * binding.editTextNumber.text.toString().toDouble()}")}
                '÷' -> {binding.editTextNumber.setText("${firstValue / binding.editTextNumber.text.toString().toDouble()}")}
                 else -> binding.editTextNumber.setText("Error")
            }
        }

        binding.buttonPorcent.setOnClickListener {
            binding.editTextNumber.setText(percentage(operator) )
        }


    }

    fun percentage(operatorToUse: Char): String {
         when(operatorToUse){

            '+' -> {return  "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}" }
            '-' -> {return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}" }
            '0' -> {return "${binding.editTextNumber.text.toString().toDouble()/100}" }
            else -> { return "Error"  }
        }
    }

    fun getOperator(view: View){
        val button = view as Button

        operator = button.text.get(0)
       /* operator = when(button.id){
            binding.buttonDivi.id -> {'÷'}
            binding.buttonMas.id -> {'+'}
            binding.buttonMenos.id -> {'-'}
            binding.buttonMulti.id -> {'*'}
            else ->{'0'}
        }*/
        firstValue = binding.editTextNumber.text.toString().toDouble()
        binding.editTextNumber.text.clear()

    }

    fun numberButtonClicked(view: View){
        val button = view as Button
        //binding.editTextNumber.text.append(button.text)

        /*if(button.id.equals(binding.buttonPunto.id)){
            Toast.makeText(this,"decimal pressed", Toast.LENGTH_SHORT).show()
            if(!binding.editTextNumber.text.contains('.')){
                binding.editTextNumber.text.append((button.text))
            }
            else{
                binding.editTextNumber.text.append((button.text))
            }
        }*/

        when(button.id){
            binding.buttonPunto.id ->{
                if(!binding.editTextNumber.text.contains('.')){
                    binding.editTextNumber.text.append('.')
                }
            }
            binding.button.id -> {binding.editTextNumber.text.append('0')}
            binding.button1.id -> {binding.editTextNumber.text.append('1')}
            binding.button2.id -> {binding.editTextNumber.text.append('2')}
            binding.button3.id -> {binding.editTextNumber.text.append('3')}
            binding.button4.id -> {binding.editTextNumber.text.append('4')}
            binding.button5.id -> {binding.editTextNumber.text.append('5')}
            binding.button6.id -> {binding.editTextNumber.text.append('6')}
            binding.button7.id -> {binding.editTextNumber.text.append('7')}
            binding.button8.id -> {binding.editTextNumber.text.append('8')}
            binding.button9.id -> {binding.editTextNumber.text.append('9')}
        else ->{
           Toast.makeText(this,"else",Toast.LENGTH_SHORT).show()
        }
        }
    }

}