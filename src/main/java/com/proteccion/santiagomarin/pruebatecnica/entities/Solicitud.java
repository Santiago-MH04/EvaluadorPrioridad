package com.proteccion.santiagomarin.pruebatecnica.entities;

import com.proteccion.santiagomarin.pruebatecnica.entities.utils.TipoSolicitud;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSolicitud tipo;

    @Column(name = "prioridad_manual")
    private Integer prioridadManual;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
        if (this.prioridadManual == null) {
            this.prioridadManual = 1;
        }
    }
}
