package com.uti.omurice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.uti.omurice.databinding.TampilanUtamaBinding

class TampilanUtama : AppCompatActivity() {

    private lateinit var binding: TampilanUtamaBinding
    private lateinit var bannerRunnable: Runnable
    private val bannerHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = TampilanUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🖼️ Daftar gambar banner
        val imageList = listOf(
            R.drawable.asset_page,
            R.drawable.asset_page,
            R.drawable.asset_page
        )

        // 🔁 Set adapter untuk ViewPager2
        val bannerAdapter = BannerAdapter(imageList)
        binding.bannerViewPager.adapter = bannerAdapter

        // 🔘 Hubungkan ViewPager2 dengan TabLayout untuk dots indicator
        TabLayoutMediator(binding.tabIndicator, binding.bannerViewPager) { _, _ -> }.attach()

        // ⏱️ Auto-scroll banner setiap 5 detik
        bannerRunnable = object : Runnable {
            override fun run() {
                val nextItem = (binding.bannerViewPager.currentItem + 1) % imageList.size
                binding.bannerViewPager.setCurrentItem(nextItem, true)
                bannerHandler.postDelayed(this, 5000)
            }
        }
        bannerHandler.postDelayed(bannerRunnable, 5000)

        // 🛒 Tombol membuka CartFragment
        binding.imageView4.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CartFragment())
                .commit()
        }

        // 📱 Menyesuaikan padding dengan sistem UI
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPause() {
        super.onPause()
        bannerHandler.removeCallbacks(bannerRunnable)
    }

    override fun onResume() {
        super.onResume()
        bannerHandler.postDelayed(bannerRunnable, 5000)
    }
}
