-- ROLES
INSERT INTO roles (nombre) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

-- USUARIOS (con clave obligatoria encriptada con BCrypt)
INSERT INTO usuarios (nombre, apellido, correo, clave) VALUES
('Pepito', 'Pérez', 'pepito.perez@proteccion.com', '$2a$10$ISdmZ9o2g8Snb3hGk4kkrelGTjH5zPsk66.jArlJL2yzW5dGxTvO.'),
('Ana', 'Gómez', 'ana.gomez@proteccion.com', '$2a$10$ISdmZ9o2g8Snb3hGk4kkrelGTjH5zPsk66.jArlJL2yzW5dGxTvO.'),
('María', 'López', 'maria.lopez@proteccion.com', '$2a$10$ISdmZ9o2g8Snb3hGk4kkrelGTjH5zPsk66.jArlJL2yzW5dGxTvO.');

-- Relación USUARIO_ROLES
-- Pepito -> ROLE_USER
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (1, 1);
-- Ana -> ROLE_USER + ROLE_ADMIN
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (2, 1), (2, 2);
-- María -> ROLE_USER
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (3, 1);

-- SOLICITUDES (tickets de prueba)
INSERT INTO solicitudes (id, tipo, prioridad_manual, fecha_creacion, usuario_id) VALUES
(UUID(), 'INCIDENTE', 5, '2026-01-08 08:00:00', 1),
(UUID(), 'INCIDENTE', 3, '2026-01-08 09:30:00', 2),
(UUID(), 'INCIDENTE', 1, '2026-01-08 10:00:00', 3),

(UUID(), 'REQUERIMIENTO', 5, '2026-01-08 07:45:00', 1),
(UUID(), 'REQUERIMIENTO', 4, '2026-01-08 09:00:00', 2),
(UUID(), 'REQUERIMIENTO', 2, '2026-01-08 09:45:00', 3),

(UUID(), 'CONSULTA', 5, '2026-01-07 15:00:00', 1),
(UUID(), 'CONSULTA', 1, '2026-01-08 08:30:00', 2),
(UUID(), 'CONSULTA', 3, '2026-01-08 10:15:00', 3),
(UUID(), 'CONSULTA', 2, '2026-01-08 07:30:00', 1);