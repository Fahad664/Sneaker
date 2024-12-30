package com.irozon.sneakersample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irozon.sneaker.Sneaker
import com.irozon.sneakersample.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btShowWarning.setOnClickListener {
            Sneaker.with(this)
                .setTitle("Warning!!")
                .setCornerRadius(5, 5)
                .setMessage("This is the warning message")
                .sneakWarning()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
