package com.example.blackcoffer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.blackcoffer.models.PersonModel
import com.example.blackcoffer.R
import com.example.blackcoffer.databinding.ItemViewBusinessPersonBinding
import com.google.android.material.button.MaterialButton

class BusinessPersonAdapter(
    private val context: Context,
    private val onInviteButtonClicked: ((MaterialButton) -> Unit)? = null,

) : RecyclerView.Adapter<BusinessPersonAdapter.BusinessPersonViewHolder>() {
    class BusinessPersonViewHolder(val binding: ItemViewBusinessPersonBinding) :
        ViewHolder(binding.root)

    private var businessPersonList = ArrayList<PersonModel>() // used same as Personal data model
    fun setBusinessPersonList(businessPersonList: ArrayList<PersonModel>) {
        this.businessPersonList = businessPersonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessPersonViewHolder {
        return BusinessPersonViewHolder(
            ItemViewBusinessPersonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BusinessPersonViewHolder, position: Int) {
        val businessPersonData = businessPersonList[position]  // data of a person in a RV
        holder.binding.apply {
            //binding view with the data
            personImage.setImageResource(businessPersonData.personImage)
            personName.text = businessPersonData.personName
            personLocation.text = businessPersonData.personLocation
            progressBar.progress = businessPersonData.progressBar
            tvPersonInterest.text = businessPersonData.personInterest
            tvPersonDescription.text = businessPersonData.personDescription
            //handling click event on invite button
            btnInvite.setOnClickListener {
                if (btnInvite.text != "Pending") onInviteButtonClicked?.let { data -> data(btnInvite) }
                else { Toast.makeText(context, "Inviting is in the pending", Toast.LENGTH_SHORT).show() }
            }
            callCL.setOnClickListener {
                Toast.makeText(context, "Not Implemented", Toast.LENGTH_SHORT).show()
            }
            ivAddContact.setOnClickListener {
                ivAddContact.setImageResource(R.drawable.call_add_shaded_bkg)
            }

        }
        // making recycler view fashionable by using expandable recycler view
        val isExpandable : Boolean = businessPersonData.isExpandable
        holder.binding.apply {
            tvPersonInterest.visibility = if(isExpandable) View.VISIBLE else View.GONE
            tvPersonDescription.visibility = if(isExpandable) View.VISIBLE else View.GONE
            btnInvite.visibility = if(isExpandable) View.VISIBLE else View.GONE
            // showing the data below the details of a person
            constraintLayout.setOnClickListener {
                isAnyItemExpanded(position)
                businessPersonData.isExpandable = !businessPersonData.isExpandable
                notifyItemChanged(position,Unit)
            }
        }

    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = businessPersonList.indexOfFirst { it.isExpandable }
        if (temp>=0 && temp != position){
            businessPersonList[temp].isExpandable = false
            notifyItemChanged(temp,0)
        }
    }

    override fun onBindViewHolder(
        holder: BusinessPersonViewHolder,
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
        return businessPersonList.size
    }


}