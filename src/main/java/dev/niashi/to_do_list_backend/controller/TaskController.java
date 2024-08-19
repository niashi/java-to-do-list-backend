package dev.niashi.to_do_list_backend.controller;

import dev.niashi.to_do_list_backend.model.Task;
import dev.niashi.to_do_list_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = service.addTask(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        service.deleteTaskById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Task task = service.findTaskById(id);

        return ResponseEntity.ok().body(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> tasks = service.findAllTasks();

        return ResponseEntity.ok().body(tasks);
    }

}
