package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var Btn1: Button
    lateinit var Btn2: Button
    lateinit var Btn3: Button
    lateinit var Btn4: Button

    lateinit var pullback: Button
    lateinit var txtplace: TextView

    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtplace=findViewById<TextView>(R.id.txtplace)
        val getData = intent.getStringExtra("data")
        txtplace.setText(getData)

        Btn1 = this.findViewById<Button>(R.id.Btn1)
        Btn2 = this.findViewById<Button>(R.id.Btn2)
        Btn3 = this.findViewById<Button>(R.id.Btn3)
        Btn4 = this.findViewById<Button>(R.id.Btn4)
        Btn1.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
        Btn2.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:6283586037"))
            startActivity(intent)
        }
        Btn3.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailTo"))
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("goutam14441@gamil.com"))
            startActivity(intent)
        }
        Btn4.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("smsto:666999"))
            intent.putExtra("sms_body","Kya haal hai")
            startActivity(intent)
        }
        findViewById<Button>(R.id.pullback).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}