package com.imperialdemo.imperialdemo.tasks.repository;


import com.imperialdemo.imperialdemo.tasks.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

}
