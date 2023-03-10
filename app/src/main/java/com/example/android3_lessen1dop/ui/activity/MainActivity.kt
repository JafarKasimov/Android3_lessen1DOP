package com.example.android3_lessen1dop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android3_lessen1dop.R
import com.example.android3_lessen1dop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserves()
        setupListeners()
    }

    private fun setupObserves() {
        viewModel?.number?.observe(this) {
            binding.countTxt.text = it.toString()
        }
    }

    private fun setupListeners() {
        binding.plusBtn.setOnClickListener {
            viewModel?.setPlus()
            if (viewModel?.count == 10 || viewModel?.count == -10) {
                binding.countTxt.setTextColor(resources.getColor(R.color.teal_700))
            } else {
                binding.countTxt.setTextColor(resources.getColor(R.color.white))
            }
            binding.minusBt.setOnClickListener {
                viewModel?.setMinus()
                if (viewModel?.count == 10 || viewModel?.count == -10) {
                    binding.countTxt.setTextColor(resources.getColor(R.color.teal_700))
                } else {
                    binding.countTxt.setTextColor(resources.getColor(R.color.white))
                }
            }
        }

    }
}