package dev.hossam.cryptocurrency.core

interface UiEvent {

    data class SnackBar(val message: String) : UiEvent
}