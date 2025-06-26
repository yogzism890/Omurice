package com.uti.omurice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.uti.omurice.databinding.FragmentFavoritBinding

class FavoritFragment : Fragment() {

    private var _binding: FragmentFavoritBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol filter untuk membuka BottomSheet
        binding.btnFilter.setOnClickListener {
            val filterSheet = FilterBottomSheetFragment()
            filterSheet.show(parentFragmentManager, filterSheet.tag)
        }

        // Tombol back untuk kembali ke HomeFragment
        binding.btnBackRcvrPw.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
