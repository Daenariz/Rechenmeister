package com.example.rechenmeister

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var savedValue : String
    lateinit var btnAdd : Button
    lateinit var btnStats : Button
    lateinit var btnShare : Button

    lateinit var clause : TextView
    lateinit var resultTv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.v("DEMO", "Main.onCreate wird ausgeführt")

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        savedValue = sharedPreferences.getString("value", "").toString()

        btnAdd = findViewById(R.id.btn_add)
        btnStats = findViewById(R.id.btn_stats)
        btnShare = findViewById(R.id.btn_share)

        clause = findViewById(R.id.clause)
        resultTv = findViewById(R.id.result_tv)

        btnAdd.setOnClickListener(this)
        btnStats.setOnClickListener(this)
        btnShare.setOnClickListener(this)

        //resultTv.text = "Gespeicherter Wert: $savedValue"
        }

    override fun onResume() {

        super.onResume()
        savedValue = sharedPreferences.getString("value", "").toString()
        resultTv.text = "Gespeicherter Wert: $savedValue"

        Log.v("DEMO", "Main.onResume wird ausgeführt")
    }

    override fun onPause() {
        super.onPause()
        Log.v("DEMO", "Main.onPause wird ausgeführt")
    }


    override fun onClick(v: View?) {
        clause.text = "Dankeschön"
        when(v?.id){
            R.id.btn_add ->{
                val intent = Intent(this,AddAct::class.java)
                startActivity(intent)
                Log.v("DEMO","Main.onClick addButton aufgerufen")
            }
            R.id.btn_stats ->{
                //result = b
            }
            R.id.btn_share ->{
                //result = b
            }
        }
    }
}
