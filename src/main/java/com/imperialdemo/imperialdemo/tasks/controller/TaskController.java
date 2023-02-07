package com.imperialdemo.imperialdemo.tasks.controller;


import com.imperialdemo.imperialdemo.tasks.model.TaskModel;
import com.imperialdemo.imperialdemo.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

  @Autowired
  TaskService taskService;

  @PostMapping(path="/create", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> createTask(@RequestBody TaskModel task) {
    TaskModel newTask = taskService.createTask(task);

    if (newTask == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(newTask, HttpStatus.OK);
    }
  }

  @GetMapping(path="/get/{taskID}", produces = "application/json")
  public ResponseEntity<?> getTask(@PathVariable Long taskID) {
    TaskModel task;

    try {
      task = taskService.getTask(taskID);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @PutMapping(path="/delete/{taskID}", produces = "application/json")
  public ResponseEntity<?> deleteTask(@PathVariable Long taskID) {
    String deletedTaskID;

    try {
      deletedTaskID = taskService.deleteTask(taskID);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(deletedTaskID, HttpStatus.OK);
  }

  @GetMapping(path="/getTaskList", produces = "application/json")
  public ResponseEntity<?> getTaskList() {
    return new ResponseEntity<>(taskService.getTaskList(), HttpStatus.OK);
  }

  @PutMapping(path="/updateTask/{taskID}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> updateTask(@RequestBody TaskModel updatedTask, @PathVariable Long taskID) {
    TaskModel task;

    try {
      task = taskService.updateTask(updatedTask, taskID);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @PutMapping(path = "/markTaskComplete/{taskID}", produces = "application/json")
  public ResponseEntity<?> markTaskCompete(@PathVariable Long taskID) {
    TaskModel task;

    try {
      task = taskService.markTaskComplete(taskID);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(task, HttpStatus.OK);
  }
}
