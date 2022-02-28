package br.fernando.testebottomsheetmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val userName = intent.getStringExtra("data")

        var tvItemUsername = findViewById<TextView>(R.id.tvItemName)

        if(userName != null){
            tvItemUsername.text = userName
        }

    }
}