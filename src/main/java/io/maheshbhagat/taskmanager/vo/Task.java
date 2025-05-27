package io.maheshbhagat.taskmanager.vo;

import lombok.Data;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Task {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public static Task generateTask() {
        Task task = new Task();
        task.id = ThreadLocalRandom.current().nextLong(1, 10000);
        task.title = "Task " + UUID.randomUUID().toString().substring(0, 8);
        task.description = "Description for task " + task.id;
        task.completed = ThreadLocalRandom.current().nextBoolean();
        return task;
    }
}
