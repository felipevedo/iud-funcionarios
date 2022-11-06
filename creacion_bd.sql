CREATE DATABASE funcionarios_iud;

CREATE TABLE datos_personales (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_identificacion VARCHAR(255) NOT NULL,
  identificacion VARCHAR(255) NOT NULL,
  nombres VARCHAR(255) NOT NULL,
  apellidos VARCHAR(255) NOT NULL,
  estado_civil VARCHAR(255) NOT NULL,
  sexo CHAR(1) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE grados_academicos (
  id INT NOT NULL AUTO_INCREMENT,
  titulo_grado VARCHAR(255) NOT NULL,
  nivel_academico VARCHAR(255) NOT NULL,
  universidad VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE funcionarios (
  id INT NOT NULL AUTO_INCREMENT,
  id_datos_personales INT NOT NULL,
  id_grado_academico INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_datos_personales) REFERENCES datos_personales (id),
  FOREIGN KEY (id_grado_academico) REFERENCES grados_academicos (id)
);

CREATE TABLE funcionarios_familiares (
  id_funcionario INT NOT NULL,
  id_familiar INT NOT NULL,
  rol VARCHAR(255) NOT NULL,
  FOREIGN KEY (id_funcionario) REFERENCES funcionarios (id),
  FOREIGN KEY (id_familiar) REFERENCES datos_personales (id)
);