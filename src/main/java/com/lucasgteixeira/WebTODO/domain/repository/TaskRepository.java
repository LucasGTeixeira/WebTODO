package com.lucasgteixeira.WebTODO.domain.repository;

import com.lucasgteixeira.WebTODO.domain.model.task.Task;
import com.lucasgteixeira.WebTODO.domain.model.task.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTaskByTaskStatus(TaskStatus status);

    Task findTaskById(Integer id);
}
