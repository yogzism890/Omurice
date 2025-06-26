package com.uti.omurice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uti.omurice.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Tombol Back ke FavoritFragment
        binding.btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritFragment())
                .addToBackStack(null)
                .commit()
        }

        // ✅ Tombol Checkout ke CheckoutFragment
        binding.checkoutButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CheckoutFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // penting agar tidak memory leak
    }
}
