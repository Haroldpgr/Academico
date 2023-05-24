package co.edu.interlemd.academico.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.interlemd.academico.repositorio.TaskRepositorio;
import entidades.Task;

@RestController
public class TaskController {

    private TaskRepositorio repositorio = new TaskRepositorio();

    @GetMapping("/api/Task/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {
        Task task = new Task(0, "Matematicas", 1322564, 2);

        repositorio.crear(task);
        return String.format("Hello %s!", name);

    }

    @GetMapping(path = "/api/Tasks", produces = "application/json")
    public List<Task> getTodos() {
        return repositorio.leerTodos();
    }

    @PostMapping(path = "/api/Tasks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> create(@RequestBody Task newMateria) {
        Task materiaNueva = newMateria;
        repositorio.crear(materiaNueva);

        if (materiaNueva == null) {
            return new ResponseEntity<>(materiaNueva, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(materiaNueva, HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/api/Tasks",
     consumes = MediaType.APPLICATION_JSON_VALUE, 
     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> update(@RequestBody Task newMateria) {
        Task materiaNueva = newMateria;
        repositorio.actualizar(materiaNueva);

        if (materiaNueva == null) {
            return new ResponseEntity<>(materiaNueva, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(materiaNueva, HttpStatus.CREATED);

        }
    }
}