package com.imperialdemo.imperialdemo.task;

import com.imperialdemo.imperialdemo.tasks.model.TaskModel;
import com.imperialdemo.imperialdemo.tasks.repository.TaskRepository;
import com.imperialdemo.imperialdemo.tasks.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {TaskService.class})
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceTest {
  private final String name1 = "Test";
  private final String name2 = "Test2";
  private final String description1 = "Test description";
  private final String description2 = "Updated description";
  private final String status = "In progress";
  private final Long testID = 0L;
  private final TaskModel input = new TaskModel(name1, description1, status);

  @Autowired
  public TaskService taskService;

  @MockBean
  private TaskRepository taskRepository;

  @Test
  public void testCreateTask() {
    TaskModel expected = new TaskModel(name1, description1, status);

    when(taskRepository.save(any())).thenReturn(expected);

    assertEquals(expected, taskService.createTask(input));
  }
}
