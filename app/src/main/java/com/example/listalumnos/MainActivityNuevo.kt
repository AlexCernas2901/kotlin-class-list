package com.example.listalumnos

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import com.example.listalumnos.MainActivity
import com.example.listalumnos.databinding.ActivityMainNuevoBinding

class MainActivityNuevo : AppCompatActivity() {
    private lateinit var binding: ActivityMainNuevoBinding // Mueve la declaración aquí
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click en el botón Guardar
        binding.btnGuardar.setOnClickListener {
            //Pasamos los valores de los editText a variables
            val txtNom = binding.txtNombre.text
            val txtCue = binding.txtCuenta.text
            val txtCorr = binding.txtCorreo.text
            val txtImg = binding.txtImage.text

            val dbalumnos = DBHelperAlumno(this)

            val db = dbalumnos.writableDatabase

            val newReg = ContentValues()
            newReg.put("nombre", txtNom.toString())
            newReg.put("nocuenta", txtCue.toString())
            newReg.put("email", txtCorr.toString())
            newReg.put("imagen", txtImg.toString())

            val res = db.insert("alumnos", null, newReg)
            db.close()

            if (res.toInt() == -1) {
                Toast.makeText(this, "No se inserto el registro", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Registro insertado con éxito", Toast.LENGTH_LONG).show()
                binding.txtNombre.text.clear()
                binding.txtCuenta.text.clear()
                binding.txtCorreo.text.clear()
                binding.txtImage.text.clear()
            }

//            //Creamos el Intent para pasarnos al MainActivity y mandamos por extras los valores
//            val intento2 = Intent(this,MainActivity::class.java)
//            //usamos la etiqueta mensaje para indicar que es nuevo alumno
//            intento2.putExtra("mensaje","nuevo")
//            intento2.putExtra("nombre","${txtNom}")
//            intento2.putExtra("cuenta","${txtCue}")
//            intento2.putExtra("correo","${txtCorr}")
//            intento2.putExtra("image","${txtImg}")
//            startActivity(intento2)

            val intento2 = Intent(this,MainActivity::class.java)
            startActivity(intento2)
        }
    }
}
