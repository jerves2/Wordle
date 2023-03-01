package com.example.wordle1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wordle1.FourLetterWordList.FourLetterWordList.getRandomFourLetterWord
import com.example.wordle1.R
import java.util.Objects

class MainActivity : AppCompatActivity() {
    lateinit var et_simple: EditText
    lateinit var firstGuessDisplay: TextView
    lateinit var guessButton: Button
    lateinit var textView8: TextView
    lateinit var textView9: TextView
    lateinit var textView10: TextView
    lateinit var textView11: TextView
    lateinit var textView12: TextView
    lateinit var AnswertextView: TextView
    var wordToGuess = getRandomFourLetterWord()
    var counter = 0


    private fun checkGuess(guess: String): String {
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)


        et_simple = findViewById<EditText>(R.id.et_simple)
        firstGuessDisplay = findViewById<TextView>(R.id.firstGuessDisplay)
        guessButton = findViewById<Button>(R.id.guessButton)
        textView8 = findViewById(R.id.textView8)
        textView9 = findViewById(R.id.textView9)
        textView10 = findViewById(R.id.textView10)
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)


        guessButton.setOnClickListener {
            counter++
            firstGuessDisplay.text = et_simple.text.toString()
            textView8.text = checkGuess(firstGuessDisplay.text.toString())
            Toast.makeText(it.context, firstGuessDisplay.text.toString(), Toast.LENGTH_LONG).show()

            if (counter == 1) {
                guessButton.setOnClickListener {
                    counter++
                    textView9.text = et_simple.text.toString()
                    textView10.text = checkGuess(textView9.text.toString())
                    Toast.makeText(it.context, textView9.text.toString(), Toast.LENGTH_LONG).show()

                    if (counter == 2) {
                        guessButton.setOnClickListener {
                            counter++
                            textView11.text = et_simple.text.toString()
                            textView12.text = checkGuess(textView11.text.toString())
                            Toast.makeText(it.context,counter.toString(), Toast.LENGTH_LONG).show()

                            if (counter == 3) {
                                guessButton.setOnClickListener {
                                    counter++
                                    AnswertextView.text = wordToGuess.toString()

                                    }
                            }
                        }


                    }
                }


            }


        }


//

//        guessButton.setOnClickListener {
//
//            textView11.text = et_simple.text.toString()
//            textView12.text = checkGuess(textView11.text.toString())
//            Toast.makeText(it.context, textView11.text.toString(), Toast.LENGTH_LONG).show()
//        }
    }
}
