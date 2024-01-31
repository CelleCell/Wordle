package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        val wordToGuess = FourLetterWordList.getRandomFourLetterWord();
        val Display = findViewById<TextView>(R.id.WordToGet)
        super.onCreate(savedInstanceState)
        Display.setText(wordToGuess)
        val button = findViewById<Button>(R.id.button);
        val currguess = findViewById<EditText>(R.id.simple)

        var i = 1
        button.setOnClickListener {

            if (i == 1) {
                val Guess1 = findViewById<TextView>(R.id.Check8)
                Guess1.text = currguess.text.toString()
                Guess1.visibility = View.VISIBLE
                val Guess1Ans = findViewById<TextView>(R.id.Check7)
                Guess1Ans.text = checkGuess(currguess.text.toString().uppercase(), wordToGuess)
                Guess1Ans.visibility = View.VISIBLE
                i = 2
                if(Guess1Ans.text == "OOOO"){
                    i = 5
                    findViewById<TextView>(R.id.youwin).visibility = View.VISIBLE
                }
            } else if (i == 2) {
                val Guess2 = findViewById<TextView>(R.id.Check5)
                Guess2.text = currguess.text.toString()
                Guess2.visibility = View.VISIBLE
                val Guess2Ans = findViewById<TextView>(R.id.Check6)
                Guess2Ans.text = checkGuess(currguess.text.toString().uppercase(), wordToGuess)
                Guess2Ans.visibility = View.VISIBLE
                i = 3;
                if(Guess2Ans.text == "OOOO"){
                    i = 5
                    findViewById<TextView>(R.id.youwin).visibility = View.VISIBLE
                }
            }else if (i == 3) {
                val Guess3 = findViewById<TextView>(R.id.Check3)
                Guess3.text = currguess.text.toString()
                Guess3.visibility = View.VISIBLE
                val Guess3Ans = findViewById<TextView>(R.id.Check4)
                Guess3Ans.text = checkGuess(currguess.text.toString().uppercase(), wordToGuess)
                Guess3Ans.visibility = View.VISIBLE
                i = 4;
                Display.visibility = View.VISIBLE
                if(Guess3Ans.text == "OOOO"){
                    i = 5
                    findViewById<TextView>(R.id.youwin).visibility = View.VISIBLE
                }
            }
            else {
                Toast.makeText(applicationContext, "No More Attempts Left", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun checkGuess(guess: String, wordToGuess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }

        return result
    }
}
