package com.lucasgteixeira.WebTODO.domain.service;

import com.lucasgteixeira.WebTODO.domain.model.task.Task;
import com.lucasgteixeira.WebTODO.domain.model.task.TaskStatus;
import com.lucasgteixeira.WebTODO.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Task> getTaskById(Integer id){
        return taskRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Task> getTodoTasks(){
        return taskRepository.findTaskByTaskStatus(TaskStatus.TODO);
    }

    @Transactional(readOnly = true)
    public List<Task> getDoingTasks(){
        return taskRepository.findTaskByTaskStatus(TaskStatus.DOING);
    }

    @Transactional(readOnly = true)
    public List<Task> getDoneTasks(){
        return taskRepository.findTaskByTaskStatus(TaskStatus.DONE);
    }

    @Transactional
    public void addNewTask(Task task){
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(Task task){
        taskRepository.save(task);
    }




}
