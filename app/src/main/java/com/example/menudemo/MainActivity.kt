package com.example.menudemo

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.app_name)
        toolbar.inflateMenu(R.menu.languages)
        toolbar.setOnMenuItemClickListener {
            var locale = Locale("ru")
            if (it.title == "English") {
                locale = Locale("en")
            }
            Locale.setDefault(locale)
            val config = baseContext.resources.configuration
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
            finish()
            startActivity(intent)
            true
        }
    }

}