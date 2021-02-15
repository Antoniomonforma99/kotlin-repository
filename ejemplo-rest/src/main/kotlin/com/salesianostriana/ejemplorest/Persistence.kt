package com.salesianostriana.ejemplorest

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Message(
        var text: String,
        @Id @GeneratedValue var id : Long? = null      // ó @Id @GeneratedValue val id : Long?
)

interface MessageRepository: JpaRepository<Message, Long>

