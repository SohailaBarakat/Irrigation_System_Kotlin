package com.kotlinspring.irrigation_system.repositories

import com.kotlinspring.irrigation_system.models.Plot
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface PlotRepository : JpaRepository<Plot,Int>{
    fun findByName(plotName: String): Optional<Plot>
    fun deleteByName(name: String)
    fun existsByName(name: String): Boolean
}