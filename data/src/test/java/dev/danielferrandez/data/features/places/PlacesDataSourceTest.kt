package dev.danielferrandez.data.features.places

import dev.danielferrandez.data.core.places.PlacesServiceFactory
import dev.danielferrandez.domain.core.result.PlacesResponse
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlacesDataSourceTest {

    companion object {
        private const val FAKE_DEBUG: Boolean = true
        private const val FAKE_URL: String = "https://gist.githubusercontent.com"
        private const val FAKE_WRONG_URL: String = "https://gist.com"
        private const val FAKE_TIMEOUT: Long = 10L
    }

    private val service = PlacesServiceFactory(FAKE_DEBUG, FAKE_URL, FAKE_TIMEOUT)
    private val wrongService = PlacesServiceFactory(FAKE_DEBUG, FAKE_WRONG_URL, FAKE_TIMEOUT)

    @Test
    fun `On invoke getPlaces should return PlacesResponse Success with a list of Places`() {
        val placesDataSource = PlacesDataSource(service)
        val result = runBlocking { placesDataSource.getPlaces() }
        with(result) {
            assert(this is PlacesResponse.Success)
            assert((this as PlacesResponse.Success).value.isEmpty().not())
        }
    }

    @Test
    fun `On invoke getPlaces should return PlacesResponse Failure with an Exception`() {
        val placesDataSource = PlacesDataSource(wrongService)
        val result = runBlocking { placesDataSource.getPlaces() }
        with(result) {
            assert(this is PlacesResponse.Failure)
        }
    }

}
