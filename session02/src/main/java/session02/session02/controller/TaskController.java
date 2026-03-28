package session02.session02.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import session02.session02.model.Task;
import session02.session02.service.TaskService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TaskController implements IController<Task, Integer>{
    private TaskService taskService;


    @Override
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(@RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return ResponseEntity.ok(taskService.findByTitle(title));
        }
        return ResponseEntity.ok(taskService.findAll());
    }
    
    @Override
    @PostMapping("/tasks")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        Task createdTask = taskService.add(task);
        if (createdTask != null) {
            URI uri = URI.create("/api/tasks/" + createdTask.getId());
            return ResponseEntity.created(uri).body(createdTask);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> update(Integer id, Task t) {
        return ResponseEntity.ok(taskService.update(id, t));
    }

    @Override
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> delete(Integer id) {
        return ResponseEntity.ok(taskService.delete(id));
    }

    @Override
    public Task findById(Integer id) {
        return taskService.findById(id);
    }

}
