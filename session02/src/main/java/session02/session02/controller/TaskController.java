package session02.session02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session02.session02.model.Task;
import session02.session02.service.TaskService;

@RestController
@RequiredArgsConstructor
public class TaskController implements IController<Task, Integer>{
    @Autowired
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
    public ResponseEntity<Task> add() {
        return ResponseEntity.ok(taskService.add());
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
    public ResponseEntity<Task> findById(Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }
}
