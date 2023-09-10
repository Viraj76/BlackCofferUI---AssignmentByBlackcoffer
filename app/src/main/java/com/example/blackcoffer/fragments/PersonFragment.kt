package com.example.blackcoffer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackcoffer.adapters.PersonAdapter
import com.example.blackcoffer.models.PersonModel
import com.example.blackcoffer.R
import com.example.blackcoffer.databinding.FragmentPersonBinding
import com.google.android.material.button.MaterialButton


class PersonFragment : Fragment() {

    private lateinit var binding: FragmentPersonBinding
    private lateinit var personAdapter: PersonAdapter
    private lateinit var personList : ArrayList<PersonModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonBinding.inflate(layoutInflater)

//        personList = arrayListOf() // initializing the arrayList
//
//        prepareRvForPersonAdapter()
//
//        makingCustomData()
//
//        personAdapter.setPersonList(personList) // providing data to the recycler view
        return binding.root
    }

    private fun makingCustomData() {
        val person1= PersonModel(R.drawable.person,"Viraj Gupta", "Raipur | Student", "With in 5 KM", 20,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person2= PersonModel(R.drawable.p1,"Devajit Patar", "Bhilai | Student", "With in 5.5 KM", 70,"Coffee | Business | Friendship","Hi community! I am open to new connections , skill wise am a android developer")
        val person3= PersonModel(R.drawable.p2,"Heera Ram", "Delhi | Student", "With in 50 KM", 60,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person4= PersonModel(R.drawable.p3,"Soumya Rayast", "Haryana | Student", "With in 100-200M", 10,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person5= PersonModel(R.drawable.p4,"Sumit Singh", "Raigarh | Student", "With in 23 KM", 35,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        val person6= PersonModel(R.drawable.p5,"Nikhil Painkra", "Mumbai | Student", "With in 45 KM", 90,"Coffee | Business | Friendship","Hi community! I am open to new connections")
        personList.add(person1)
        personList.add(person2)
        personList.add(person3)
        personList.add(person4)
        personList.add(person5)
        personList.add(person6)    }

    private fun prepareRvForPersonAdapter() {
        personAdapter = PersonAdapter(requireContext(),::onInviteButtonClicked)
        binding.personsRv.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
            adapter = personAdapter
        }
    }

    private fun onInviteButtonClicked( btn : MaterialButton){
        //asking user if he really wants to send invitation
        val builder = AlertDialog.Builder(requireContext())
        val alertDialog = builder.create()
        builder.apply {
            setTitle("Inviting")
            setIcon(R.drawable.ic_baseline_arrow_forward_24)
            setMessage("Are you sure you want to invite?")
            setPositiveButton("Yes") { dialogInterface, which ->
                btn.apply {
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