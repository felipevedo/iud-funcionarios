package com.iudigital.cruddao.dao;

import com.iudigital.cruddao.dominio.DatosPersonales;
import com.iudigital.cruddao.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatosPersonalesDao {
    private static final String GET_DATOS_PERSONALES = "SELECT * FROM datos_personales";
    private static final String GET_DATOS_PERSONALES_BY_ID = "SELECT * FROM datos_personales WHERE id = ?";
    private static final String CREATE_DATOS_PERSONALES = "INSERT INTO datos_personales (tipo_identificacion, identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_DATOS_PERSONALES =
            """
            UPDATE datos_personales
            SET tipo_identificacion = ?,
                identificacion = ?,
                nombres = ?,
                apellidos = ?,
                estado_civil = ?,
                sexo = ?,
                direccion = ?,
                telefono = ?,
                fecha_nacimiento = ?
            WHERE id = ?
            """;
    private static final String DELETE_DATOS_PERSONALES = "DELETE FROM datos_personales WHERE id = ?";
    
    public int crear(DatosPersonales datosPersonales) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_DATOS_PERSONALES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, datosPersonales.getTipoIdentificacion());
            preparedStatement.setString(2, datosPersonales.getIdentificacion());
            preparedStatement.setString(3, datosPersonales.getNombres());
            preparedStatement.setString(4, datosPersonales.getApellidos());
            preparedStatement.setString(5, datosPersonales.getEstadoCivil());
            preparedStatement.setString(6, datosPersonales.getSexo());
            preparedStatement.setString(7, datosPersonales.getDireccion());
            preparedStatement.setString(8, datosPersonales.getTelefono());
            Date fechaNamcimiento = new Date(datosPersonales.getFechaNacimiento().getTime());
            preparedStatement.setDate(9, fechaNamcimiento);
            preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return (int) generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }   
        }
    }
    
    public List<DatosPersonales> obtener() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DatosPersonales> listaDatosPersonales = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_DATOS_PERSONALES);
            
            while (resultSet.next()) {
                DatosPersonales datosPersonales = new DatosPersonales();
                datosPersonales.setId(resultSet.getInt("id"));
                datosPersonales.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                datosPersonales.setIdentificacion(resultSet.getString("identificacion"));
                datosPersonales.setNombres(resultSet.getString("nombres"));
                datosPersonales.setApellidos(resultSet.getString("apellidos"));
                datosPersonales.setEstadoCivil(resultSet.getString("estado_civil"));
                datosPersonales.setSexo(resultSet.getString("sexo"));
                datosPersonales.setDireccion(resultSet.getString("direccion"));
                datosPersonales.setTelefono(resultSet.getString("telefono"));
                datosPersonales.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                listaDatosPersonales.add(datosPersonales);
            }
            
            return listaDatosPersonales;
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public DatosPersonales obtenerPorId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DatosPersonales datosPersonales = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_DATOS_PERSONALES_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                datosPersonales = new DatosPersonales();
                datosPersonales.setId(resultSet.getInt("id"));
                datosPersonales.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                datosPersonales.setIdentificacion(resultSet.getString("identificacion"));
                datosPersonales.setNombres(resultSet.getString("nombres"));
                datosPersonales.setApellidos(resultSet.getString("apellidos"));
                datosPersonales.setEstadoCivil(resultSet.getString("estado_civil"));
                datosPersonales.setSexo(resultSet.getString("sexo"));
                datosPersonales.setDireccion(resultSet.getString("direccion"));
                datosPersonales.setTelefono(resultSet.getString("telefono"));
                datosPersonales.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
            }
            
            return datosPersonales;
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void actualizar(int id, DatosPersonales datosPersonales) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_DATOS_PERSONALES);
            
            preparedStatement.setString(1, datosPersonales.getTipoIdentificacion());
            preparedStatement.setString(2, datosPersonales.getIdentificacion());
            preparedStatement.setString(3, datosPersonales.getNombres());
            preparedStatement.setString(4, datosPersonales.getApellidos());
            preparedStatement.setString(5, datosPersonales.getEstadoCivil());
            preparedStatement.setString(6, datosPersonales.getSexo());
            preparedStatement.setString(7, datosPersonales.getDireccion());
            preparedStatement.setString(8, datosPersonales.getTelefono());
            Date fechaNamcimiento = new Date(datosPersonales.getFechaNacimiento().getTime());
            preparedStatement.setDate(9, fechaNamcimiento);
            preparedStatement.setInt(10, id);
            preparedStatement.executeLargeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminar(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_DATOS_PERSONALES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            } 
        }
    }
}
