package dev.danielferrandez.domain.core.places

data class Place(
    val id: Long,
    val name: String,
    val desc: String,
    val rate: Long,
    val paymentAccepted: List<String>
)
