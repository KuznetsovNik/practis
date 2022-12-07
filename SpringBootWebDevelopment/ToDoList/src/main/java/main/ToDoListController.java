package main;

import model.Task;
import model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
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

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    //2.title;description
    //3.Метод должен создавать задачу с указанными в запросе названием и описанием.
    //Дата и время создания (creationTime), а также значение поля isDone должны устанавливаться автоматически.
    //Ответ не должен содержать тело и должен иметь код HTTP-ответа 201
    public ResponseEntity<String> createTask(@RequestParam("title") String title, @RequestParam("description") String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCreationTime(LocalDateTime.now());
        task.setDone(false);
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{id}")
    //2.ID — идентификатор задачи
    //3.Метод должен возвращать информацию о задаче, ID которой передан ему в качестве параметра. Формат:
    //{"id": 25,
    //"creationTime": "2022-05-17 17:36:02",
    //"isDone": false,
    //"title": "Прочитать про Spring Security",
    //"description": "После прочтения попробовать реализовать на практике"}
    //Если задача не найдена, код ответа должен быть 404
    public ResponseEntity<String> getInfoTask(@PathVariable int id){
        try {
            Optional<Task> task = taskRepository.findById(id);
            return new ResponseEntity<>(task.toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tasks")
    //2.Запрос без параметров
    //3.Метод должен возвращать список всех задач в формате JSON:
    //[{"id": 25,
    //"creationTime": "2022-05-17 17:36:02",
    //"isDone": false,
    //"title": "Прочитать про Spring Security",
    //"description": "После прочтения попробовать реализовать на практике"},…]
    public List<Task> getListTasks(){
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable){
            tasks.add(task);
        }
        return tasks;
    }

    //1.PATCH /tasks/ID
    @PatchMapping(value = "/tasks/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    //2.Один или несколько параметров из списка: isDone;title;description
    //3.В задаче должны обновляться только переданные параметры.Если задача не найдена, код ответа должен быть 404
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
    //2.ID — идентификатор задачи
    //3.Задача с заданным ID должна удаляться из базы.Если задача не найдена, код ответа должен быть 404
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
