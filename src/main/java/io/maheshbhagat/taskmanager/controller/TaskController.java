package io.maheshbhagat.taskmanager.controller;

import io.maheshbhagat.taskmanager.service.TaskService;
import io.maheshbhagat.taskmanager.vo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable Long taskId){

        Optional<Task> taskById = this.taskService.getTaskById(taskId);

        return ResponseEntity.ok(taskById.get());
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(){

        Optional<List<Task>> allTask = this.taskService.getAllTask();

        return ResponseEntity.ok(allTask.get());
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task taskToBeCreated){

        Optional<Task> createdTask = this.taskService.createTask(taskToBeCreated);

        return ResponseEntity.ok(createdTask.get());
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Task taskToBeUpdated){

        Optional<Task> updatedTask = this.taskService.updateTask(taskToBeUpdated);

        return ResponseEntity.ok(updatedTask);
    }
}
