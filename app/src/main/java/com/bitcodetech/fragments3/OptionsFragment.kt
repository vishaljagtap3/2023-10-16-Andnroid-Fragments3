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


    interface OnOptionSelectedListener {
        fun onOptionSelected(option : String)
    }

    var onOptionSelectedListener : OnOptionSelectedListener? = null


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

    //way 3 final way
    private fun initListeners() {
        txtYes.setOnClickListener {
            if(onOptionSelectedListener != null) {
                onOptionSelectedListener!!.onOptionSelected("Yes")
            }
            removeCurrentFragment()
        }
        txtNo.setOnClickListener {
            onOptionSelectedListener?.onOptionSelected("No")
            removeCurrentFragment()
        }
        txtMayBe.setOnClickListener {
            onOptionSelectedListener?.onOptionSelected("May Be")
            removeCurrentFragment()
        }
    }


    //way 2 - fragment to fragment
    //limitation is, the OptionsFragment only communicates with QuestionFragment
   /* private fun initListeners() {
        txtYes.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.questionFragment) as QuestionFragment).selectedOption = "Yes"
            removeCurrentFragment()
        }
        txtNo.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.questionFragment) as QuestionFragment).selectedOption = "No"
            removeCurrentFragment()
        }
        txtMayBe.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.questionFragment) as QuestionFragment).selectedOption = "May Be"
            removeCurrentFragment()
        }
    }*/

    //way 1 via activity
    /*private fun initListeners() {
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
    }*/

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