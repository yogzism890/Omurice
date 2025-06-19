package com.uti.omurice

import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tangani tombol back (fisik) untuk kembali ke FavoritFragment
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // Temukan tombol checkout
        val checkoutButton: Button = view.findViewById(R.id.checkoutButton)

        // Ketika tombol checkout diklik, ganti fragment ke CheckoutFragment
        checkoutButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CheckoutFragment())
                .addToBackStack(null) // agar bisa kembali ke Cart
                .commit()
        }

        return view
    }
}
