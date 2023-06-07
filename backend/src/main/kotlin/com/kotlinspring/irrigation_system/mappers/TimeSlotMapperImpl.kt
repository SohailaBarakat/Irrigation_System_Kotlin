package com.kotlinspring.irrigation_system.mappers


import com.kotlinspring.irrigation_system.dtos.TimeSlotDTO
import com.kotlinspring.irrigation_system.models.TimeSlot
import org.springframework.stereotype.Service


@Service
class TimeSlotMapperImpl : TimeSlotMapper {
    override fun map(timeSlot: TimeSlot): TimeSlotDTO {
        return TimeSlotDTO(
            id = timeSlot.id,
            startHour = timeSlot.startHour,
            endHour = timeSlot.endHour,
            isCompleted = timeSlot.isCompleted
        )
    }

    override fun map(timeSlotDTO: TimeSlotDTO): TimeSlot {
        return TimeSlot(
            id = timeSlotDTO.id,
            startHour = timeSlotDTO.startHour,
            endHour = timeSlotDTO.endHour,
            isCompleted = timeSlotDTO.isCompleted

        )
    }

    override fun map(timeSlots: List<TimeSlot>): List<TimeSlotDTO> {
        return timeSlots.map {
            timeSlot ->  map(timeSlot)
        }
    }

}