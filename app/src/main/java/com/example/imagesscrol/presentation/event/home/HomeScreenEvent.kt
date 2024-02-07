package com.example.imagesscrol.presentation.event.home

sealed class HomeScreenEvent {
    data object FetchConnections : HomeScreenEvent()
    data object ResetErrorMessage : HomeScreenEvent()
}