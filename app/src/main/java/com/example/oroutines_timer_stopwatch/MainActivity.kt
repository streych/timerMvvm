package com.example.oroutines_timer_stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oroutines_timer_stopwatch.data.*
import com.example.oroutines_timer_stopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var viewModel: SWViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        CoroutineScope(
            Dispatchers.Main + SupervisorJob()
        ).launch {
            viewModel?.liveData?.observe(this@MainActivity, {
                binding?.textTime?.text = it
            })
        }

        binding?.apply {
            buttonStart.setOnClickListener {
                viewModel?.start()
            }
            buttonPause.setOnClickListener {
                viewModel?.pause()
            }
            buttonStop.setOnClickListener {
                viewModel?.stop()
            }
        }
    }


}