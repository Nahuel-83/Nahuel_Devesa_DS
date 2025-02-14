SET FOREIGN_KEY_CHECKS = 0;

DELETE from empleado;
DELETE from departamento;

ALTER TABLE empleado AUTO_INCREMENT = 1;
ALTER TABLE departamento AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO departamento (nombre, presupuesto_anual) VALUES
('Recursos Humanos', 100000.00),
('Tecnología', 250000.00),
('Marketing', 350000.00),
('Ventas', 220000.00),
('Finanzas', 280000.00);


INSERT INTO empleado (nombre, email, salario, en_activo, genero, departamento_id) VALUES
('Juan Pérez', 'juan.perez@example.com', 35000.00, true, 'MASCULINO', 1),
('María López', 'maria.lopez@example.com', 42000.50, true, 'FEMENINO', 2),
('Alex Rodríguez', 'alex.rodriguez@example.com', 39000.75, false, 'OTROS', 3),
('Carlos Gómez', 'carlos.gomez@example.com', 28000.00, true, 'MASCULINO', 4),
('Lucía Fernández', 'lucia.fernandez@example.com', 50000.00, true, 'FEMENINO', 5),
('Andrea Torres', 'andrea.torres@example.com', 32000.25, false, 'OTROS', 1),
('Fernando Martínez', 'fernando.martinez@example.com', 46000.50, true, 'MASCULINO', 2),
('Isabel García', 'isabel.garcia@example.com', 41000.00, true, 'FEMENINO', 3),
('Roberto Díaz', 'roberto.diaz@example.com', 30300.25, true, 'MASCULINO', 4),
('Susana Pérez', 'susana.perez@example.com', 40800.00, true, 'FEMENINO', 5);
