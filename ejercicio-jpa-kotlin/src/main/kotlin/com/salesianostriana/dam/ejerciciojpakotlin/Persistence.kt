package com.salesianostriana.dam.ejerciciojpakotlin

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class Producto(
    var nombre : String,
    var precio : Double,
    var descripcion : String,
    var urlImagen : String,
    @Id @GeneratedValue var id : Long? = null

)

interface ProductoRepository : JpaRepository<Producto, Long>

@Entity
class Usuarios(
    var username : String,
    var password : String,
    var email : String,
    var fullName : String,
    @Id @GeneratedValue var id : Long? = null
)

interface UsuariosRepository : JpaRepository<Usuarios, Long>

@Entity
class Categoria(
    var nombre: String,
    var urlImagen: String,
    @Id @GeneratedValue var id : Long? = null
)

interface CategoriaRepository : JpaRepository<Categoria, Long>