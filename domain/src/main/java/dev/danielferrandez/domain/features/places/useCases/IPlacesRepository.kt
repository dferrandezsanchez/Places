package dev.danielferrandez.domain.features.places.useCases

import dev.danielferrandez.domain.core.places.Place
import dev.danielferrandez.domain.core.result.PlacesResponse

interface IPlacesRepository {
    suspend fun getPlaces(): PlacesResponse<List<Place>>
}