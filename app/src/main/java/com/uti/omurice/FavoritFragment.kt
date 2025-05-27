package com.uti.omurice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        // Tombol filter ditekan -> tampilkan bottom sheet
        binding.btnFilter.setOnClickListener {
            val bottomSheet = FilterBottomSheetFragment()
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
