package com.example.fisrtkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate
import kotlin.concurrent.timer
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var points = 0
    private var number_clicks = 0
    private val timer_duration: Long = 30*1000 //30 seconds
    private var game_started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // startup code
        val header = findViewById<TextView>(R.id.intro)
        header.text = "How to play: Select the larger number to get points. You have ${timer_duration/1000} seconds!"

        // reset game
        resetGame()

        // start reset timer
        val handler = Handler()
        handler.postDelayed({
            val msg ="Time's up!! Final Result = ${points / number_clicks * 100} % . Keep it up!!"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
            resetGame()
        }, timer_duration)




//        inline fun Timer.schedule(name: "resetGame", period: timer_duration )
//        val handlerGameOver_showResults = Handler(Looper.getMainLooper()){
//            override fun handleMessage(inputMessage: Message){
//                handlerGameOver()
//                Thread.sleep(7 * 1000)
//                resetGame()
//            }
//        }

//
//        Timer("resetGame", true).scheduleAtFixedRate(5*1000, timer_duration) {
//            if (game_started) {
//                game_started = false
////                Looper.prepare()
////                Handler() {
////                    inline fun handleMessage(Message msg) {
////                        val msg =
////                            "Time's up!! Final Result = ${points / number_clicks * 100} % . Keep it up!!"
////                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
////                    }
////                }
////
////                Looper.loop()
//
//                points = 0
//                number_clicks = 0
//            }
//        }
}

    fun resetGame(){
        game_started = false
        points = 0
        number_clicks = 0
        updateButtonText(-99)
    }

    fun handlerGameOver(){
        val txt = findViewById<TextView>(R.id.text_selection)
        val score = findViewById<TextView>(R.id.txt_score)
        txt.text = "Time's up!! Below is your final result. Keep it up!!"
        txt_score.text = "${points/number_clicks*100} %"
    }

    // handle left button click
    fun numButtonClick(view: View){
        // Opt 1: find it Vs use the provided view object that generated the event
//        val but = findViewById<Button>(R.id.left_button)
//        but.text = " ${ getNextRandomNumber() }"

        //Opt 2: using the view that generated the event
        val id = view.id
        if( id == R.id.left_button || id == R.id.right_button ){
            game_started = true
            number_clicks++
            updateButtonText(id)
        }
    }


    fun updateButtonText(selected: Int){

        val txt = findViewById<TextView>(R.id.text_selection)
        val score = findViewById<TextView>(R.id.txt_score)
        val but1 = findViewById<Button>(R.id.left_button)
        val but2 = findViewById<Button>(R.id.right_button )

        if( selected != -99 ) {
            val left = but1.text.toString().trim().toInt()
            val right = but2.text.toString().trim().toInt()

//        txt.text = if( left >= right ) " $left is greater than $right" else " $right is greater than $left"

            var msg: String = ""
            val v = findViewById<Button>(selected).text.toString()

            if (left == right) {
                msg = "$left and $right are the same. Bonus Point!!"
            } else if (left > right) {
                msg = "$left is greater than $right. \nYou selected $v."
            } else {
                msg = "$right is greater than $left. \nYou selected $v."
            }

            var hooray: String = ""
            if ( ((selected == R.id.left_button) and (left >= right) ) or
                ((selected == R.id.right_button) and  (right >= left) )
            ) {
                points++
                hooray = "Awesome! Good Job!!"
            }else{
                hooray = "Ooh no!! Let's try that again."
            }

            txt.text = "$msg \n$hooray"
        }else{
            txt.text = "Are you ready? \nLet's get started!!"
        }

        score.text = "Score: $points"
        but1.text = "${ getNextRandomNumber() }"
        but2.text = "${ getNextRandomNumber() }"
    }

    fun getNextRandomNumber() : Int {
        return Random.nextInt(100)
    }

}
