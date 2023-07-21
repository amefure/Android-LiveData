package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm: MyViewModel= ViewModelProvider(this)[MyViewModel::class.java]
        var planeCounter = 0

        val planeText:TextView = findViewById(R.id.plane_text)
        val vmText:TextView = findViewById(R.id.viewmodel_text)

        val button:Button = findViewById(R.id.plus_button)
        button.setOnClickListener {

            planeCounter++
            vm.plus()
            planeText.setText(planeCounter.toString())
        }
        val countObserver = Observer<Int> {it
            vmText.text = it.toString()
        }
        vm.count.observe(this,countObserver)

    }
}