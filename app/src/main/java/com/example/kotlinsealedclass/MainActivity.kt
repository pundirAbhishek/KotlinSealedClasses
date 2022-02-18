package com.example.kotlinsealedclass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProvider(this)[MainViewModel::class.java]

        model.search()

        model.getFact().observe(this, Observer { fact ->
            listSizeTV.text = fact
        })
    }
}