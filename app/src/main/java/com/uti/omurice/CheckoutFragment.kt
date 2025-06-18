package com.uti.omurice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        logika tombol back
        val btnBack = view.findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CartFragment())
                .addToBackStack(null)
                .commit()
        }
//        Membuka fragment pay jika btnpay di klik
        val btnPay = view.findViewById<Button>(R.id.btnPay)

        btnPay.setOnClickListener {
            val fragmentPayment = PaymentFragment()

            parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentPayment)
                .commit()

        }
    }
}