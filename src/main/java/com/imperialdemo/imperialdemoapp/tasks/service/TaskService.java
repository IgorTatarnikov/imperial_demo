package com.imperialdemo.imperialdemoapp.tasks.service;

import com.imperialdemo.imperialdemoapp.tasks.model.TaskModel;
import com.imperialdemo.imperialdemoapp.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {

  @Autowired
  TaskRepository taskRepository;

  public TaskModel createTask(TaskModel task) {
    if (task.getName().isEmpty()) {
      return null;
    }

    return taskRepository.save(task);
  }

  public String deleteTask(long taskID) {
    TaskModel taskModel;
    Optional<TaskModel> task = taskRepository.findById(taskID);

    try {
      taskModel = task.orElseThrow();
    } catch (NoSuchElementException noSuchElementException) {
      return noSuchElementException.getMessage();
    }

    taskRepository.delete(taskModel);

    return taskModel.getId().toString();
  }

  public List<TaskModel> getTaskList() {

    return taskRepository.findAll();
  }

  public TaskModel updateTask(TaskModel updatedTask, Long taskID) {
    Optional<TaskModel> task = taskRepository.findById(taskID);

    TaskModel taskModel = task.orElse(null);

    if (taskModel == null) {
      return null;
    }

    if (!updatedTask.getName().isBlank()) {
      taskModel.setName(updatedTask.getName());
    }

    if (!updatedTask.getDescription().isBlank()) {
      taskModel.setDescription(updatedTask.getDescription());
    }

    if (updatedTask.getDueDate() != null) {
      taskModel.setDueDate(updatedTask.getDueDate());
    }

    taskRepository.save(taskModel);

    return taskModel;
  }

  public TaskModel markTaskComplete(Long taskID) {
    Optional<TaskModel> task = taskRepository.findById(taskID);

    TaskModel taskModel = task.orElse(null);

    taskModel.setStatus("Complete");

    return taskModel;
  }

  public TaskModel getTask(Long taskID) {
    Optional<TaskModel> task = taskRepository.findById(taskID);

    return task.orElse(null);
  }
}
