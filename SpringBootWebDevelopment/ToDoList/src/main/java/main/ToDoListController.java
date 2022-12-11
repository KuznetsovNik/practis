package main;

import model.Task;
import model.TaskRepository;
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
    private TaskRepository taskRepository;
    @RequestMapping("/")
    public String index(){
        return (new Date()).toString() + " - Дата. Рандомное число = " + ((int)(Math.random() * 100));
    }
    @PostMapping(value = "/tasks", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = new Task(task.getTitle(),task.getDescription());
        taskRepository.save(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity getInfoTask(@PathVariable int id){
            Optional<Task> taskOptional = taskRepository.findById(id);
            if(!taskOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return new ResponseEntity(taskOptional.get(), HttpStatus.OK);

    }
    @GetMapping("/tasks")
    public List<Task> getListTasks(){
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }
    @PatchMapping(value = "/tasks/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<HttpStatus> updateTask(@PathVariable int id,@RequestParam("isDone") boolean isDone,@RequestParam("title") String title,@RequestParam("description") String description){
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
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable int id){
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
