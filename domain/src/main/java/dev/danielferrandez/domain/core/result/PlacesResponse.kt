package dev.danielferrandez.domain.core.result

sealed class PlacesResponse<T> {
    class Success<T>(val value: T) : PlacesResponse<T>()
    class Failure<T>(var exception: Throwable) : PlacesResponse<T>()
}