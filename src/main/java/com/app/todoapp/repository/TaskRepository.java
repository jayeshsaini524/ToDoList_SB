package com.app.todoapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todoapp.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
