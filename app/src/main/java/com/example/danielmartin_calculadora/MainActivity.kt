package com.example.danielmartin_calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numero1: Int = 0
    private var numero2: Int = 0
    private var operador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{ numeroPresionado("0") }
        btnUno.setOnClickListener{ numeroPresionado("1") }
        btnDos.setOnClickListener{ numeroPresionado("2") }
        btnTres.setOnClickListener{ numeroPresionado("3") }
        btnCuatro.setOnClickListener{ numeroPresionado("4") }
        btnCinco.setOnClickListener{ numeroPresionado("5") }
        btnSeis.setOnClickListener{ numeroPresionado("6") }
        btnSiete.setOnClickListener{ numeroPresionado("7") }
        btnOcho.setOnClickListener{ numeroPresionado("8") }
        btnNueve.setOnClickListener{ numeroPresionado("9") }

        btnSumar.setOnClickListener{ operacion(SUMA) }
        btnRestar.setOnClickListener{ operacion(RESTA) }
        btnMultiplicar.setOnClickListener{ operacion(MULTIPLICACION) }
        btnDividir.setOnClickListener{ operacion(DIVISION) }

        btnClear.setOnClickListener{
            numero1 = 0
            numero2 = 0
            resultadoText.text = "0"
            operador = SIN
        }

        btnIgual.setOnClickListener{
            var resultado = when(operador){
                SUMA -> numero1 + numero2
                RESTA -> numero1 - numero2
                MULTIPLICACION -> numero1 * numero2
                DIVISION -> numero1 / numero2
                else -> 0
            }
            resultadoText.text = resultado.toString()
        }

        val objetoIntent: Intent = intent
        var usuario = objetoIntent.getStringExtra("Usuario")
        resultadoText.text = "Bienvenido $usuario"
    }

    private fun numeroPresionado(digito: String) {
        resultadoText.text = "${resultadoText.text}$digito"

        if (operador == SIN) {
            numero1 = resultadoText.text.toString().toInt()
        } else {
            numero2 = resultadoText.text.toString().toInt()
        }
    }

    private fun operacion(operacion: Int) {
        operador = operacion
        resultadoText.text = "0"
    }

    companion object{
        const val SIN = 0
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Usuario", resultadoText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        resultadoText.setText(savedInstanceState.getString("Usuario"))
    }
}