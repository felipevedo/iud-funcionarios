-- funcionario 1
INSERT INTO datos_personales (
  tipo_identificacion,
  identificacion,
  nombres,
  apellidos,
  estado_civil,
  sexo,
  direccion,
  telefono,
  fecha_nacimiento
) VALUES (
  'Cedula de ciudadania',
  '10235793',
  'Carlos Mario',
  'Hernandez',
  'Soltero',
  'M',
  'Cl 164 No. 95-31',
  '300852456',
  '1975-09-14'
);

SET @id_datos_funcionario = LAST_INSERT_ID();

INSERT INTO grados_academicos (
  titulo_grado,
  nivel_academico,
  universidad
) VALUES (
  'Tecnico en sistemas',
  'Tecnico',
  'Universidad Industrial de Santander'
);

INSERT INTO funcionarios (id_datos_personales, id_grado_academico) VALUES (@id_datos_funcionario, LAST_INSERT_ID());

-- familiar
SET @id_funcionario = LAST_INSERT_ID();

INSERT INTO datos_personales (
  tipo_identificacion,
  identificacion,
  nombres,
  apellidos,
  estado_civil,
  sexo,
  direccion,
  telefono,
  fecha_nacimiento
) VALUES (
  'Tarjeta de identidad',
  '7125468',
  'Carolina',
  'Hernandez',
  'Soltero',
  'F',
  'Cl 164 No. 95-31',
  '300852456',
  '2012-02-21'
);

INSERT INTO funcionarios_familiares (
  id_funcionario,
  id_familiar,
  rol
) VALUES (
  @id_funcionario,
  LAST_INSERT_ID(),
  'Hijo'
);

-- funcionario 2
INSERT INTO datos_personales (
  tipo_identificacion,
  identificacion,
  nombres,
  apellidos,
  estado_civil,
  sexo,
  direccion,
  telefono,
  fecha_nacimiento
) VALUES (
  'Cedula de ciudadania',
  '1015225203',
  'Fabio',
  'Jimenez',
  'Casado',
  'M',
  'Av 4 Norte No. 49-150',
  '316524686',
  '1984-07-02'
);

SET @id_datos_funcionario = LAST_INSERT_ID();

INSERT INTO grados_academicos (
  titulo_grado,
  nivel_academico,
  universidad
) VALUES (
  'Administracion de empresas',
  'Profesional',
  'Universidad Eafit'
);

INSERT INTO funcionarios (id_datos_personales, id_grado_academico) VALUES (@id_datos_funcionario, LAST_INSERT_ID());

-- familiar
SET @id_funcionario = LAST_INSERT_ID();

INSERT INTO datos_personales (
  tipo_identificacion,
  identificacion,
  nombres,
  apellidos,
  estado_civil,
  sexo,
  direccion,
  telefono,
  fecha_nacimiento
) VALUES (
  'Cedula de ciudadania',
  '1025864532',
  'Maria Camila',
  'Soto',
  'Casado',
  'F',
  'Av 4 Norte No. 49-150',
  '3020356745',
  '1990-05-24'
);

INSERT INTO funcionarios_familiares (
  id_funcionario,
  id_familiar,
  rol
) VALUES (
  @id_funcionario,
  LAST_INSERT_ID(),
  'Conyuge'
);