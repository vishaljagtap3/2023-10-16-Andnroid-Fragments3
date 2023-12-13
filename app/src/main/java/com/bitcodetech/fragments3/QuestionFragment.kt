package com.bitcodetech.fragments3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class QuestionFragment : Fragment() {

    private lateinit var txtQuestion : TextView
    private lateinit var txtAnswer : TextView
    private lateinit var btnShowOptions : Button

    var selectedOption = ""
        set(value) {
            field = value
            txtAnswer.text = value
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.question_fragment, null)

        initViews(view)
        initListeners()

        return view
    }

    private fun initListeners() {
        btnShowOptions.setOnClickListener {

            val optionsFragment = OptionsFragment()
            optionsFragment.onOptionSelectedListener = MyOnOptionSelectedListener()


            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, optionsFragment, null)
                .addToBackStack("AddOptionsFragment")
                .commit()

            /*requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, optionsFragment, null)
                .commit()*/
        }
    }

    private inner class MyOnOptionSelectedListener : OptionsFragment.OnOptionSelectedListener {
        override fun onOptionSelected(option: String) {
            selectedOption = option
        }
    }

    private fun initViews(view : View) {
        txtQuestion = view.findViewById(R.id.txtQuestion)
        txtAnswer = view.findViewById(R.id.txtAnswer)
        btnShowOptions = view.findViewById(R.id.btnShowOptions)
    }

}