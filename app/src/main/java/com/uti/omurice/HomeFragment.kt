package com.uti.omurice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.uti.omurice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: BannerAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    private val imageList = listOf(
        R.drawable.asset_page,
        R.drawable.asset_page2,
        R.drawable.asset_page
    )

    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            if (adapter.itemCount == 0) return
            currentPage = (currentPage + 1) % adapter.itemCount
            viewPager.setCurrentItem(currentPage, true)
            handler.postDelayed(this, 3000) // 3 detik
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.bannerViewPager
        adapter = BannerAdapter(imageList)
        viewPager.adapter = adapter

        handler.postDelayed(autoScrollRunnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(autoScrollRunnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(autoScrollRunnable, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
