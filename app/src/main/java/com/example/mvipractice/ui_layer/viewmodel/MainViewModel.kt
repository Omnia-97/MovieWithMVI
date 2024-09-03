package com.example.mvipractice.ui_layer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvipractice.data_layer.repo.RepoImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repoImpl: RepoImpl
) : ViewModel() {
    private val _state = MutableStateFlow(MovieViewState())
    val state: StateFlow<MovieViewState> = _state

    fun handleIntent(intent: MovieIntent) {
        viewModelScope.launch {
            when (intent) {
                is MovieIntent.LoadsMovies -> fetchMovies()
            }
        }
    }

    private suspend fun fetchMovies() {
        _state.value = _state.value.copy(loading = true, error = null)
        try {
            val movies = repoImpl.getMovies()
            _state.value = MovieViewState(loading = false, movies = movies)
        } catch (e: Exception) {
            _state.value = _state.value.copy(
                loading = false,
                error = e.message ?: "Error fetching movies"
            )
            e.printStackTrace() // Add this to see the exact exception in the logcat
        }
    }

}