package com.salesianostriana.dam.ejerciciojpakotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/task")
class TaskController {

    @Autowired
    lateinit var repositorio : TaskRepository


    @GetMapping("/")
    fun getAll() : ResponseEntity<List<Task>> {
        val result = repositorio.findAll()

        if (!result.isEmpty()){
            return ResponseEntity.ok(result)
        }else{
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "No hay tareas programadas"
            )
        }

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long) =
        repositorio.findById(id).
            orElseThrow {ResponseStatusException(
                HttpStatus.NOT_FOUND, "no hay tareas con id: ${id}"
            )
            }

    @PostMapping("/")
    fun create(@RequestBody tsk : Task) : ResponseEntity<Task> =
        ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(tsk))


    @PutMapping("/{id}")
    fun edit(@PathVariable id : Long, @RequestBody edited : Task) : ResponseEntity<Task> =
        repositorio.findById(id).map { tsk ->
            tsk.text = edited.text
            ResponseEntity.ok(repositorio.save(tsk))
        }.orElseThrow{
            ResponseStatusException(
                HttpStatus.NOT_FOUND, "no hay tareas con id: ${id}"
            )
        }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : ResponseEntity<Any> {
        if (repositorio.existsById(id))
            repositorio.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
