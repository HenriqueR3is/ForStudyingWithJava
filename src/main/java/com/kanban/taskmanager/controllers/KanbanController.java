package com.kanban.taskmanager.controllers;

import com.kanban.taskmanager.model.Task;
import com.kanban.taskmanager.services.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class KanbanController {

    @Autowired
    private KanbanService kanbanService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return kanbanService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return kanbanService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return kanbanService.updateTask(id, updatedTask);
    }

    @PutMapping("/{id}/move")
    public Task moveTask(@PathVariable Long id) {
        return kanbanService.moveTask(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        kanbanService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
