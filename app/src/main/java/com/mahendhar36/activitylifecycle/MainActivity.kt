package com.mahendhar36.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var titleName :String?="Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogout : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),
            MODE_PRIVATE)
        setContentView(R.layout.scrollview_example)

        titleName=sharedPreferences.getString("Title","The Avengers")

        title= titleName

        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            val intent= Intent (this@MainActivity,LoginActivity ::class.java)
            startActivity(intent)
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }


}