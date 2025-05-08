package com.uti.omurice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.omurice.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        memanggil fungsi binding
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        membuka fragmen login ketika masuk dari splash
        openfragmentLogin()





        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
//    membuat fungsi membuka fragment login
    fun openfragmentLogin(){
supportFragmentManager.beginTransaction().replace(R.id.frame_layout_login, LoginFragment()).commit()
    }
}