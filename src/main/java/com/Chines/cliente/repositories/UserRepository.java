package com.Chines.cliente.repositories;

import com.Chines.cliente.model.inventory.entity.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<MainUser, String>{
    UserDetails findByLogin(String login); // Ajustar para encontrar conforme a regra
    // List<Equipment> findByType(EquipmentType type);
}
