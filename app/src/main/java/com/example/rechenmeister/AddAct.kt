package com.example.rechenmeister

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class AddAct : AppCompatActivity(), View.OnClickListener{

    lateinit var  sharedPreferences: SharedPreferences
    lateinit var inputBetrag : EditText
    lateinit var btnConfirm : Button
    lateinit var btnPerson : ToggleButton
    //lateinit var btnPerson2 : Button
    //lateinit var btnBar : Button
    //lateinit var btnCard : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        inputBetrag = findViewById(R.id.input_hint)
        btnConfirm = findViewById(R.id.btn_confirm)
        btnPerson = findViewById(R.id.btn_person)

        btnConfirm.setOnClickListener {
            val value = inputBetrag.text
            saveValue(value.toString())
            finish() // Zurück zur vorherigen Activity
            Log.v("DEMO","onClickListener aufgerufen mit Wert $value")
        }
        //btnPerson.text = "Nana"

        //btnPerson1 = findViewById(R.id.btn_person1)
        //btnPerson2 = findViewById(R.id.btn_person2)
        //btnBar = findViewById(R.id.btn_bar)

    }

    override fun onClick(v: View?) {


        /*when(v?.id) {
            R.id.btn_confirm -> {
                val value = inputBetrag.text.toString()
                saveValue(value)
                finish()
                Log.v("DEMO","OnClick confirmButton aufgerufen")
            }
            R.id.btn_person -> {

                Log.v("DEMO","OnClick Toggle1 aufgerufen")
            }
        }*/
    }

    private fun saveValue(value: String){
        val editor = sharedPreferences.edit()
        editor.putString("value",value)
        editor.apply()
    }
}