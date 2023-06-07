package com.kotlinspring.irrigation_system.dtos

import com.kotlinspring.irrigation_system.models.TimeSlot

data class PlotDTO(
    var id: Int,
    var timeSlot: TimeSlotDTO,
    var name: String,
    var area:Double,
    var waterRequired: Double,
    var cropType: String
)