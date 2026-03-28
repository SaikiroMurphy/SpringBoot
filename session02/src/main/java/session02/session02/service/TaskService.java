package session02.session02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import session02.session02.model.Task;
import session02.session02.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService implements IService<Task, Integer>{
    private TaskRepository taskRepository;
    private UserService userService;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task add(Task task) {
        int userId = task.getAssignedTo();
        if (userService.findById(userId) != null) {
            return taskRepository.add(task);
        }
        return null;
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
        return taskRepository.findByTitle(title);

    }

}
