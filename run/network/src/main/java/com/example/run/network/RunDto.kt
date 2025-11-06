package com.example.run.network

import kotlinx.serialization.Serializable

/**
 * Data class representing the response from the remote API about a Run.
 * @param id
 * @param dateTimeUtc
 * @param durationMillis
 * @param distanceMeters
 * @param lat
 * @param long
 * @param avgSpeedKmh
 * @param maxSpeedKmh
 * @param totalElevationMeters
 * @param mapPictureUrl
 */
@Serializable
data class RunDto(
    val id: String,
    val dateTimeUtc: String,
    val durationMillis: Long,
    val distanceMeters: Int,
    val lat: Double,
    val long: Double,
    val avgSpeedKmh: Double,
    val maxSpeedKmh: Double,
    val totalElevationMeters: Int,
    val mapPictureUrl: String?
)
