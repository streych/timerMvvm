package com.example.oroutines_timer_stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.oroutines_timer_stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewModelProvider(this).get(MainViewModel::class.java).liveData.observe(
            this,
            { dataFromDataBase ->
                binding?.message?.text = dataFromDataBase.data
            }
        )
    }


}