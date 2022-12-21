package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoListController {
    @Autowired
    private TaskRepository taskRepository;

    public ToDoListController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/")
    public String index(){
        return (new Date()).toString() + " - Дата. Рандомное число = " + ((int)(Math.random() * 100));
    }

    @PostMapping(value = "/tasks", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = new Task(task.getTitle(), task.getDescription());
        taskRepository.save(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getInfoTask(@PathVariable long id){
            Optional<Task> taskOptional = taskRepository.findById(id);
            if(!taskOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return new ResponseEntity<>(taskOptional.get(), HttpStatus.OK);

    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getListTasks(){
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        if (!tasks.isEmpty()) {
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
    @PatchMapping(value = "/tasks/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<?> updateTask(@PathVariable long id,@RequestParam("isDone") boolean isDone,@RequestParam("title") String title,@RequestParam("description") String description){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDone(isDone);
            task.setTitle(title);
            task.setDescription(description);
            taskRepository.save(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            taskRepository.delete(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
