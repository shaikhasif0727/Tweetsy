package com.example.tweetsy.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.data.models.Tweet
import com.example.tweetsy.data.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweets: StateFlow<List<Tweet>>
        get() = tweetRepository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category").orEmpty()
            tweetRepository.getTweets(category)
        }
    }
}