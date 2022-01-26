package dev.danielferrandez.data.features.places

import dev.danielferrandez.data.core.places.IPlacesApi
import dev.danielferrandez.data.core.places.PlacesServiceFactory
import dev.danielferrandez.data.core.places.transform
import dev.danielferrandez.domain.core.places.Place
import dev.danielferrandez.domain.core.result.PlacesResponse

class PlacesDataSource(
    private val placesServiceFactory: PlacesServiceFactory
) {

    suspend fun getPlaces(): PlacesResponse<List<Place>> {
        return try {
            val places = placesServiceFactory.getPlaceService(IPlacesApi::class.java).getPlaces()
            PlacesResponse.Success(value = places.places.map { it.transform() })
        } catch (e: Exception) {
            PlacesResponse.Failure(exception = e)
        }
    }

}
