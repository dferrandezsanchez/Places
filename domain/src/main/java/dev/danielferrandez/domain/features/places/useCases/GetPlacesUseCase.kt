package dev.danielferrandez.domain.features.places.useCases

import dev.danielferrandez.domain.core.places.Place
import dev.danielferrandez.domain.core.result.PlacesResponse

class GetPlacesUseCase(
    private val placesRepository: IPlacesRepository
) {
    suspend operator fun invoke(): PlacesResponse<List<Place>> =
        placesRepository.getPlaces()
}