package dev.danielferrandez.data.features.places

import dev.danielferrandez.data.core.places.IPlacesApi
import dev.danielferrandez.data.core.places.PlacesServiceFactory

class PlacesDataSource(
    private val placesServiceFactory: PlacesServiceFactory
) {

    suspend fun getPlaces() =
        placesServiceFactory.getFacePhiService(IPlacesApi::class.java).getPlaces()

}
