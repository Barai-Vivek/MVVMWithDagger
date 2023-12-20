package com.example.mvvmwithdagger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmwithdagger.databinding.PeopleAdapterItemBinding
import com.example.mvvmwithdagger.model.People


class PeopleAdapter(private val context:Context, private val peopleList:List<People>):RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    private var _binding: PeopleAdapterItemBinding? = null
    private val binding get() = _binding ?: throw IllegalStateException("Binding should not be accessed before onCreateView or after onDestroyView")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        _binding = PeopleAdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people = peopleList[position]
        val dummyImg: String = (people.imageUrl + position) + "/120/120"
        Glide.with(context)
            .asBitmap()
            .load(dummyImg)
            .into(holder.ivPeople)
        "${people.name} ${position+1}".also { holder.tvPeopleName.text = it }
    }

    class ViewHolder(private val binding: PeopleAdapterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivPeople = binding.ivPeople
        val tvPeopleName = binding.tvPeopleName
    }
}