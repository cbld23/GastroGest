-- src/main/resources/schema.sql

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE producto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INTEGER NOT NULL,
    categoria_id INTEGER REFERENCES categoria(id)
);

INSERT INTO categoria (nombre) VALUES
('Frutas y Verduras'),
('Carnes y Pescados'),
('Lácteos y Huevos'),
('Panadería y Repostería');

INSERT INTO producto (nombre, precio, stock, categoria_id) VALUES
('Manzanas', 1.99, 100, 1),
('Plátanos', 0.99, 150, 1),
('Filete de Res', 12.99, 50, 2),
('Salmón', 15.99, 40, 2),
('Leche Entera', 1.49, 200, 3),
('Huevos (docena)', 2.99, 80, 3),
('Pan de Molde', 1.99, 120, 4),
('Pastel de Chocolate', 14.99, 30, 4),
('Zanahorias', 0.89, 90, 1),
('Pechuga de Pollo', 8.99, 60, 2),
('Yogur Natural', 0.79, 100, 3),
('Croissant', 1.29, 50, 4);

