package com.imperialdemo.imperialdemo.tasks.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "Tasks")
public class TaskModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String status;
  private OffsetDateTime createdAt;
  private OffsetDateTime dueDate;
  private OffsetDateTime lastUpdated;

  public TaskModel(String name, String description, String status, OffsetDateTime dueDate) {
    this.name = name;
    this.description = description;
    this.status = status;
    this.dueDate = dueDate;

    this.createdAt = OffsetDateTime.now();
    this.lastUpdated = createdAt;
  }

  public TaskModel(String name, String description, String status) {
    this.name = name;
    this.description = description;
    this.status = status;

    this.createdAt = OffsetDateTime.now();
    this.lastUpdated = createdAt;
    this.dueDate = createdAt.plusDays(7);
  }

  public TaskModel() {  }

  public static TaskModel create(TaskModel inputTaskModel) {
    TaskModel newTask;

    if (inputTaskModel.getDueDate() == null) {
      newTask = new TaskModel(inputTaskModel.getName(), inputTaskModel.getDescription(), inputTaskModel.getStatus());
    } else {
      newTask = new TaskModel(inputTaskModel.getName(), inputTaskModel.getDescription(), inputTaskModel.getStatus(), inputTaskModel.getDueDate());
    }

    return newTask;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String taskName) {
    this.name = taskName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String taskDescription) {
    this.description = taskDescription;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime dateCreated) {
    this.createdAt = dateCreated;
  }

  public OffsetDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
  }
}
