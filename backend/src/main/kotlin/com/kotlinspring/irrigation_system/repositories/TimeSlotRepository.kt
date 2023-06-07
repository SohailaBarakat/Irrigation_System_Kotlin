package com.kotlinspring.irrigation_system.repositories

import com.kotlinspring.irrigation_system.models.TimeSlot
import org.springframework.data.jpa.repository.JpaRepository

interface TimeSlotRepository : JpaRepository<TimeSlot,Int> {

}