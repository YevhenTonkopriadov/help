package ua.gov.mkip.itHelp.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.gov.mkip.itHelp.model.Task;
import ua.gov.mkip.itHelp.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskServises {

    private final  TaskRepository taskRepository;

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public void saveTask (Task task) {
        taskRepository.save(task);
    }

}
