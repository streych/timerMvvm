package com.example.oroutines_timer_stopwatch.data

class StopwatchStateHolder(
    private val stopwatchStateCalculator: StopwatchStateCalculator,
    private val elapsedTimeCalculator: ElapsedTimeCalculator,
    private val timestampMillisecondsFormatter: TimestampMillisecondsFormatter
) {
    var currentState: StopwatchState = StopwatchState.Paused(0)
        private set

    fun start() {
        currentState = stopwatchStateCalculator.calculateRunningState(currentState)
    }

    fun pause() {
        currentState = stopwatchStateCalculator.calculatePausedState(currentState)
    }

    fun stop() {
        currentState = StopwatchState.Paused(0)
    }

    fun getStringTimeRepresentation(): String {
        val elapsedTime = when (val currState = currentState) {
            is StopwatchState.Paused -> currState.elapsedTime
            is StopwatchState.Running -> elapsedTimeCalculator.calculate(currState)
        }
        return timestampMillisecondsFormatter.format(elapsedTime)
    }

}