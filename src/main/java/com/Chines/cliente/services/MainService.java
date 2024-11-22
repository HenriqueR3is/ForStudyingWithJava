package com.Chines.cliente.services;

import com.Chines.cliente.model.inventory.entity.MainEntity;
import com.Chines.cliente.model.Status;
import com.Chines.cliente.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Chines.cliente.model.Status.DONE;
import static com.Chines.cliente.model.Status.IN_PROGRESS;
// Logica de negocios do inventario
@Service
public class MainService {

    // private final EquipmentRepository equipmentRepository;

//    public MainService(EquipmentRepository equipmentRepository) {
//        this.equipmentRepository = equipmentRepository;
//    }

    @Autowired
    private TaskRepository taskRepository;

    // Alterar nomes
    public MainEntity createTask(MainEntity mainEntity) {
        mainEntity.setStatus(Status.TO_DO);
        return taskRepository.save(mainEntity);
    }

    // Lista todos
    public List<MainEntity> getAllTasks() {
        return taskRepository.findAll();
    }
    // Lista por id
//    public Optional<MainEntity> getOneTask() {
//        return taskRepository.findById(id);
//    }

    // Tipo
//    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
//        Equipment existingEquipment = equipmentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found with id " + id));
//        existingEquipment.setName(updatedEquipment.getName());
//        existingEquipment.setSerialNumber(updatedEquipment.getSerialNumber());
//        existingEquipment.setType(updatedEquipment.getType());
//        existingEquipment.setStatus(updatedEquipment.getStatus());
//        existingEquipment.setSupplierCode(updatedEquipment.getSupplierCode());
//        return equipmentRepository.save(existingEquipment);
//    }

    // Status
//    public Equipment updateEquipmentStatus(Long id, EquipmentStatus status) {
//        Equipment existingEquipment = equipmentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found with id " + id));
//        existingEquipment.setStatus(status);
//        return equipmentRepository.save(existingEquipment);
//    }

    public MainEntity updateTask(Long id, MainEntity updatedMainEntity) {
        return taskRepository.findById(id).map(mainEntity -> {
            mainEntity.setTitle(updatedMainEntity.getTitle());
            mainEntity.setDescription(updatedMainEntity.getDescription());
            mainEntity.setPriority(updatedMainEntity.getPriority());
            return taskRepository.save(mainEntity);
        }).orElseThrow(() -> new RuntimeException("MainEntity not found"));
    }

    public MainEntity moveTask(Long id) {
        MainEntity mainEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("MainEntity not found"));
        switch (mainEntity.getStatus()) {
            case TO_DO -> mainEntity.setStatus(IN_PROGRESS);
            case IN_PROGRESS -> mainEntity.setStatus(DONE);
            case DONE -> throw new IllegalStateException("MainEntity already completed");
        }
        return taskRepository.save(mainEntity);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Buscar por Type
//    public List<Equipment> getEquipmentsByType(EquipmentType type) {
//        return equipmentRepository.findByType(type);
//    }

    // Buscar por Status
//    public List<Equipment> getEquipmentsByStatus(EquipmentStatus status) {
//        return equipmentRepository.findByStatus(status);
//    }

}
