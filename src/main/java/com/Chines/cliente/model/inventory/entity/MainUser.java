package com.Chines.cliente.model.inventory.entity;


import com.Chines.cliente.model.inventory.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class MainUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String login; // nome
    private String password; // numero
    private UserRole role; // tipo

    public MainUser(String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getLogin() {
        return login;
    }

//    public class Equipment {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.UUID)
//        private String id;
//
//        private String nomeEquipamento; // Nome do equipamento
//
//        private String numeroSerial; // Número de série do equipamento
//
//        @Enumerated(EnumType.STRING)
//        private EquipmentType tipoEquipamento; // Tipo do equipamento (LAPTOP, MONITOR, IMPRESSORA)
//
//        @Enumerated(EnumType.STRING)
//        private EquipmentStatus status; // Status do equipamento (DISPONIVEL, EM_USO, MANUTENCAO)
//
//        private String codigoFornecedor; // Código de referência ao fornecedor
//
//        public Equipment(String nomeEquipamento, String numeroSerial, EquipmentType tipoEquipamento, EquipmentStatus status, String codigoFornecedor) {
//            this.nomeEquipamento = nomeEquipamento;
//            this.numeroSerial = numeroSerial;
//            this.tipoEquipamento = tipoEquipamento;
//            this.status = status;
//            this.codigoFornecedor = codigoFornecedor;
//        }
//    }
}
