package dev.danielferrandez.data.core.places

import dev.danielferrandez.domain.core.places.Place
import io.mockk.every
import io.mockk.mockkClass
import org.junit.Test

class PlaceDtoTest {

    companion object {
        internal const val FAKE_ID = 1L
        internal const val FAKE_NAME = "FAKE_NAME"
        internal const val FAKE_DESC = "FAKE_DESC"
        internal const val FAKE_RATE = 1L
        internal val FAKE_PAYMENT = listOf("CARD")
    }

    private val place = mockkClass(Place::class) {
        every { id } returns FAKE_ID
        every { name } returns FAKE_NAME
        every { desc } returns FAKE_DESC
        every { rate } returns FAKE_RATE
        every { paymentAccepted } returns FAKE_PAYMENT
    }

    private val placesDto = PlaceDto(
        FAKE_ID,
        FAKE_NAME,
        FAKE_DESC,
        FAKE_RATE,
        FAKE_PAYMENT
    )

    @Test
    fun `On invoke transform() from PlaceDto should return valid Place`() {
        val result = placesDto.transform()
        with(result) {
            assert(id == place.id)
            assert(name == place.name)
            assert(desc == place.desc)
            assert(rate == place.rate)
            assert(paymentAccepted == place.paymentAccepted)
        }
    }

}