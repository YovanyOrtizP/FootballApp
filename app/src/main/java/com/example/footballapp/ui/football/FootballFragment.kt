package com.example.footballapp.ui.football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapp.R
import com.example.footballapp.data.model.Response
import com.example.footballapp.databinding.FragmentFootballBinding
import com.example.footballapp.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FootballFragment : Fragment() {
    private var _binding: FragmentFootballBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FootballViewModel by activityViewModels()

    private val mAdapter by lazy {
        FootballAdapter{
            Toast.makeText(context, "${it.title} selected!", Toast.LENGTH_SHORT).show()
            viewModel.footballObject = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFootballBinding.inflate(inflater,container,false)

        binding.rvFootball.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseType.LOADING -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
                is ResponseType.SUCCESS<List<Response>> -> {
                    initViews(it.response)
                }
                is ResponseType.ERROR -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.flowInformation()

        return binding.root
    }

    private fun initViews(response: List<Response>) {
        response?.let {
            mAdapter.updateFootballAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}