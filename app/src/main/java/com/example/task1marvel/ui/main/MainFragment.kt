package com.example.task1marvel.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.task1marvel.databinding.FragmentMainBinding
import com.example.task1marvel.repository.MarvelRepository
import com.example.task1marvel.utils.MarvelViewModelFactory

class MainFragment : Fragment() {
    private val marvelAdapter = MarvelAdapter()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MarvelViewModel

    //Create a companion object to create an instance of the fragment
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = MarvelRepository()
        viewModel = ViewModelProvider(
            this, MarvelViewModelFactory(repository)
        ).get(MarvelViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Init the adapter
        binding.recyclerView.adapter = marvelAdapter

        //Observe the data
        viewModel.getMarvelData().observe(viewLifecycleOwner) { marvelData ->
            // Update the adapter with the new data
            marvelAdapter.setMarvelList(marvelData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
