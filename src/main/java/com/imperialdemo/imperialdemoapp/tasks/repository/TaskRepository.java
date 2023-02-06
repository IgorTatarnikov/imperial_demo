package com.imperialdemo.imperialdemoapp.tasks.repository;


import com.imperialdemo.imperialdemoapp.tasks.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

}
