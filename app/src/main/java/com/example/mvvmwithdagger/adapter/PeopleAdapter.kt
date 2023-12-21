package com.example.mvvmwithdagger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithdagger.databinding.PeopleAdapterItemBinding
import com.example.mvvmwithdagger.model.People


class PeopleAdapter(private val peopleList:List<People>):RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

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
        holder.bind(peopleList[position])
    }

    inner class ViewHolder(private val binding: PeopleAdapterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(people: People){
            binding.people = people
            binding.executePendingBindings()
        }
    }
}