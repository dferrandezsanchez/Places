package dev.danielferrandez.domain.features.places

import dev.danielferrandez.domain.core.result.PlacesResponse
import dev.danielferrandez.domain.features.places.useCases.GetPlacesUseCase
import dev.danielferrandez.domain.features.places.useCases.IPlacesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import java.lang.Exception
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetPlacesUseCaseTest {

    private val repository = mockkClass(IPlacesRepository::class)
    private val getPlacesUseCase = GetPlacesUseCase(repository)

    @Test
    fun `On invoke should return PlacesReponse Success with list of Places`() {
        coEvery { repository.getPlaces() } returns PlacesResponse.Success(value = listOf())
        val result = runBlocking { getPlacesUseCase.invoke() }
        coVerify { repository.getPlaces() }
        with(result) {
            assert(this is PlacesResponse.Success)
        }
    }

    @Test
    fun `On invoke should return PlacesReponse Failure with exception`() {
        coEvery { repository.getPlaces() } returns PlacesResponse.Failure(exception = Exception())
        val result = runBlocking { getPlacesUseCase.invoke() }
        coVerify { repository.getPlaces() }
        with(result) {
            assert(this is PlacesResponse.Failure)
        }
    }
}