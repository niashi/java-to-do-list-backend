package dev.niashi.to_do_list_backend.service;

import dev.niashi.to_do_list_backend.model.Task;
import dev.niashi.to_do_list_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }

    public Task findTaskById(Long id) {
        Optional<Task> task = repository.findById(id);

        return task.get();
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }
}

