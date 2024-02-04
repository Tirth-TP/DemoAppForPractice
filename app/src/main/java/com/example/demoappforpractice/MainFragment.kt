package com.example.demoappforpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoappforpractice.adapter.PostAdapter
import com.example.demoappforpractice.databinding.FragmentMainBinding
import com.example.demoappforpractice.model.data.PostsItem
import com.example.demoappforpractice.model.data.PostsList
import com.example.demoappforpractice.viewModel.PostViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPost()

        val postRecycler = binding.rvDashboard
        postRecycler.layoutManager = LinearLayoutManager(requireContext())
        var adapter = PostAdapter(PostsList(), ::onPostClick)

        viewModel.post.observe(viewLifecycleOwner) { posts ->
            posts?.let {
                adapter = PostAdapter(it, ::onPostClick)
                postRecycler.adapter = adapter
            }
        }
        binding.rvDashboard.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
    }

    fun onPostClick(postsItem: PostsItem) {
        val bundle = Bundle()
        bundle.putString("post", Gson().toJson(postsItem))
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}