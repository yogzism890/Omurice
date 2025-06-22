package com.uti.omurice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uti.omurice.databinding.FragmentLupaPasswordBinding

class LupaPasswordFragment : Fragment() {

    private var _binding: FragmentLupaPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLupaPasswordBinding.inflate(inflater, container, false)
        val view = binding.root

        // Default: Message selected
        binding.radioMsg.setImageResource(R.drawable.ic_radio_checked)
        binding.radioEmail.setImageResource(R.drawable.ic_radio_unchecked)

        // Logika Klik
        binding.optionMessage.setOnClickListener {
            binding.radioMsg.setImageResource(R.drawable.ic_radio_checked)
            binding.radioEmail.setImageResource(R.drawable.ic_radio_unchecked)
        }

        binding.optionEmail.setOnClickListener {
            binding.radioMsg.setImageResource(R.drawable.ic_radio_unchecked)
            binding.radioEmail.setImageResource(R.drawable.ic_radio_checked)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
