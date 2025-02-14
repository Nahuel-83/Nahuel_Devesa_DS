SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS empleado_proyecto;
DROP TABLE IF EXISTS nomina;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS proyecto;
DROP TABLE IF EXISTS departamento;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE empleado (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    salario DOUBLE,
    en_activo BOOLEAN,  
    genero ENUM('MASCULINO', 'FEMENINO', 'OTROS')
);

INSERT INTO empleado (nombre, email, salario, en_activo, genero) VALUES
('Juan Pérez', 'juan.perez@example.com', 35000.00, true, 'MASCULINO'),
('María López', 'maria.lopez@example.com', 42000.50, true, 'FEMENINO'),
('Alex Rodríguez', 'alex.rodriguez@example.com', 39000.75, false, 'OTROS'),
('Carlos Gómez', 'carlos.gomez@example.com', 28000.00, true, 'MASCULINO'),
('Lucía Fernández', 'lucia.fernandez@example.com', 50000.00, true, 'FEMENINO'),
('Andrea Torres', 'andrea.torres@example.com', 32000.25, false, 'OTROS');

