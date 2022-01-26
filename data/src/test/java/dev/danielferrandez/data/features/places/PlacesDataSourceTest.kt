package dev.danielferrandez.data.features.places

import dev.danielferrandez.data.core.places.PlacesServiceFactory
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlacesDataSourceTest {

    companion object {
        private const val FAKE_DEBUG: Boolean = true
        private const val FAKE_URL: String = "https://gist.githubusercontent.com"
        private const val FAKE_TIMEOUT: Long = 10L
    }

    private val service = PlacesServiceFactory(FAKE_DEBUG, FAKE_URL, FAKE_TIMEOUT)
    private val placesDataSource = PlacesDataSource(service)

    @Test
    fun `On invoke getPlaces should return list of Places`() {
        val result = runBlocking { placesDataSource.getPlaces() }
        assert(result.places.isEmpty().not())
    }

}
