package com.kotlinspring.irrigation_system.dtos

data class TimeSlotDTO (
    var id:Int,
    var startHour:Int,
    var endHour:Int,
    var isCompleted: Boolean
)