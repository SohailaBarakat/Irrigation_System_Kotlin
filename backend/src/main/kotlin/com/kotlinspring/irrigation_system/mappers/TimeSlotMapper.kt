package com.kotlinspring.irrigation_system.mappers

import com.kotlinspring.irrigation_system.dtos.TimeSlotDTO
import com.kotlinspring.irrigation_system.models.TimeSlot
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.springframework.stereotype.Component


@Component
@Mapper(componentModel = "spring" ,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
interface TimeSlotMapper {
    fun map(timeSlot: TimeSlot): TimeSlotDTO
    fun map(timeSlotDTO :TimeSlotDTO) : TimeSlot
    fun map(timeSlots : List<TimeSlot>): List<TimeSlotDTO>
}