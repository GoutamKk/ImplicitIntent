package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var secBtn: Button
    private lateinit var editA: EditText
    private lateinit var jump1: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editA = findViewById(R.id.editA)
        findViewById<Button>(R.id.secBtn).setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("data", editA.text.toString())
            startActivity(intent)
            finish()
        }
//        findViewById<Button>(R.id.secBtn).setOnClickListener {
//            val intent = Intent(this,MainActivity::class.java)
//            val input
//            intent.putExtra("Data",input?.text.toString())
//        }
        findViewById<Button>(R.id.jump1).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}