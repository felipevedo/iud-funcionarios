package com.iudigital.cruddao.dao;

import com.iudigital.cruddao.dominio.FuncionarioDb;
import com.iudigital.cruddao.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private static final String GET_FUNCIONARIOS = "SELECT * FROM funcionarios";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE id = ?";
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios (id_datos_personales, id_grado_academico) VALUES (?, ?);";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET id_datos_personales = ?, id_grado_academico = ? WHERE id = ?";
    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE id = ?";
    
    public void crear(FuncionarioDb funcionarioDb) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionarioDb.getIdDatosPersonales());
            preparedStatement.setInt(2, funcionarioDb.getIdGradoAcademico());

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
    
    public List<FuncionarioDb> obtener() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<FuncionarioDb> funcionariosDb = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_FUNCIONARIOS);
            
            while (resultSet.next()) {
                FuncionarioDb funcionarioDb = new FuncionarioDb();
                funcionarioDb.setId(resultSet.getInt("id"));
                funcionarioDb.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));
                funcionarioDb.setIdGradoAcademico(resultSet.getInt("id_grado_academico"));
                funcionariosDb.add(funcionarioDb);
            }
            
            return funcionariosDb;
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
    
    public FuncionarioDb obtenerPorId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        FuncionarioDb funcionarioDb = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                funcionarioDb = new FuncionarioDb();
                funcionarioDb.setId(resultSet.getInt("id"));
                funcionarioDb.setIdDatosPersonales(resultSet.getInt("id_datos_personales"));
                funcionarioDb.setIdGradoAcademico(resultSet.getInt("id_grado_academico")); 
            }
            
            return funcionarioDb;
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
    
    public void actualizar(int id, FuncionarioDb funcionarioDb) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            
            preparedStatement.setInt(1, funcionarioDb.getIdDatosPersonales());
            preparedStatement.setInt(2, funcionarioDb.getIdGradoAcademico());
            preparedStatement.setInt(3, funcionarioDb.getId());
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
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
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
