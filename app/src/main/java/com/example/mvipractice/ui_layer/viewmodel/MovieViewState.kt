package com.example.mvipractice.ui_layer.viewmodel

import com.example.mvipractice.data_layer.domain.Movie

data class MovieViewState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null,
)