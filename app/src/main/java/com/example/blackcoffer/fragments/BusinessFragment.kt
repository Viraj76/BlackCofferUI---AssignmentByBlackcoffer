package com.example.blackcoffer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackcoffer.adapters.BusinessPersonAdapter
import com.example.blackcoffer.models.PersonModel
import com.example.blackcoffer.R
import com.example.blackcoffer.databinding.FragmentBusinessBinding
import com.google.android.material.button.MaterialButton


class BusinessFragment : Fragment() {

    private lateinit var binding: FragmentBusinessBinding
    private lateinit var businessPersonAdapter: BusinessPersonAdapter
    private lateinit var businessPersonList : ArrayList<PersonModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBusinessBinding.inflate(layoutInflater)
//        businessPersonList = arrayListOf()
//
//        prepareRvForBusinessPersonAdapter()
//
//        makingCustomData()
//
//        businessPersonAdapter.setBusinessPersonList(businessPersonList) // providing the data to the recycler view

        return binding.root
    }

    private fun makingCustomData() {
        val person1= PersonModel(R.drawable.person,"Viraj Gupta", "Raipur, With in 5 KM", "", 20,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person2= PersonModel(R.drawable.p1,"Devajit Patar", "Bhilai, With in 5.5 KM", "", 70,"Coffee | Business | Friendship","Hi community! I am open to new connections , skill wise am a android developer")
        val person3= PersonModel(R.drawable.p2,"Heera Ram", "Delhi, With in 50 KM", "", 60,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person4= PersonModel(R.drawable.p3,"Soumya Rayast", "Haryana, With in 100-200M", "", 10,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person5= PersonModel(R.drawable.p4,"Sumit Singh", "Raigarh, With in 23 KM", "", 35,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person6= PersonModel(R.drawable.p5,"Nikhil Painkra", "Mumbai, With in 45 KM", "", 90,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        businessPersonList.add(person1)
        businessPersonList.add(person2)
        businessPersonList.add(person3)
        businessPersonList.add(person4)
        businessPersonList.add(person5)
        businessPersonList.add(person6)
    }

    private fun prepareRvForBusinessPersonAdapter() {
        // passing these function as parameter for handling the click events
        businessPersonAdapter = BusinessPersonAdapter(requireContext(),::onInviteButtonClicked)
        binding.businessPersonsRv.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
            adapter = businessPersonAdapter
        }
    }

    private fun onInviteButtonClicked(button : MaterialButton){
        //asking user if he is sure to send the invitation
        val builder = AlertDialog.Builder(requireContext())
        val alertDialog = builder.create()
        builder.apply {
            setTitle("Inviting")
            setIcon(R.drawable.ic_baseline_arrow_forward_24)
            setMessage("Are you sure you want to invite?")
            setPositiveButton("Yes") { dialogInterface, which ->
                button.apply {
                    text = getString(R.string.pending)
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.lightBlue))
                    isAllCaps = false
                }
                Toast.makeText(requireContext(),"Invited", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("No") { _, _ ->
                alertDialog.dismiss()
            }
            show()
            setCancelable(false)
        }
    }

}