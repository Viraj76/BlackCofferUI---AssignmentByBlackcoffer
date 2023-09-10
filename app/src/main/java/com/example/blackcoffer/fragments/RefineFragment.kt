package com.example.blackcoffer.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.blackcoffer.R
import com.example.blackcoffer.Utils
import com.example.blackcoffer.databinding.FragmentRefineBinding

class RefineFragment : Fragment() {
    private lateinit var binding: FragmentRefineBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRefineBinding.inflate(layoutInflater)
//        val initialText = binding.etStatus.text.toString()       //getting initial test for the counting for characters
//        val adapterAvailability = ArrayAdapter(requireContext(), R.layout.showing_availability, Utils.availabilityList)  //making adapter for showing availability
//
//        binding.apply {
//            availabilityAct.setAdapter(adapterAvailability)
//            tvWordCounter.text = "${initialText.length}/250"  // setting initial characters
//        }
//
//        //counting the characters realtime
//        binding.etStatus.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                val charCount = s?.length ?:0
//                binding.tvWordCounter.text = "$charCount/250"
//            }
//            override fun afterTextChanged(s: Editable?) {}
//        })
//
//        // counting the seek bar value realtime
//        binding.distanceSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                binding.distanceCount.text = progress.toString()
//            }
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
//        })
//
//        managingSelectionOfPurpose()//adding background while clicking on selection purpose
//
//        binding.btnSaveAndExplore.setOnClickListener {
//            Toast.makeText(requireContext(), "Not Implemented", Toast.LENGTH_SHORT).show()
//        }
        return binding.root

    }

    private fun managingSelectionOfPurpose() {
        binding.apply {
            etCoffee.setOnClickListener {
                etCoffee.setBackgroundResource(R.drawable.select_backgound)
                etCoffee.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etDating.setOnClickListener {
                etDating.setBackgroundResource(R.drawable.select_backgound)
                etDating.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etDinning.setOnClickListener {
                etDinning.setBackgroundResource(R.drawable.select_backgound)
                etDinning.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etBussiness.setOnClickListener {
                etBussiness.setBackgroundResource(R.drawable.select_backgound)
                etBussiness.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etHobbies.setOnClickListener {
                etHobbies.setBackgroundResource(R.drawable.select_backgound)
                etHobbies.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etFriend.setOnClickListener {
                etFriend.setBackgroundResource(R.drawable.select_backgound)
                etFriend.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etMatrimony.setOnClickListener {
                etMatrimony.setBackgroundResource(R.drawable.select_backgound)
                etMatrimony.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            etMovies.setOnClickListener {
                etMovies.setBackgroundResource(R.drawable.select_backgound)
                etMovies.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
        }
        }
    }


