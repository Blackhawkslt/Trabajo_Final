package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tienda.model.Libro;
import com.tienda.repository.LibroRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/api/libros")
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Libro>> obtenerLibros() {
    System.out.println("Recibiendo solicitud para obtener libros");
    List<Libro> libros = libroRepository.findAll();
    return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    
    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        if (libroRepository.existsById(id)) {
            libroActualizado.setId(id);
            return libroRepository.save(libroActualizado);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
    }
}