package com.kotlinspring.mappers

import com.kotlinspring.irrigation_system.dtos.PlotDTO
import com.kotlinspring.irrigation_system.models.Plot
import org.mapstruct.Mapper


@Mapper(componentModel = "spring")
interface PlotMapper {
    fun map(plotDTO: PlotDTO) : Plot
    fun map(plot: Plot) : PlotDTO
    fun map(plots: List<Plot>) : List<PlotDTO>
}