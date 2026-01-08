-- Usuarios
INSERT INTO usuarios (nombre, apellido, correo) VALUES
('Pepito', 'Pérez', 'pepito.perez@proteccion.com'),
('Ana', 'Gómez', 'ana.gomez@proteccion.com'),
('María', 'López', 'maria.lopez@proteccion.com');

-- SOLICITUDES (10 tickets de prueba)
INSERT INTO solicitudes (id, tipo, prioridad_manual, fecha_creacion, usuario_id) VALUES
-- INCIDENTES (PRIMEROS)
(UUID(), 'INCIDENTE', 5, '2026-01-08 08:00:00', 1),
(UUID(), 'INCIDENTE', 3, '2026-01-08 09:30:00', 2),
(UUID(), 'INCIDENTE', 1, '2026-01-08 10:00:00', 3),

-- REQUERIMIENTOS (MEDIO)
(UUID(), 'REQUERIMIENTO', 5, '2026-01-08 07:45:00', 1),
(UUID(), 'REQUERIMIENTO', 4, '2026-01-08 09:00:00', 2),
(UUID(), 'REQUERIMIENTO', 2, '2026-01-08 09:45:00', 3),

-- CONSULTAS (ÚLTIMOS)
(UUID(), 'CONSULTA', 5, '2026-01-07 15:00:00', 1),
(UUID(), 'CONSULTA', 1, '2026-01-08 08:30:00', 2),
(UUID(), 'CONSULTA', 3, '2026-01-08 10:15:00', 3),
(UUID(), 'CONSULTA', 2, '2026-01-08 07:30:00', 1);
