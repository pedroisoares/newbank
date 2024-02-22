package com.example.newbank

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class PixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix)
        setSupportActionBar(findViewById(R.id.tbPix))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnConfirma)
        val edtChave = findViewById<EditText>(R.id.edtChave)
        btConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.edtValorPix)
            var nvalor = valorPix.text.toString().toDouble()
            if(nvalor>nsaldo) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo",txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            finish()
        }
    }
}