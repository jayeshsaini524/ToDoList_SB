package com.app.todoapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "table1")
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String title;

    boolean Completed;
}
