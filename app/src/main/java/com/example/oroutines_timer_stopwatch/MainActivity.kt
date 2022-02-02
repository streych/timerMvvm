package com.example.oroutines_timer_stopwatch

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.oroutines_timer_stopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getFlow()
        startFlow()
    }

    private fun startFlow() {
        binding?.button?.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                getFlow().collect {
                    Log.d(TAG, it.toString())
                }
            }
        }
    }

    private fun getFlow(): Flow<Int> = flow {
        Log.d(TAG, "Start flow")
        (0..10).forEach {
            delay(500)
            Log.d(TAG, "Emitting $it")
            emit(it) //Выпинываем новое число
        }
    }.map { it * 2 }
        .flowOn(Dispatchers.Default)
}