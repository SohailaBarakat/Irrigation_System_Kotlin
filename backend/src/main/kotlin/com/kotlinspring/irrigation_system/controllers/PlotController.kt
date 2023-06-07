package com.kotlinspring.irrigation_system.controllers

import com.kotlinspring.irrigation_system.dtos.PlotDTO
import com.kotlinspring.irrigation_system.exception.NotFoundException
import com.kotlinspring.irrigation_system.repositories.PlotRepository
import com.kotlinspring.irrigation_system.response.ResponseHandler
import com.kotlinspring.irrigation_system.services.PlotService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/plot")
class PlotController(
    val plotService: PlotService,
    val plotRepository: PlotRepository

) {

    @PostMapping
    fun addPlot(@RequestBody plotDTO: PlotDTO):ResponseEntity<Any>{
        if (plotRepository.existsByName(plotDTO.name)){
            throw NotFoundException("This land is already exist")
        }
        plotService.addPlot(plotDTO)
        return ResponseHandler.generateResponse("Land added successfully!", HttpStatus.valueOf(200),"", true)
    }


    @PutMapping
    fun updatePlot(@RequestBody plotDTO: PlotDTO): ResponseEntity<Any>{
        if (!plotRepository.existsByName(plotDTO.name)){
            throw NotFoundException("Can't find land with the name " + plotDTO.name)
        }
        plotService.updatePlot(plotDTO);
        return ResponseHandler.generateResponse("Land updated successfully!", HttpStatus.valueOf(200),"", true);

    }

    @DeleteMapping("/{name}")
    fun deletePlot(@PathVariable("name") plotName:String): ResponseEntity<Any>{
        if (!plotRepository.existsByName(plotName)){
            throw NotFoundException("Can't find land with the name $plotName");
        }
        plotService.deletePlot(plotName);
        return ResponseHandler.generateResponse("The land has been deleted successfully!", HttpStatus.valueOf(200),"", true);
    }

    @GetMapping
    fun findAllPlots():ResponseEntity<Any>{
        val plotOfLands:List<PlotDTO> = plotService.findAllPlots()
        return ResponseHandler.generateResponse("retrieved data successfully!", HttpStatus.valueOf(200),plotOfLands, true);
    }

    @GetMapping("/{id}")
    fun findPlotById(@PathVariable("id") plotId:Int):ResponseEntity<Any>{
        if (!plotRepository.existsById(plotId)) {
            throw NotFoundException("The land doesn't exist")
        }
        val plotDTO = plotService.findPlotById(plotId)
        return ResponseHandler.generateResponse("Found the land successfully!", HttpStatus.valueOf(200), plotDTO, true)
    }
}