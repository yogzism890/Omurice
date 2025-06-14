package com.uti.omurice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.omurice.databinding.ActivityLoginBinding
import com.uti.omurice.databinding.TampilanUtamaBinding
import com.uti.omurice.CartFragment


class TampilanUtama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        memanggil fungsi binding
        val binding = TampilanUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        membuka cart_fragment
        binding.btnCart.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CartFragment())
                .commit()
        }







        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}