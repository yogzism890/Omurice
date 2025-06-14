package com.uti.omurice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.omurice.databinding.TampilanUtamaBinding

class TampilanUtama : AppCompatActivity() {

    private lateinit var binding: TampilanUtamaBinding
    private lateinit var bannerRunnable: Runnable
    private val bannerHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan tampilan dengan view binding
        binding = TampilanUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tampilkan HomeFragment saat pertama kali aplikasi dibuka
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // Navigasi tombol bawah
        binding.btnHome.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        binding.btnFav.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnCart.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CartFragment())
                .addToBackStack(null)
                .commit()
        }

        // (Opsional) tombol lainnya bisa ditambahkan di sini
        // binding.btnCart.setOnClickListener { ... }

        // Penyesuaian padding agar tidak bentrok dengan status bar atau navigasi
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Auto-scroll banner (jika kamu mengatur ViewPager untuk banner)
        bannerRunnable = Runnable {
            // logika auto-scroll banner (jika ada)
        }
    }

    override fun onResume() {
        super.onResume()
        bannerHandler.postDelayed(bannerRunnable, 5000) // 5 detik delay
    }

    override fun onPause() {
        super.onPause()
        bannerHandler.removeCallbacks(bannerRunnable)
    }
}

