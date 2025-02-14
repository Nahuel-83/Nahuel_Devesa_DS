SET FOREIGN_KEY_CHECKS = 0;

DELETE from equipo;
DELETE from partido;
DELETE from jornada;

ALTER TABLE equipo AUTO_INCREMENT = 1;
ALTER TABLE partido AUTO_INCREMENT = 1;
ALTER TABLE jornada AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO equipo (nombre, escudo_url, partidos_jugados, ganados, empatados, perdidos, goles_favor, goles_contra, puntos) VALUES
('Real Madrid', '/img/RealMadrid.png', 0, 0, 0, 0, 0, 0, 0),
('FC Barcelona', '/img/FCBarcelona.png', 0, 0, 0, 0, 0, 0, 0),
('Atlético de Madrid', '/img/AtleticoMadrid.png', 0, 0, 0, 0, 0, 0, 0),
('Sevilla FC', '/img/SevillaFC.png', 0, 0, 0, 0, 0, 0, 0),
('Real Sociedad', '/img/RealSociedad.png', 0, 0, 0, 0, 0, 0, 0),
('Athletic Club de Bilbao', '/img/AthleticBilbao.png', 0, 0, 0, 0, 0, 0, 0),
('Villarreal CF', '/img/VillarrealCF.png', 0, 0, 0, 0, 0, 0, 0),
('Real Betis', '/img/RealBetis.png', 0, 0, 0, 0, 0, 0, 0),
('Valencia CF', '/img/ValenciaCF.png', 0, 0, 0, 0, 0, 0, 0),
('Celta de Vigo', '/img/CeltaDeVigo.png', 0, 0, 0, 0, 0, 0, 0),
('Osasuna', '/img/CAOsasuna.png', 0, 0, 0, 0, 0, 0, 0),
('RCD Mallorca', '/img/RCDMallorca.png', 0, 0, 0, 0, 0, 0, 0),
('Getafe CF', '/img/GetafeCF.png', 0, 0, 0, 0, 0, 0, 0),
('UD Almería', '/img/UDAlmeria.png', 0, 0, 0, 0, 0, 0, 0),
('Rayo Vallecano', '/img/RayoVallecano.png', 0, 0, 0, 0, 0, 0, 0),
('Deportivo Alavés', '/img/DeportivoAlaves.png', 0, 0, 0, 0, 0, 0, 0),
('Girona FC', '/img/GironaFC.png', 0, 0, 0, 0, 0, 0, 0),
('Cádiz CF', '/img/CadizCF.png', 0, 0, 0, 0, 0, 0, 0);
