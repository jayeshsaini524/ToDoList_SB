package com.app.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todoapp.entities.TaskEntity;
import com.app.todoapp.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    //**Get mapping */
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    //**Post mapping */
    public void addEntry(String taskName) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskName);
        taskEntity.setCompleted(false);
        taskRepository.save(taskEntity);
    }

    /*change Task Name */
    public void changeName(String newTitle, Long id) {
        TaskEntity task = taskRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("invalid task"));
        task.setTitle(newTitle);
        taskRepository.save(task);
    }
    /*Delete mapping */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /*toggling task*/
    public void toggleTask(Long id) {
        TaskEntity task = taskRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("invalid task"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
