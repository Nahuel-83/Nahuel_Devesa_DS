SET FOREIGN_KEY_CHECKS = 0;

DELETE from empleado;
DELETE from departamento;
DELETE from nomina;

ALTER TABLE empleado AUTO_INCREMENT = 1;
ALTER TABLE departamento AUTO_INCREMENT = 1;
ALTER TABLE nomina AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO departamento (nombre, presupuesto_anual) VALUES 
('Recursos Humanos', 500000.00),
('Tecnología', 1200000.00),
('Marketing', 700000.00),
('Finanzas', 900000.00);

INSERT INTO empleado (nombre, email, salario, en_activo, genero, departamento_id) VALUES 
('Juan Pérez', 'juan.perez@example.com', 45000.00, TRUE, 'MASCULINO', 1),
('Ana Gómez', 'ana.gomez@example.com', 60000.00, TRUE, 'FEMENINO', 2),
('Carlos López', 'carlos.lopez@example.com', 55000.00, TRUE, 'MASCULINO', 3),
('Marta Fernández', 'marta.fernandez@example.com', 75000.00, TRUE, 'FEMENINO', 4),
('Luis Torres', 'luis.torres@example.com', 50000.00, FALSE, 'MASCULINO', 1),
('Elena Ramírez', 'elena.ramirez@example.com', 67000.00, TRUE, 'FEMENINO', 2);
