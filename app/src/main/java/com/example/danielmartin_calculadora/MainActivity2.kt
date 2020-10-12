package com.example.danielmartin_calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnLogin.setOnClickListener{
            var usuario: String = txtUser.text.toString()
            val intent: Intent = Intent (this, MainActivity::class.java)
            intent.putExtra("Usuario", usuario)
            startActivity(intent)
        }
    }
}