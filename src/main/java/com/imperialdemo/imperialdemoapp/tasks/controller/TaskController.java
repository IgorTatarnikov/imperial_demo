package com.imperialdemo.imperialdemoapp.tasks.controller;


import com.imperialdemo.imperialdemoapp.tasks.model.TaskModel;
import com.imperialdemo.imperialdemoapp.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

  @Autowired
  TaskService taskService;

  @PostMapping(path="/create", consumes = "application/json", produces = "application/json")
  public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task) {
    TaskModel newTask = taskService.createTask(task);

    if (newTask == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(newTask, HttpStatus.OK);
    }
  }

  @GetMapping(path="/get/{taskID}", produces = "application/json")
  public TaskModel getTask(@PathVariable Long taskID) {
    return taskService.getTask(taskID);
  }

  @PutMapping(path="/delete/{taskID}", consumes = "application/json", produces = "application/json")
  public String deleteTask(@PathVariable Long taskID) {
    return taskService.deleteTask(taskID);
  }

  @GetMapping(path="/getTaskList", produces = "application/json")
  public List<TaskModel> getTaskList() {
    return taskService.getTaskList();
  }

  @PutMapping(path="/updateTask/{taskID}", consumes = "application/json", produces = "application/json")
  public TaskModel updateTask(@RequestBody TaskModel updatedTask, @PathVariable Long taskID) {
    return taskService.updateTask(updatedTask, taskID);
  }

  @PutMapping(path = "/markTaskComplete/{taskID}", produces = "application/json")
  public TaskModel markTaskCompete(@PathVariable Long taskID) {
    return taskService.markTaskComplete(taskID);
  }
}
