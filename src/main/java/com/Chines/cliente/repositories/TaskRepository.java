package com.Chines.cliente.repositories;

import com.Chines.cliente.model.inventory.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<MainEntity, Long> {
}
