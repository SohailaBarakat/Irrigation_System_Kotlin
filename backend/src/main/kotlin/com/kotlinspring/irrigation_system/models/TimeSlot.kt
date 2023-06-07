package com.kotlinspring.irrigation_system.models

import jakarta.persistence.*


@Entity
@Table(name = "time_slot",
    catalog = "irrigation_system"
)
data class TimeSlot (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    var id: Int,

    @Column(name="start_hour", nullable=false)
    var startHour: Int,

    @Column(name="end_hour", nullable=false)
    var endHour: Int,

    @Column(name="is_completed")
    var isCompleted: Boolean,

    @OneToMany(fetch= FetchType.LAZY, mappedBy="timeSlot")
    var plots: Set<Plot> = mutableSetOf()
)

