package com.salesianostriana.dam.ejerciciojpakotlin

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Task(
    var text : String,
    var fechaRemember : Date,
    @Id @GeneratedValue var id : Long? = null
)

interface TaskRepository : JpaRepository<Task, Long>
