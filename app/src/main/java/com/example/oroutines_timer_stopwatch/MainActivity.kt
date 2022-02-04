package com.example.oroutines_timer_stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.oroutines_timer_stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel: SWViewModel by lazy {
        ViewModelProvider(this).get(SWViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel.liveData.observe(
            this, { dataBase ->
                binding?.textTime?.text = dataBase

            }
        )

        binding?.apply {
            buttonStart.setOnClickListener {
                viewModel.start()
            }
            buttonPause.setOnClickListener {
                viewModel.pause()
            }
            buttonStop.setOnClickListener {
                viewModel.stop()
            }
        }
    }


}