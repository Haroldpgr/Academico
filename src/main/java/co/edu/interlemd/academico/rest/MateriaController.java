package co.edu.interlemd.academico.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import entidades.Materia;

@RestController
public class MateriaController {

    private static List<Materia> list = new ArrayList<Materia>();

    @GetMapping("/api/materia/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {
        Materia materia = new Materia("Matematicas", 1322564, 2);

        list.add(materia);
        return String.format("Hello %s!", name);

    }

    @GetMapping(path = "/api/materia", produces = "application/json")
    public List<Materia> getTodos() {
        return list;
    }

    @PostMapping(path = "/api/materia", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Materia> create(@RequestBody Materia newMateria) {
        Materia materiaNueva = newMateria;
        list.add(materiaNueva);

        if (materiaNueva == null) {
            return new ResponseEntity<>(materiaNueva, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(materiaNueva, HttpStatus.CREATED);
        }
    }
}