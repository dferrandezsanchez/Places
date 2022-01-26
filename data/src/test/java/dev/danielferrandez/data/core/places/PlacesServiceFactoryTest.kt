package dev.danielferrandez.data.core.places

import org.junit.Test

class PlacesServiceFactoryTest {

    companion object {
        internal const val FAKE_DEBUG = true
        internal const val FAKE_URL = "https://fake_url"
        internal const val FAKE_TIMEOUT = 10L
    }

    private val placeServiceFactory = PlacesServiceFactory(FAKE_DEBUG, FAKE_URL, FAKE_TIMEOUT)

    @Test
    fun `On invoke getPlaceService should return valid Service`() {
        val result = placeServiceFactory.getPlaceService(IPlacesApi::class.java)
        assert(result is IPlacesApi)
    }

}