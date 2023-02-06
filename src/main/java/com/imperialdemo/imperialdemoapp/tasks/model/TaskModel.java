package com.imperialdemo.imperialdemoapp.tasks.model;

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

  public TaskModel() { }

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
