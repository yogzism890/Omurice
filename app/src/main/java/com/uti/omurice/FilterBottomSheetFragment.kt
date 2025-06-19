package com.uti.omurice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnApply = view.findViewById<Button>(R.id.btnApply)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel) // Tambahkan ini

        btnApply.setOnClickListener {
            // Tutup BottomSheet
            dismiss()

            // Navigasi ke FavoritListFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritListFragment())
                .addToBackStack(null)
                .commit()
        }

        btnCancel.setOnClickListener {
            // Tutup BottomSheet tanpa navigasi
            dismiss()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
