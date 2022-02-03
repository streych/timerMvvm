package com.example.oroutines_timer_stopwatch.data

interface TimestampProvider {
    fun getMilliseconds(): Long
}