package com.kotlinspring.irrigation_system.controllers


import com.kotlinspring.irrigation_system.dtos.*
import com.kotlinspring.irrigation_system.exception.NotFoundException
import com.kotlinspring.irrigation_system.response.ResponseHandler
import com.kotlinspring.irrigation_system.services.TimeSlotService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/irrigation")
class TimeSlotController(
    private val timeSlotService: TimeSlotService
) {

    @PostMapping
    fun addTimeSlot(@RequestBody timeSlotDTO: TimeSlotDTO):ResponseEntity<Any>{
        if(timeSlotDTO.startHour<0 || timeSlotDTO.endHour>23){
            throw NotFoundException("Please enter a valid time")
        }
        timeSlotService.addTimeSlot(timeSlotDTO)
        return ResponseHandler.generateResponse("Time slot added successfully!", HttpStatus.valueOf(200),"", true)
    }





}