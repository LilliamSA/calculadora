package com.calculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Exception
import kotlin.system.exitProcess
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    //lateinit var boton: Button
    lateinit var texto: TextView
    lateinit var button_1: Button
    lateinit var button_2: Button
    lateinit var button_3: Button
    lateinit var button_4: Button
    lateinit var button_5: Button
    lateinit var button_6: Button
    lateinit var button_7: Button
    lateinit var button_8: Button
    lateinit var button_9: Button
    lateinit var button_0: Button
    lateinit var button_punto: Button
    lateinit var button_suma: Button
    lateinit var button_resta: Button
    lateinit var button_multiplicacion: Button
    lateinit var button_division: Button
    lateinit var button_igual: Button
    lateinit var button_borrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.textSalida)
        button_1 =findViewById(R.id.button_1)
        button_2 =findViewById(R.id.button_2)
        button_3 =findViewById(R.id.button_3)
        button_4 =findViewById(R.id.button_4)
        button_5 =findViewById(R.id.button_5)
        button_6 =findViewById(R.id.button_6)
        button_7 =findViewById(R.id.button_7)
        button_8 =findViewById(R.id.button_8)
        button_9 =findViewById(R.id.button_9)
        button_0 =findViewById(R.id.button_0)
        button_punto =findViewById(R.id.button_punto)
        button_suma =findViewById(R.id.button_suma)
        button_resta =findViewById(R.id.button_resta)
        button_multiplicacion =findViewById(R.id.button_multiplicacion)
        button_division =findViewById(R.id.button_division)
        button_igual =findViewById(R.id.button_igual)
        button_borrar =findViewById(R.id.button_borrar)


        // Asigna a cada botón un escuchador de clics que llamará al método correspondiente de la clase
        button_0.setOnClickListener { presionarDigito(it) }
        button_1.setOnClickListener { presionarDigito(it) }
        button_2.setOnClickListener { presionarDigito(it) }
        button_3.setOnClickListener { presionarDigito(it) }
        button_4.setOnClickListener { presionarDigito(it) }
        button_5.setOnClickListener { presionarDigito(it) }
        button_6.setOnClickListener { presionarDigito(it) }
        button_7.setOnClickListener { presionarDigito(it) }
        button_8.setOnClickListener { presionarDigito(it) }
        button_9.setOnClickListener { presionarDigito(it) }
        button_punto.setOnClickListener { presionarDigito(it) }

        button_suma.setOnClickListener { presionarOperacion(it) }
        button_resta.setOnClickListener { presionarOperacion(it) }
        button_multiplicacion.setOnClickListener { presionarOperacion(it) }
        button_division.setOnClickListener { presionarOperacion(it) }

        button_igual.setOnClickListener { calcular(it) }
        button_borrar.setOnClickListener { reset(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // return super.onCreateOptionsMenu(menu)
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.salir -> {
                exitProcess(0)
                true
            }
            R.id.calculadoraAvanzada -> {
                var intent = Intent(this, CalculadoraAvanzada::class.java)
                startActivity(intent)
                true
            }
            R.id.acercade -> {
                var intent = Intent(this, Acercade::class.java)
                startActivity(intent)
                true
        }
            else ->return super.onOptionsItemSelected(item)
        }
    }
    fun presionarDigito(view: View) {
        val boton = view as Button
        val textoBoton = boton.text.toString()
        val concatenar = texto.text.toString() + textoBoton
        val concatenarSinCeros = quitarCerosIzquierda(concatenar)
        texto.text = concatenarSinCeros
    }
    fun presionarOperacion(view: View) {
        val boton = view as Button
        val textoBoton = boton.text.toString()
        val concatenar = texto.text.toString() + textoBoton
        val concatenarSinCeros = quitarCerosIzquierda(concatenar)
        texto.text = concatenarSinCeros
    }
    fun calcular(view: View) {
        val texto1 = texto.text.toString()
        val expr = Expression(texto1)
        try {
            val resultado = expr.calculate()
            texto.text = resultado.toString()
        } catch (e: Exception) {
            texto.text = e.toString()
        }
    }
    fun quitarCerosIzquierda(str: String): String {
        var i = 0
        while (i < str.length && str[i] == '0') {
            i++
        }
        return str.substring(i)
    }
    fun reset(view: View) {
        texto?.text = "0" // se actualiza el texto del TextView con el valor "0"
    }
}