package dev.danielferrandez.data.features.places

import dev.danielferrandez.domain.core.result.PlacesResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import java.lang.Exception
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlacesRepositoryTest {

    private val placesDataSource = mockkClass(PlacesDataSource::class)
    private val placesRepository = PlacesRepository(placesDataSource)

    @Test
    fun `On invoke getPlaces from PlacesRepository should return PlacesResponse Success with a list of Places`() {
        coEvery { placesDataSource.getPlaces() } returns PlacesResponse.Success(value = listOf())
        val result = runBlocking { placesRepository.getPlaces() }
        coVerify { placesDataSource.getPlaces() }
        assert(result is PlacesResponse.Success)
    }

    @Test
    fun `On invoke getPlaces from PlacesRepository should return PlacesResponse Failure with an exception`() {
        coEvery { placesDataSource.getPlaces() } returns PlacesResponse.Failure(exception = Exception())
        val result = runBlocking { placesRepository.getPlaces() }
        coVerify { placesDataSource.getPlaces() }
        assert(result is PlacesResponse.Failure)
    }

}