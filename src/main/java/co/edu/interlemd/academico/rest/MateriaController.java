package co.edu.interlemd.academico.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(path = "/api/materias", produces = "application/json")
    public List<Materia> getTodos() {
        return list;
    }
}
