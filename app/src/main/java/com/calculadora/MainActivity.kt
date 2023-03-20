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
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton = findViewById(R.id.PruebaButton)
        texto = findViewById(R.id.textSalida)

        boton.setOnClickListener{
            texto.setText("Hola")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // return super.onCreateOptionsMenu(menu)
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.salir->{
                exitProcess(0)
                true
            }
            R.id.acercade->{
                var intent = Intent(this, Acercade::class.java)
                startActivity(intent)
                true
            }
            else ->return super.onOptionsItemSelected(item)
        }
    }
}