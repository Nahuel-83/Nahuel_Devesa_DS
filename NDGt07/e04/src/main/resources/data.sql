SET FOREIGN_KEY_CHECKS = 0;

DELETE from empleado;
DELETE from departamento;
DELETE from nomina;
DELETE from proyecto;
DELETE from empleado_proyecto;

ALTER TABLE empleado AUTO_INCREMENT = 1;
ALTER TABLE departamento AUTO_INCREMENT = 1;
ALTER TABLE nomina AUTO_INCREMENT = 1;
ALTER TABLE proyecto AUTO_INCREMENT = 1;
ALTER TABLE empleado_proyecto AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO departamento (nombre, presupuesto_anual) VALUES
('Recursos Humanos', 500000),
('Desarrollo', 1200000),
('Ventas', 800000),
('Marketing', 600000),
('Soporte', 400000);

INSERT INTO empleado (nombre, email, salario, en_activo, genero, departamento_id) VALUES
('Juan Pérez', 'juan.perez@example.com', 50000, TRUE, 'MASCULINO', 2),
('Ana Gómez', 'ana.gomez@example.com', 55000, TRUE, 'FEMENINO', 3),
('Carlos López', 'carlos.lopez@example.com', 60000, TRUE, 'MASCULINO', 2),
('Lucía Martínez', 'lucia.martinez@example.com', 52000, FALSE, 'FEMENINO', 1),
('David Fernández', 'david.fernandez@example.com', 48000, TRUE, 'OTROS', 4);

INSERT INTO proyecto (nombre, presupuesto) VALUES
('Sistema de Gestión', 200000),
('Aplicación Móvil', 150000),
('Plataforma E-commerce', 250000),
('Automatización de Procesos', 180000),
('Chatbot Inteligente', 100000);

INSERT INTO empleado_proyecto (empleado_id, proyecto_id, fecha_asignacion, rol) VALUES
(1, 1, '2024-01-10', 'Desarrollador'),
(2, 2, '2024-02-15', 'Analista'),
(3, 3, '2024-03-20', 'Project Manager'),
(4, 4, '2024-04-05', 'Tester'),
(5, 5, '2024-05-12', 'Diseñador UI');