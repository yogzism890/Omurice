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

        btnApply.setOnClickListener {
            // Tutup BottomSheet
            dismiss()

            // Navigasi ke FragmentFavoritList
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritListFragment()) // ID dari container fragment utama
                .addToBackStack(null)
                .commit()
        }
    }
}
