package com.iudigital.cruddao.dao;

import com.iudigital.cruddao.dominio.GradoAcademico;
import com.iudigital.cruddao.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradoAcademicoDao {
    private static final String GET_GRADO_ACADEMICO = "SELECT * FROM grados_academicos";
    private static final String GET_GRADO_ACADEMICO_BY_ID = "SELECT * FROM grados_academicos WHERE id = ?";
    private static final String CREATE_GRADO_ACADEMICO = "INSERT INTO grados_academicos (titulo_grado, nivel_academico, universidad) VALUES (?, ?, ?);";
    private static final String UPDATE_GRADO_ACADEMICO = "UPDATE grados_academicos SET titulo_grado = ?, nivel_academico = ?, universidad = ? WHERE id = ?;";
    private static final String DELETE_GRADO_ACADEMICO = "DELETE FROM grados_academicos WHERE id = ?";
    
    public int crear(GradoAcademico gradoAcademico) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_GRADO_ACADEMICO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, gradoAcademico.getTituloGrado());
            preparedStatement.setString(2, gradoAcademico.getNivelAcademico());
            preparedStatement.setString(3, gradoAcademico.getUniversidad());
            preparedStatement.executeLargeUpdate();
            
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
    
    public List<GradoAcademico> obtener() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GradoAcademico> gradosAcademicos = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_GRADO_ACADEMICO);
            
            while (resultSet.next()) {
                GradoAcademico gradoAcademico = new GradoAcademico();

                gradoAcademico.setId(resultSet.getInt("id"));
                gradoAcademico.setTituloGrado(resultSet.getString("titulo_grado"));
                gradoAcademico.setNivelAcademico(resultSet.getString("nivel_academico"));
                gradoAcademico.setUniversidad(resultSet.getString("universidad"));

                gradosAcademicos.add(gradoAcademico);
            }
            
            return gradosAcademicos;
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
    
    public GradoAcademico obtenerPorId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GradoAcademico gradoAcademico = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_GRADO_ACADEMICO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                gradoAcademico = new GradoAcademico();
                gradoAcademico.setId(resultSet.getInt("id"));
                gradoAcademico.setTituloGrado(resultSet.getString("titulo_grado"));
                gradoAcademico.setNivelAcademico(resultSet.getString("nivel_academico"));
                gradoAcademico.setUniversidad(resultSet.getString("universidad"));
            }
            
            return gradoAcademico;
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
    
    public void actualizar(int id, GradoAcademico gradoAcademico) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();

            preparedStatement = connection.prepareStatement(UPDATE_GRADO_ACADEMICO);
            preparedStatement.setString(1, gradoAcademico.getTituloGrado());
            preparedStatement.setString(2, gradoAcademico.getNivelAcademico());
            preparedStatement.setString(3, gradoAcademico.getUniversidad());
            preparedStatement.setInt(4, id);
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
            preparedStatement = connection.prepareStatement(DELETE_GRADO_ACADEMICO);
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
