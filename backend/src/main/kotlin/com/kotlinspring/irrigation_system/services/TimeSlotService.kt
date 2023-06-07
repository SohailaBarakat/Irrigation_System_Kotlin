package com.kotlinspring.irrigation_system.services

import com.kotlinspring.irrigation_system.dtos.TimeSlotDTO
import com.kotlinspring.irrigation_system.mappers.TimeSlotMapper
import com.kotlinspring.irrigation_system.models.TimeSlot
import com.kotlinspring.irrigation_system.repositories.TimeSlotRepository
import org.springframework.stereotype.Service


@Service
class TimeSlotService (
     val timeSlotRepository: TimeSlotRepository,
     val timeSlotMapper: TimeSlotMapper
) {
     fun addTimeSlot(timeSlotDTO:TimeSlotDTO) {
        val timeSlot: TimeSlot = timeSlotMapper.map(timeSlotDTO)
        timeSlotRepository.save(timeSlot)

    }
}