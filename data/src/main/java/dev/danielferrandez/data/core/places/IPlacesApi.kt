package dev.danielferrandez.data.core.places

import retrofit2.http.GET

interface IPlacesApi {

    companion object {
        private const val PATH_GET_PLACE =
            "/dferrandezsanchez/3a89803c729840e34d52793788f103ad" +
                    "/raw/31804c218a97d55dbb91b12aa05c9e76f7e12db4/places.json"
    }


    @GET(PATH_GET_PLACE)
    suspend fun getPlaces(): PlacesResponseDto

}
