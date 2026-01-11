    package com.proteccion.santiagomarin.pruebatecnica.entities;
    
    import jakarta.persistence.*;
    import lombok.Data;
    
    @Entity
    @Table(name = "usuarios")
    @Data
    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(nullable = false)
        private String nombre;
    
        @Column(nullable = false)
        private String apellido;
    
        @Column(nullable = false, unique = true)
        private String correo;

        @Column(nullable = false)
        private String clave;
    }
