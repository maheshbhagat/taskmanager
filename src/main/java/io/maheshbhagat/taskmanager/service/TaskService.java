package io.maheshbhagat.taskmanager.service;

import io.maheshbhagat.taskmanager.vo.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskService {

    private List<Task> taskList = null;

    @PostConstruct
    private void init(){

        taskList = Stream.iterate(0, i -> i + 1)
                .limit(10)
                .map(i -> Task.generateTask())
                .collect(Collectors.toList());
    }

    public Optional<Task> getTaskById(Long taskId){

        return this.taskList.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst();
    }

    public Optional<List<Task>> getAllTask(){

        return Optional.ofNullable(taskList);
    }

    public Optional<Task> createTask(Task task) {

        this.taskList.add(task);
        return Optional.ofNullable(task);
    }

    public Optional<Task> updateTask(Task taskToBeUpdated) {

        Optional<Task> matchedTask = this.taskList.stream()
                .filter(task -> task.getId().equals(taskToBeUpdated.getId()))
                .findFirst();

        if(matchedTask.isPresent()){
            Task task = matchedTask.get();
            task.setCompleted(taskToBeUpdated.isCompleted());
            task.setDescription(taskToBeUpdated.getDescription());
            task.setTitle(taskToBeUpdated.getTitle());
        }

        return Optional.ofNullable(matchedTask.get());
    }
}
