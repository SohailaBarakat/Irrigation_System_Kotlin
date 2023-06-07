package com.kotlinspring.irrigation_system.mappers

import com.kotlinspring.irrigation_system.dtos.PlotDTO
import com.kotlinspring.irrigation_system.dtos.TimeSlotDTO
import com.kotlinspring.irrigation_system.models.Plot
import com.kotlinspring.irrigation_system.models.TimeSlot
import com.kotlinspring.mappers.PlotMapper
import org.springframework.stereotype.Service


@Service
class PlotMapperImpl : PlotMapper {
    override fun map(plotDTO: PlotDTO): Plot {

        return Plot(
            id = plotDTO.id,
            timeSlot = map(plotDTO.timeSlot) ,
            name = plotDTO.name,
            area = plotDTO.area,
            waterRequired = plotDTO.waterRequired,
            cropType = plotDTO.cropType
        )

    }

    override fun map(plot: Plot): PlotDTO {
        return PlotDTO(
            id = plot.id,
            timeSlot = map(plot.timeSlot),
            name = plot.name,
            area = plot.area,
            waterRequired = plot.waterRequired,
            cropType = plot.cropType
        )
    }

    override fun map(plots: List<Plot>): List<PlotDTO> {
        return plots.map {
            plot ->  map(plot)
        }
    }


    private fun map(timeSlot: TimeSlot): TimeSlotDTO {
        return TimeSlotDTO(
            id = timeSlot.id,
            startHour = timeSlot.startHour,
            endHour = timeSlot.endHour,
            isCompleted = timeSlot.isCompleted
        )
    }

    private fun map(timeSlotDTO: TimeSlotDTO): TimeSlot {
        return TimeSlot(
            id = timeSlotDTO.id,
            startHour = timeSlotDTO.startHour,
            endHour = timeSlotDTO.endHour,
            isCompleted = timeSlotDTO.isCompleted

        )
    }
}

