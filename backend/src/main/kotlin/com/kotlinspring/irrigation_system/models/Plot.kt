package com.kotlinspring.irrigation_system.models

import com.kotlinspring.irrigation_system.dtos.TimeSlotDTO
import jakarta.persistence.*


@Entity
@Table(name = "plot",
    catalog = "irrigation_system",
)
data class Plot(
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    var id: Int,

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="time_slot_id")
    var timeSlot: TimeSlot,

    @Column(name = "name", unique = true, nullable = false, length = 50)
    var name: String,

    @Column(name = "area", nullable = false, scale = 0)
    var area: Double,

    @Column(name = "water_required", nullable = false, scale = 0)
    var waterRequired: Double,

    @Column(name = "crop_type", nullable = false,  length = 50)
    var cropType: String,
)



