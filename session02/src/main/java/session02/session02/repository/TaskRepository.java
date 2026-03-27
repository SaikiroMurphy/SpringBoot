package session02.session02.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import session02.session02.model.Task;
import session02.session02.utils.Priority;

@Repository
public class TaskRepository implements IRepository<Task, Integer>{
    private static ArrayList<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();

        tasks.add(new Task(1, "Fix login bug", "Cannot login with valid account", Priority.CRITICAL, 1));
        tasks.add(new Task(2, "Add product API", "Create API for adding product", Priority.HIGH, 1));
        tasks.add(new Task(3, "Update UI homepage", "Improve layout", Priority.MEDIUM, 2));
        tasks.add(new Task(4, "Write unit test", "Test service layer", Priority.MEDIUM, 2));
        tasks.add(new Task(5, "Fix delete bug", "Delete not working", Priority.HIGH, 1));
        tasks.add(new Task(6, "Optimize query", "Improve DB performance", Priority.LOW, 3));
        tasks.add(new Task(7, "Refactor code", "Clean service code", Priority.LOW, 2));
        tasks.add(new Task(8, "Add validation", "Validate input", Priority.HIGH, 1));
        tasks.add(new Task(9, "Deploy app", "Deploy to server", Priority.CRITICAL, 3));
        tasks.add(new Task(10, "Write docs", "API documentation", Priority.MEDIUM, 2));
    }

    @Override
    public ArrayList<Task> findAll() {
        return tasks;
    }

    @Override
    public Task add() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Task update(Integer id, Task t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Task delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Task findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public List<Task> findByTitle(String title) {
        return tasks.stream().filter(t -> t.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

    
}
