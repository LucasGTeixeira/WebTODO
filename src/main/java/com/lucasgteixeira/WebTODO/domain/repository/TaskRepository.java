package com.lucasgteixeira.WebTODO.domain.repository;

import com.lucasgteixeira.WebTODO.domain.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    public List<Task> findTaskByStatus(Task task); //regra de negócio
}