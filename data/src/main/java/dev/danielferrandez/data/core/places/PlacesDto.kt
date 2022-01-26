package dev.danielferrandez.data.core.places

import dev.danielferrandez.domain.core.places.Place


data class PlaceDto(
    val id: Long,
    val name: String,
    val desc: String,
    val rate: Long,
    val paymentAccepted: List<String>
)

fun PlaceDto.transform() = Place(
    id = id,
    name = name,
    desc = desc,
    rate = rate,
    paymentAccepted = paymentAccepted,
)
