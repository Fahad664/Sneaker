package com.irozon.sneakersample

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.irozon.sneaker.Sneaker
import com.irozon.sneakersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(supportFragmentManager.beginTransaction()) {
            this.add(R.id.fragment, MainFragment())
            this.commit()
        }

        binding.btShowError.setOnClickListener {
            Sneaker.with(this)
                .setTitle("Error!!")
                .setMessage("This is the error message")
                .setTypeface(Typeface.createFromAsset(this.assets, "font/Slabo27px-Regular.ttf"))
                .sneakError()
        }
        binding.btShowSuccess.setOnClickListener {
            val sneaker = Sneaker.with(binding.root)
            val view =
                LayoutInflater.from(this).inflate(R.layout.custom_view, sneaker.getView(), false)
            view.findViewById<TextView>(R.id.tvInstall).setOnClickListener {
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            }
            sneaker.sneakCustom(view)
        }
    }
}