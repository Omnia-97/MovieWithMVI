package com.example.mvipractice.data_layer.repo

import com.example.mvipractice.data_layer.domain.Movie

import kotlinx.coroutines.delay
import javax.inject.Inject

class RepoImpl @Inject constructor() {
    suspend fun getMovies() : List<Movie>{
        delay(2000)
        return listOf(
            Movie(1, "Alita Battle Angel", "2019"),
            Movie(2, "Mortal Engines", "2018"),
            Movie(3, "Avatar The Way of Water", "2022"),
            Movie(4, "Lost in Space", "2018")
        )
    }
}