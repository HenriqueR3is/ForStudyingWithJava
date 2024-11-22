package com.Chines.cliente.http.controllers;

import com.Chines.cliente.model.inventory.entity.MainEntity;
import com.Chines.cliente.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks") // Rota Principal
public class MainController {

    // private final EquipmentService equipmentService;
    @Autowired
    private MainService mainService;

    // Criar
    @PostMapping
    public MainEntity createTask(@RequestBody MainEntity mainEntity) {
        return mainService.createTask(mainEntity);
    }

    // Listar todos
    @GetMapping
    public List<MainEntity> getAllTasks() {
        return mainService.getAllTasks();
    }

    // Listar por id
//    @GetMapping("/{id}")
//    public Cliente buscarClientePorId(@PathVariable("id") Long id) {
//        return ClienteService.buscarPorId(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Nao Encontrado."));
//    }

    // Atualizar por id
    @PutMapping("/{id}")
    public MainEntity updateTask(@PathVariable Long id, @RequestBody MainEntity updatedMainEntity) {
        return mainService.updateTask(id, updatedMainEntity);
    }

    // Atualizar o status de um equipamento
//    @PutMapping("/{id}/status")
//    public Equipment updateEquipmentStatus(@PathVariable Long id, @RequestBody EquipmentStatus status) {
//        return equipmentService.updateEquipmentStatus(id, status);
//    }

    // Consultar equipamentos por tipo
//    @GetMapping("/type/{type}")
//    public List<Equipment> getEquipmentsByType(@PathVariable EquipmentType type) {
//        return equipmentService.getEquipmentsByType(type);
//    }

    // Consultar equipamentos por status
//    @GetMapping("/status/{status}")
//    public List<Equipment> getEquipmentsByStatus(@PathVariable EquipmentStatus status) {
//        return equipmentService.getEquipmentsByStatus(status);
//    }

    // Deletar pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        mainService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
