package com.lucasgteixeira.WebTODO.domain.controller;

import com.lucasgteixeira.WebTODO.domain.model.task.Task;
import com.lucasgteixeira.WebTODO.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/add")
    public String addNewTask(Task task){
        return "/addTask";
    }

    @PostMapping("/save")
    public String saveTask(Task task, RedirectAttributes attr){
        taskService.addNewTask(task);
        attr.addFlashAttribute("success", "task added");
        return "redirect:/add";
    }

    @GetMapping("/update/{id}")
    public String preUpdateTask(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "/addTask";
    }

    @PostMapping("/update")
    public String updateTask(Task task, RedirectAttributes attr){
        taskService.updateTask(task);
        attr.addFlashAttribute("success", "task updated");
        return "redirect:/add";
    }

    @GetMapping("/listAll")
   public String listAllTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", taskService.getAllTasks());
        return "/allTasks";
   }

   @GetMapping("/listTodo")
   public String listTodoTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", taskService.getTodoTasks());
        return "/todoTasks";
   }

   @GetMapping("/listDoing")
   public String listDoingTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", taskService.getDoingTasks());
        return "/doingTasks";
   }

   @GetMapping("/listDone")
   public String listDoneTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", taskService.getDoneTasks());
        return "/doneTasks";
   }



}
