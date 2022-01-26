package dev.danielferrandez.data.core.places


data class PlaceDto (
    val id: Long,
    val name: String,
    val desc: String,
    val rate: Long,
    val paymentAccepted: List<String>
)
