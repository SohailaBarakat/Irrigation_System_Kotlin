package com.kotlinspring.irrigation_system.services

import com.kotlinspring.irrigation_system.dtos.PlotDTO
import com.kotlinspring.irrigation_system.mappers.TimeSlotMapper
import com.kotlinspring.irrigation_system.repositories.PlotRepository
import com.kotlinspring.irrigation_system.repositories.TimeSlotRepository
import com.kotlinspring.mappers.PlotMapper
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalTime


@Component
class IrrigateLandService(
    val plotRepository: PlotRepository,
    val timeSlotRepository: TimeSlotRepository,
    val plotMapper: PlotMapper,
    val timeSlotMapper: TimeSlotMapper
){
    private var retryCount = 0
    private val maxRetries =5



    @Scheduled(cron = "0 0 * * * *") //Run every hour
    fun execute(){
        val plots = plotRepository.findAll()
        val plotDTOs = plotMapper.map(plots)
        for (plot in plotDTOs) {
            val timeSlot = plotRepository.findById(plot.id).get().timeSlot
            val now = LocalTime.now()

            if (now.isAfter(LocalTime.of(timeSlot.startHour, 0)) &&
                now.isBefore(LocalTime.of(timeSlot.endHour, 0)) &&
                !timeSlot.isCompleted
            ) {
                try {
                    // Try to irrigate plot
                    irrigatePlot(plot)

                    // Update slot status
                    timeSlot.isCompleted = true
                    timeSlotRepository.save(timeSlot)
                    retryCount = 0
                } catch (e: Exception) {
                    retryCount++
                    if (retryCount <= maxRetries) {
                        irrigatePlot(plot)
                    } else {
                        // Send alert
                        sendAlert()
                    }
                }
            }
        }
    }

    private fun irrigatePlot(plot: PlotDTO) {
        // It's time to irrigate this plot
        // Send request to sensors
        println("Irrigating plot: ${plot.name}")
    }

    private fun sendAlert() {
        // Send alert that irrigation failed
    }

    @Scheduled(cron = "0 0 0 * * *") // Runs at midnight every day
    fun resetTimeSlots() {
        println("Resetting all time slots to false")
        val timeSlots = timeSlotRepository.findAll()
        val timeSlotDTOs = timeSlotMapper.map(timeSlots)

        // Resetting all time slots to false (not irrigated yet)
        for (timeSlotDTO in timeSlotDTOs) {
            timeSlotDTO.isCompleted = false
            val timeSlot = timeSlotMapper.map(timeSlotDTO)
            timeSlotRepository.save(timeSlot)
        }
    }
}