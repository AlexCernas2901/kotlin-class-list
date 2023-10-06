package com.example.listalumnos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listalumnos.MainActivity
import com.example.listalumnos.databinding.ActivityMainNuevoBinding

class MainActivityNuevo : AppCompatActivity() {
    private lateinit var binding: ActivityMainNuevoBinding // Mueve la declaración aquí
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //En el onCreate
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click en el botón Guardar
        binding.btnGuardar.setOnClickListener {
            //Pasamos los valores de los editText a variables
            val txtNom = binding.txtNombre.text
            val txtCue = binding.txtCuenta.text
            val txtCorr = binding.txtCorreo.text
            val txtImg = binding.txtImage.text

            //Creamos el Intent para pasarnos al MainActivity y mandamos por extras los valores
            val intento2 = Intent(this,MainActivity::class.java)
            //usamos la etiqueta mensaje para indicar que es nuevo alumno
            intento2.putExtra("mensaje","nuevo")
            intento2.putExtra("nombre","${txtNom}")
            intento2.putExtra("cuenta","${txtCue}")
            intento2.putExtra("correo","${txtCorr}")
            intento2.putExtra("image","${txtImg}")
            startActivity(intento2)
        }
    }
}
