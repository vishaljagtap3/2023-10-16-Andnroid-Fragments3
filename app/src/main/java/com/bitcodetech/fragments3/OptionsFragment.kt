package com.bitcodetech.fragments3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class OptionsFragment : Fragment() {

    private lateinit var txtYes : TextView
    private lateinit var txtNo : TextView
    private lateinit var txtMayBe : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.options_fragment, null)

        initViews(view)
        initListeners()

        return view
    }

    private fun initListeners() {
        txtYes.setOnClickListener {
            (requireActivity() as MainActivity).setSelectedOption("Yes")
            removeCurrentFragment()
        }
        txtNo.setOnClickListener {
            (requireActivity() as MainActivity).setSelectedOption("No")
            removeCurrentFragment()
        }
        txtMayBe.setOnClickListener {
            (requireActivity() as MainActivity).setSelectedOption("May Be")
            removeCurrentFragment()
        }
    }

    private fun removeCurrentFragment() {
        parentFragmentManager.beginTransaction()
            .remove(this)
            .commit()
    }

    private fun initViews(view : View) {
        txtYes = view.findViewById(R.id.txtYes)
        txtNo = view.findViewById(R.id.txtNo)
        txtMayBe = view.findViewById(R.id.txtMayBe)
    }
}