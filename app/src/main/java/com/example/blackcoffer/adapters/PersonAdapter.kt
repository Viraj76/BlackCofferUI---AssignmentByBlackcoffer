package com.example.blackcoffer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.blackcoffer.models.PersonModel
import com.example.blackcoffer.databinding.ItemViewPersonsBinding
import com.google.android.material.button.MaterialButton

class PersonAdapter(

    val context : Context,
    private val onInviteButtonClicked : ((MaterialButton) -> Unit)? = null

) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(val binding : ItemViewPersonsBinding) : ViewHolder(binding.root)

    private var personList = ArrayList<PersonModel>()

    fun setPersonList(personList : ArrayList<PersonModel>){
        this.personList = personList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(ItemViewPersonsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val personData = personList[position] // data of a person in a RV
        holder.binding.apply {
            //binding view with the data
            personImage.setImageResource(personData.personImage)
            personName.text = personData.personName
            personLocation.text = personData.personLocation
            personDistance.text = personData.personDistance
            progressBar.progress = personData.progressBar
            tvPersonInterest.text = personData.personInterest
            tvPersonDescription.text = personData.personDescription

            //handling click event on invite button
            btnInvite.setOnClickListener {
                if(btnInvite.text != "Pending")
                      onInviteButtonClicked?.let { data ->data(btnInvite) }
                else{
                    Toast.makeText(context,"Inviting is in the pending", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // making recycler view fashionable by using expandable recycler view
        val isExpandable : Boolean = personData.isExpandable
        holder.binding.apply {
            tvPersonInterest.visibility = if(isExpandable) View.VISIBLE else View.GONE
            tvPersonDescription.visibility = if(isExpandable) View.VISIBLE else View.GONE
            btnInvite.visibility = if(isExpandable) View.VISIBLE else View.GONE
            // showing the data below the details of a person
            constraintLayout.setOnClickListener {
                isAnyItemExpanded(position)
                personData.isExpandable = !personData.isExpandable
                notifyItemChanged(position,Unit)
            }
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = personList.indexOfFirst { it.isExpandable }
        if (temp>=0 && temp != position){
            personList[temp].isExpandable = false
            notifyItemChanged(temp,0)
        }
    }

    override fun onBindViewHolder(
        holder: PersonViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty() && payloads[0] ==0){
            holder.binding.apply {
                tvPersonInterest.visibility = View.GONE
                tvPersonDescription.visibility = View.GONE
                btnInvite.visibility = View.GONE
            }
        }
        else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }


}