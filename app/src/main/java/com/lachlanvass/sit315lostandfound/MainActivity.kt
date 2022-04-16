package com.lachlanvass.sit315lostandfound

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createLostAndFoundButton = findViewById<Button>(R.id.create_advert_button)
        val showAllButton = findViewById<Button>(R.id.show_all_button)

        val buttonIntentMap = mapOf<Button, Intent>(

            createLostAndFoundButton to Intent(this, CreateLostAndFoundActivity::class.java),
            showAllButton to Intent(this, ListLostAndFoundActivity::class.java)
        )

        buttonIntentMap.entries.forEach {(button, intent) ->

            button.setOnClickListener {
                startActivity(intent)
            }
        }

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Post"
        ).build()
    }
}