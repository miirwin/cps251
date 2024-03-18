package com.example.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationproject.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val action = FirstFragmentDirections.maintoSecond(R.drawable.android_image_1, getString(R.string.image_1)
            )
            findNavController().navigate(action)
        }

        binding.button2.setOnClickListener {
            val action = FirstFragmentDirections.maintoSecond(R.drawable.android_image_2, getString(R.string.image_2)
            )
            findNavController().navigate(action)
        }

        binding.button3.setOnClickListener {
            val action = FirstFragmentDirections.maintoSecond(R.drawable.android_image_3, getString(R.string.image_3)
            )
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
