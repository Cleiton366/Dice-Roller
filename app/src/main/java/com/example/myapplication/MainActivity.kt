package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Spinner
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting spinner values
        val spinner: Spinner = findViewById(R.id.dices_spinner)
        ArrayAdapter.createFromResource(this, R.array.dice_types,
            android.R.layout.simple_spinner_item
        ).also { adapter -> adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter }

        //roll btn
        val rollBtn: Button = findViewById(R.id.roll_btn)
        rollBtn.setOnClickListener {rollDice()}

    }

    //roll dice function
    private fun rollDice(){
        val diceValue: TextView = findViewById(R.id.dice_value)
        val diceMsg: TextView = findViewById(R.id.dice_msg)
        val dice:Int = getDice()
        val randomInt = (1..dice).random()

        diceMsg.text = "Dice Rolled!"
        diceValue.text = randomInt.toString()
    }

    //get dice value
    private fun getDice():Int{
        val diceTypeSpinner: Spinner = findViewById(R.id.dices_spinner)
        val diceType = diceTypeSpinner.selectedItemPosition
        return getDiceValue(diceType)
    }

    //
    private fun getDiceValue(diceType:Int):Int {
        var diceValue = 2
        when(diceType){
            1 -> diceValue = 4
            2 -> diceValue = 6
            3 -> diceValue = 8
            4 -> diceValue = 10
            5 -> diceValue = 12
            6 -> diceValue = 20
        }
        return diceValue
    }


}

