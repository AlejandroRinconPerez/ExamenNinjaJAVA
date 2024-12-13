CREATE DATABASE CamininoNinja;

use CamininoNinja;


CREATE TABLE Ninja (
    ID INT AUTO_INCREMENT PRIMARY KEY,        
    Nombre VARCHAR(100) NOT NULL,             
    Rango VARCHAR(50) NOT NULL,               
    Aldea VARCHAR(100) NOT NULL               
);


CREATE TABLE Mision (
    ID INT AUTO_INCREMENT PRIMARY KEY,        
    Descripcion VARCHAR(100) ,                
    Rango VARCHAR(100) ,               
    Recompensa DECIMAL(10, 2)         
);


CREATE TABLE MisionNinja (
    ID_Ninja INT ,                    
    ID_Mision INT ,                   
    FechaInicio DATE ,                
    FechaFin DATE,                            
    PRIMARY KEY (ID_Ninja, ID_Mision),        
    FOREIGN KEY (ID_Ninja) REFERENCES Ninja(ID) ON DELETE CASCADE,  
    FOREIGN KEY (ID_Mision) REFERENCES Mision(ID) ON DELETE CASCADE 
);


CREATE TABLE Habilidad (
    ID_Ninja INT ,                    
    Nombre VARCHAR(100) ,             
    Descripcion TEXT NOT NULL,                
    PRIMARY KEY (ID_Ninja, Nombre),          
    FOREIGN KEY (ID_Ninja) REFERENCES Ninja(ID) ON DELETE CASCADE 
);



INSERT INTO Ninja (Nombre, Rango, Aldea)
VALUES 
    ('Sasuke ', 'Jonin', 'Konoha'),
    ('Sakura ', 'Jonin', 'Konoha'),
    ('Kakashi ', 'Jonin', 'Konoha'),
    ('Rock Lee', 'Jonin', 'Konoha');


INSERT INTO Mision (Descripcion, Rango, Recompensa)
VALUES 
    ('Rescate en la aldea', 'Jonin', 12000.00),
    ('Infiltración en territorio enemigo', 'Jonin', 15000.00),
    ('Asesinato de un objetivo objetivo', 'Jonin', 20000.00),
    ('Protección de un convoy', 'Chunin', 5000.00),
    ('Exploración de tierras desconocidas', 'Chunin', 7000.00);


INSERT INTO MisionNinja (ID_Ninja, ID_Mision, FechaInicio, FechaFin)
VALUES 
    (1, 2, '2024-12-01', '2024-12-10'),  
    (2, 1, '2024-12-05', '2024-12-15'),  
    (3, 3, '2024-12-10', '2024-12-20'),  
    (4, 4, '2024-12-15', '2024-12-25'), 
    (1, 5, '2024-12-01', '2024-12-07');  


INSERT INTO Habilidad (ID_Ninja, Nombre, Descripcion)
VALUES 
    (1, 'Kage Bunshin no Jutsu', 'Técnica de clonación que crea clones del ninja'),
    (2, 'Chidori', 'Técnica de ataque con energía de rayo concentrada'),
    (3, 'Kirin', 'Técnica de alto nivel utilizando un rayo de gran poder'),
    (4, 'Taijutsu', 'Estilo de lucha físico sin el uso de ninjutsu o genjutsu'),
    (5, 'Poder del Jutsu de la Roca', 'Técnica de lucha rápida y potente');





