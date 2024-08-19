package dev.niashi.to_do_list_backend;

import dev.niashi.to_do_list_backend.model.Task;
import dev.niashi.to_do_list_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Task t1 = new Task("Teste", "Descrição de Teste");
        Task t2 = new Task("Teste2", "Descrição de Teste2");

        repository.saveAll(Arrays.asList(t1, t2));
    }
}
