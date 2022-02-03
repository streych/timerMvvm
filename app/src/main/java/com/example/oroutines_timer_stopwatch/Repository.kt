package com.example.oroutines_timer_stopwatch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class Repository(dataSource: DataSource = DataSource(DataBase)) {

    val userData: Flow<Data> =
        dataSource.data.map { data -> Data(data) }
}