package com.salesianostriana.ejemplorest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.NoSuchElementException

@SpringBootApplication
class EjemploRestApplication

fun main(args: Array<String>) {
	runApplication<EjemploRestApplication>(*args)
}
/*
data class Message(
		val id: Int,
		val text: String
)

@RestController
class MainController {

	private var datos = listOf(
			Message(1, "Hola!"),
			Message(2, "Hello!"),
			Message(3, "Hola Dola!"))

	@GetMapping("/")
	fun getAll() : List<Message> = datos

	/*@GetMapping("/{id}")
	fun getbyId(@PathVariable id: Int): Message?{
		var result : Message? = null
		try {
		    result =  datos.first { it.id == id}
		} catch (ex: NoSuchElementException){
			result = Message(0, "No existe el emento")
		}
		return result
	}*/

	@GetMapping("/{id}")
	fun getbyId(@PathVariable id: Int): ResponseEntity<Message>{
		var result : Message? = null

		try {
			result =  datos.first { it.id == id}
			return ResponseEntity.ok(result)
		}catch (ex : NoSuchElementException){
			return ResponseEntity.status(404).body(Message(0,"No existe un mensaje con id: ${id}"))
			//return ResponseEntity.notFound().build() // para enviar el error 404 pero sin mensaje ni nada
		}

	}

}*/





