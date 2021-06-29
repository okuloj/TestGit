package com.example.testgit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonTeam1Down: Button
    private lateinit var buttonTeam1Up: Button
    private lateinit var buttonTeam2Down: Button
    private lateinit var buttonTeam2Up: Button

    private lateinit var txtScoreTeam1: TextView
    private lateinit var txtScoreTeam2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AnhXa()

        buttonTeam1Down.setOnClickListener(this)
        buttonTeam1Up.setOnClickListener(this)
        buttonTeam2Down.setOnClickListener(this)
        buttonTeam2Up.setOnClickListener(this)

    }

    private fun AnhXa() {
        buttonTeam1Down = findViewById(R.id.button_team1_down)
        buttonTeam1Up = findViewById(R.id.button_team1_up)
        buttonTeam2Down = findViewById(R.id.button_team2_down)
        buttonTeam2Up = findViewById(R.id.button_team2_up)

        txtScoreTeam1 = findViewById(R.id.edt_score_team1)
        txtScoreTeam2 = findViewById(R.id.edt_score_team2)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.button_team1_up -> XuLy(txtScoreTeam1, "up")
                R.id.button_team1_down -> XuLy(txtScoreTeam1, "down")
                R.id.button_team2_up -> XuLy(txtScoreTeam2, "up")
                R.id.button_team2_down -> XuLy(txtScoreTeam2, "down")
            }
        }
    }
    private fun XuLy(textView: TextView, string: String) {
        var score: Int? = textView.text.toString().toInt()
        if (score != null) {
            if(string == "up") {
                score++
            } else if(string == "down") {
                score--
            }
        }
        val newScoreText: String = score.toString()
        textView.text = newScoreText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.contrast -> {
                if (AppCompatDelegate.getDefaultNightMode().toString() == "-1" || AppCompatDelegate.getDefaultNightMode().toString() == "1") {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    delegate.applyDayNight()
                }
                else if (AppCompatDelegate.getDefaultNightMode().toString() == "2") {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    Toast.makeText(this, AppCompatDelegate.getDefaultNightMode().toString(),Toast.LENGTH_LONG).show()
                }


            }
        }
        return super.onOptionsItemSelected(item)
    }
}

