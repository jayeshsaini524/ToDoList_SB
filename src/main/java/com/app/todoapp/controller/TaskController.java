package com.app.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoapp.entities.TaskEntity;
import com.app.todoapp.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    //Important
    @GetMapping
    public String getTasks(Model model) {
        List<TaskEntity> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    //form is used in html to post request
    @PostMapping("/add")
    public String addEntry(@RequestParam String taskName) {
        taskService.addEntry(taskName);
        return "redirect:/tasks";
    }

    @PutMapping("/put/{id}")
    public String changeTask(@RequestParam String name, @PathVariable Long id) {
        taskService.changeName(name, id);
        return "redirect:/tasks";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }

}
