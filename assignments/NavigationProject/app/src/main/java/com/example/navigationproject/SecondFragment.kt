package com.example.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageId = SecondFragmentArgs.fromBundle(requireArguments()).imageId
        val imageTitle = SecondFragmentArgs.fromBundle(requireArguments()).imageTitle

        binding.imageView.setImageResource(imageId)
        binding.titleTextView.text = imageTitle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



