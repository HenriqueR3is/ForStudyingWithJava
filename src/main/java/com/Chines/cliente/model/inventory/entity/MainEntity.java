package com.Chines.cliente.model.inventory.entity;

import com.Chines.cliente.model.Status;
import com.Chines.cliente.model.Type;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // nome

    @Column(nullable = false, unique = true) // id deve ser unico
    private String numeroSerial; // numero de serie

    private String description; // codigo

    @Column(nullable = false)
    private LocalDate creationDate = LocalDate.now(); // dataCadastro

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.TO_DO;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private EquipmentStatus status = EquipmentStatus.DISPONIVEL; // Status

    @Enumerated(EnumType.STRING)
    private Type type;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private EquipmentType tipoEquipamento; // Tipo

    public MainEntity() {
    }

    // Construtor
    public MainEntity(String title, String description, LocalDate dueDate, Type type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }
//    public Equipment(String nomeEquipamento, String numeroSerial, EquipmentType tipoEquipamento, EquipmentStatus status, String codigoFornecedor) {
//        this.nomeEquipamento = nomeEquipamento;
//        this.numeroSerial = numeroSerial;
//        this.tipoEquipamento = tipoEquipamento;
//        this.status = status;
//        this.codigoFornecedor = codigoFornecedor;
//    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getPriority() {
        return type;
    }

    public void setPriority(Type type) {
        this.type = type;
    }
}
