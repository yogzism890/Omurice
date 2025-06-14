package com.uti.omurice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.omurice.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        memanggil fungsi binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        membuat event untuk masuk login activity
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
