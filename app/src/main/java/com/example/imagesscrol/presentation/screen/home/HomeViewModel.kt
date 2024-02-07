package com.example.imagesscrol.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesscrol.data.common.Resource
import com.example.imagesscrol.domain.usecase.GetImageUseCase
import com.example.imagesscrol.presentation.event.home.HomeScreenEvent
import com.example.imagesscrol.presentation.mapper.toPresenter
import com.example.imagesscrol.presentation.state.ImageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase
): ViewModel() {

    private val _imageState = MutableStateFlow(ImageState())
    val imageState: SharedFlow<ImageState> = _imageState.asStateFlow()

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.FetchConnections -> fetchConnections()
            is HomeScreenEvent.ResetErrorMessage -> updateErrorMessage(message = null)
        }
    }

    private fun fetchConnections() {
        viewModelScope.launch {
            getImageUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _imageState.update { state ->
                            state.copy(
                                isLoading = resource.loading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _imageState.update { state ->
                            state.copy(connections = resource.data.map { it.toPresenter() })
                        }
                    }
                    is Resource.Error -> {
                        updateErrorMessage(message = resource.errorMessage)
                    }
                }
            }
        }
    }


    private fun updateErrorMessage(message: String?) {
        _imageState.update { currentState -> currentState.copy(errorMessage = message) }
    }

}