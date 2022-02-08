package com.example.stringemojifier

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.stringemojifier.databinding.FragmentWellcomeBinding

class WellcomeFragment : Fragment() {
    lateinit var binding: FragmentWellcomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentWellcomeBinding.inflate(layoutInflater)
        binding.oopsText.visibility = View.GONE
        binding.yesButton.setOnClickListener { v: View ->
            Toast.makeText(context, "let's emojify String!!!", Toast.LENGTH_SHORT).show()
            v.findNavController().navigate(R.id.action_wellcomeFragment_to_convertToEmoji)
        }
        binding.noButton.setOnClickListener{
            displayOops()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun displayOops() {
        binding.apply {
          yesButton.visibility = View.GONE
          noButton.visibility = View.GONE
          oopsText.visibility = View.VISIBLE

      }
    }
}