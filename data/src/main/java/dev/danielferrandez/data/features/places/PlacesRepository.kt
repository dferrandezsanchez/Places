package dev.danielferrandez.data.features.places

import dev.danielferrandez.domain.core.places.Place
import dev.danielferrandez.domain.core.result.PlacesResponse
import dev.danielferrandez.domain.features.places.useCases.IPlacesRepository

class PlacesRepository(
    private val placesDataSource: PlacesDataSource
) : IPlacesRepository {
    override suspend fun getPlaces(): PlacesResponse<List<Place>> =
        placesDataSource.getPlaces()
}