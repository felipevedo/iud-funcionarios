package com.iudigital.cruddao.controller;

import com.iudigital.cruddao.dao.DatosPersonalesDao;
import com.iudigital.cruddao.dao.FuncionarioDao;
import com.iudigital.cruddao.dao.GradoAcademicoDao;
import com.iudigital.cruddao.dominio.DatosPersonales;
import com.iudigital.cruddao.dominio.Funcionario;
import com.iudigital.cruddao.dominio.FuncionarioDb;
import com.iudigital.cruddao.dominio.GradoAcademico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioDao funcionarioDao;
    private final DatosPersonalesDao datosPersonalesDao;
    private final GradoAcademicoDao gradoAcademicoDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();  
        datosPersonalesDao = new DatosPersonalesDao();
        gradoAcademicoDao = new GradoAcademicoDao();
    }
    
    public void crear(Funcionario funcionario) throws SQLException {
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setTipoIdentificacion(funcionario.getTipoIdentificacion());
        datosPersonales.setIdentificacion(funcionario.getIdentificacion());
        datosPersonales.setNombres(funcionario.getNombres());
        datosPersonales.setApellidos(funcionario.getApellidos());
        datosPersonales.setEstadoCivil(funcionario.getEstadoCivil());
        datosPersonales.setSexo(funcionario.getSexo());
        datosPersonales.setDireccion(funcionario.getDireccion());
        datosPersonales.setTelefono(funcionario.getTelefono());
        datosPersonales.setFechaNacimiento(funcionario.getFechaNacimiento());
        
        int idDatosPersonales = datosPersonalesDao.crear(datosPersonales);       
        
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setTituloGrado(funcionario.getTituloGrado());
        gradoAcademico.setNivelAcademico(funcionario.getNivelAcademico());
        gradoAcademico.setUniversidad(funcionario.getUniversidad());
        
        int idGradoAcademico = gradoAcademicoDao.crear(gradoAcademico);
        
        FuncionarioDb funcionarioDb = new FuncionarioDb();
        funcionarioDb.setIdDatosPersonales(idDatosPersonales);
        funcionarioDb.setIdGradoAcademico(idGradoAcademico);
        
        funcionarioDao.crear(funcionarioDb);
    }
    
    public List<Funcionario> obtener() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<FuncionarioDb> funcionariosDb = funcionarioDao.obtener();
        
        funcionariosDb.forEach((FuncionarioDb funcionarioDb) -> {
            try {
                int idFuncionario = funcionarioDb.getId();
                Funcionario funcionario = obtenerPorId(idFuncionario);
                
                funcionarios.add(funcionario);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        
        return funcionarios;
    }
    
    public Funcionario obtenerPorId(int id) throws SQLException {
        FuncionarioDb funcionarioDb = funcionarioDao.obtenerPorId(id);
        DatosPersonales datosPersonales = datosPersonalesDao.obtenerPorId(funcionarioDb.getIdDatosPersonales());
        GradoAcademico gradoAcademico = gradoAcademicoDao.obtenerPorId(funcionarioDb.getIdGradoAcademico());
        
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setTipoIdentificacion(datosPersonales.getTipoIdentificacion());
        funcionario.setIdentificacion(datosPersonales.getIdentificacion());
        funcionario.setNombres(datosPersonales.getNombres());
        funcionario.setApellidos(datosPersonales.getApellidos());
        funcionario.setEstadoCivil(datosPersonales.getEstadoCivil());
        funcionario.setSexo(datosPersonales.getSexo());
        funcionario.setDireccion(datosPersonales.getDireccion());
        funcionario.setTelefono(datosPersonales.getTelefono());
        funcionario.setFechaNacimiento(datosPersonales.getFechaNacimiento());
        funcionario.setTituloGrado(gradoAcademico.getTituloGrado());
        funcionario.setNivelAcademico(gradoAcademico.getNivelAcademico());
        funcionario.setUniversidad(gradoAcademico.getUniversidad());
        
        return funcionario;
    }
    
    public void actualizar(int id, Funcionario funcionario) throws SQLException {
        FuncionarioDb funcionarioDb = funcionarioDao.obtenerPorId(id);
        
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setTipoIdentificacion(funcionario.getTipoIdentificacion());
        datosPersonales.setIdentificacion(funcionario.getIdentificacion());
        datosPersonales.setNombres(funcionario.getNombres());
        datosPersonales.setApellidos(funcionario.getApellidos());
        datosPersonales.setEstadoCivil(funcionario.getEstadoCivil());
        datosPersonales.setSexo(funcionario.getSexo());
        datosPersonales.setDireccion(funcionario.getDireccion());
        datosPersonales.setTelefono(funcionario.getTelefono());
        datosPersonales.setFechaNacimiento(funcionario.getFechaNacimiento());
        datosPersonalesDao.actualizar(funcionarioDb.getIdDatosPersonales(), datosPersonales);
        
        GradoAcademico gradoAcademico = new GradoAcademico();
        gradoAcademico.setTituloGrado(funcionario.getTituloGrado());
        gradoAcademico.setNivelAcademico(funcionario.getNivelAcademico());
        gradoAcademico.setUniversidad(funcionario.getUniversidad());
        gradoAcademicoDao.actualizar(funcionarioDb.getIdGradoAcademico(), gradoAcademico);
        
    }
    
    public void eliminar(int id) throws SQLException {
        FuncionarioDb funcionarioDb = funcionarioDao.obtenerPorId(id);
        funcionarioDao.eliminar((id));
        datosPersonalesDao.eliminar(funcionarioDb.getIdDatosPersonales());
        gradoAcademicoDao.eliminar(funcionarioDb.getIdGradoAcademico());
    }
}
