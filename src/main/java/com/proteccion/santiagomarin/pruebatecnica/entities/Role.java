package com.proteccion.santiagomarin.pruebatecnica.entities;

import com.proteccion.santiagomarin.pruebatecnica.entities.utils.RoleName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName nombre;
}
