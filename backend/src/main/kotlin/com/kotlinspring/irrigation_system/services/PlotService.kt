package com.kotlinspring.irrigation_system.services

import com.kotlinspring.irrigation_system.dtos.PlotDTO
import com.kotlinspring.irrigation_system.mappers.TimeSlotMapper
import com.kotlinspring.irrigation_system.models.Plot
import com.kotlinspring.irrigation_system.models.TimeSlot
import com.kotlinspring.irrigation_system.repositories.PlotRepository
import com.kotlinspring.irrigation_system.repositories.TimeSlotRepository
import com.kotlinspring.mappers.PlotMapper
import jakarta.persistence.EntityNotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*


@Service
//@RequiredArgsConstructor
class PlotService (
    private val plotRepository: PlotRepository,
    private val timeSlotRepository: TimeSlotRepository,
    private val timeSlotMapper: TimeSlotMapper,
    private val plotMapper: PlotMapper
){
    fun addPlot(plotDto : PlotDTO){
        val plot: Plot = plotMapper.map(plotDto)
        plotRepository.save(plot)
    }


    fun updatePlot(plotDto: PlotDTO){
        val plot:Plot = plotRepository.findByName(plotDto.name).orElse(null)
        val updatedPlot:Plot = plotMapper.map(plotDto)
        plot.name = updatedPlot.name
        plot.area = updatedPlot.area
        plot.cropType =updatedPlot.cropType
        plot.waterRequired = updatedPlot.waterRequired

        val timeSlot:TimeSlot = timeSlotRepository.findById(timeSlotMapper.map(plotDto.timeSlot).id).orElse(null)
        plot.timeSlot =timeSlot
        plotRepository.save(plot)
    }


    fun deletePlot(name:String){
        val plot:Plot = plotRepository.findByName(name).orElse(null)
        plotRepository.delete(plot)
    }


    fun findAllPlots() : List<PlotDTO>{
        val plots = plotRepository.findAll()
        return plotMapper.map(plots)

    }


    fun findPlotById(plotId:Int): PlotDTO{
        val plotOfLand: Optional<Plot> = plotRepository.findById(plotId)
        return plotMapper.map(plotOfLand.get())
    }




}

