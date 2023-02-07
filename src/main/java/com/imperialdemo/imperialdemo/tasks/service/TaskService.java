package com.imperialdemo.imperialdemo.tasks.service;

import com.imperialdemo.imperialdemo.tasks.model.TaskModel;
import com.imperialdemo.imperialdemo.tasks.repository.TaskRepository;
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
    if (task.getName() == null) {
      return null;
    }

    return taskRepository.save(TaskModel.create(task));
  }

  public String deleteTask(long taskID) throws NoSuchElementException {
    TaskModel taskModel;
    Optional<TaskModel> task = taskRepository.findById(taskID);

    taskModel = task.orElseThrow();

    taskRepository.delete(taskModel);

    return taskModel.getId().toString();
  }

  public List<TaskModel> getTaskList() {

    return taskRepository.findAll();
  }

  public TaskModel updateTask(TaskModel updatedTask, Long taskID) throws NoSuchElementException {
    Optional<TaskModel> task = taskRepository.findById(taskID);

    TaskModel taskModel = task.orElseThrow();

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

  public TaskModel markTaskComplete(Long taskID) throws NoSuchElementException {
    Optional<TaskModel> task = taskRepository.findById(taskID);

    TaskModel taskModel = task.orElseThrow();

    taskModel.setStatus("Complete");

    return taskModel;
  }

  public TaskModel getTask(Long taskID) throws NoSuchElementException{
    Optional<TaskModel> task = taskRepository.findById(taskID);

    return task.orElseThrow();
  }
}
