package com.example.mvvmwithdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithdagger.adapter.PeopleAdapter
import com.example.mvvmwithdagger.component.DaggerAppComponent
import com.example.mvvmwithdagger.databinding.ActivityMainBinding
import com.example.mvvmwithdagger.viewmodel.MyViewModel
import com.example.mvvmwithdagger.model.People
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var peopleAdapter: PeopleAdapter? = null
    private val imageUrl = "https://picsum.photos/id/"

    @Inject
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dagger injection
        DaggerAppComponent.create().inject(this)

        initialization()

        // Use viewModel here
        viewModel.items.observe(this) { _ ->
            binding.progressBar.visibility = View.GONE
            // Update UI with the list of items
            peopleAdapter?.notifyItemInserted(peopleAdapter?.itemCount?:0)
        }

        binding.floatingActionButton.setOnClickListener{
            binding.progressBar.visibility = View.VISIBLE
            val peopleItem = People(imageUrl,
                "User"
            )
            viewModel.insertItem(peopleItem)
            binding.peopleRecyclerView.smoothScrollToPosition(peopleAdapter?.itemCount?:0)
        }


        // initial 1 item example usage
        val peopleItem = People(imageUrl,
            "User"
        )
        viewModel.insertItem(peopleItem)
    }

    private fun initialization(){
        // Initialize the PeopleAdapter when the Activity is created
        val peopleList = viewModel.items.value
        peopleAdapter = peopleList?.let {
            PeopleAdapter(this@MainActivity, it)
        }

        // Now you can use the peopleAdapter as needed
        binding.peopleRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.peopleRecyclerView.adapter = peopleAdapter
    }
}