package com.marg98.tarea2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var total=0.0

    //Tamaños-Precios
    val small=5.0
    val medium=7.0
    val large=9.0

    //Precio Extras
    val onions=1.0
    val olives = 2.0
    val tomatoes=3.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RadioGroup
        var radioGroup= findViewById<RadioGroup>(R.id.radioGroup)

        //Total
        var montoTotal = findViewById<TextView>(R.id.txtTotal)

        // Check
        var chkOnions= findViewById<CheckBox>(R.id.chkOnions)
        var chkOlives= findViewById<CheckBox>(R.id.chkOlives)
        var chkTomatoes= findViewById<CheckBox>(R.id.chkTomatoes)
        // Boton Orden
        var btnOrden=findViewById<Button>(R.id.btnOrden)

        //Listener para los cambios en el RadioGroup
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbtnSmall -> total = small
                R.id.rbtnMedium -> total = medium
                R.id.rbtnLarge -> total = large
            }
        }

        //Listener para los cambios en cada CheckBox
        chkOnions.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += onions
            } else {
                total -= onions // Restara el precio si el CheckBox se desmarca
            }

        }
        chkOlives.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += olives
            } else {
                total -= olives
            }

        }
        chkTomatoes.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                total += tomatoes
            } else {
                total -= tomatoes
            }

        }

        btnOrden.setOnClickListener(){
            montoTotal.text="$"+total.toString()
        }

    }
}