package com.iudigital.cruddao.presentacion;

import com.iudigital.cruddao.controller.FuncionarioController;
import com.iudigital.cruddao.dominio.Funcionario;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void imprimirFuncionarios(FuncionarioController funcionarioController){
        try {
            List<Funcionario> funcionarios = funcionarioController.obtener();
            
            System.out.println("printing funcionarios:");

            funcionarios.forEach(funcionario -> {
                System.out.println("========================:");
                System.out.println(funcionario.toString());
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void crearFuncionario(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite tipo de identificacion:");
            String tipoIdentificacion = sc.nextLine();
            System.out.println("tipo de identificacion es:" + tipoIdentificacion);
            System.out.println("-------------------");
            
            System.out.println("Digite identificacion:");
            String identificacion = sc.nextLine();
            System.out.println("identificacion es:" + identificacion);
            System.out.println("-------------------");
            
            System.out.println("Digite nombres:");
            String nombres = sc.nextLine();
            System.out.println("nombres es:" + nombres);
            System.out.println("-------------------");
            
            System.out.println("Digite apellidos:");
            String apellidos = sc.nextLine();
            System.out.println("apellidos es:" + apellidos);
            System.out.println("-------------------");
            
            System.out.println("Digite estado civil:");
            String estadoCivil = sc.nextLine();
            System.out.println("estado civil es:" + estadoCivil);
            System.out.println("-------------------");
            
            System.out.println("Digite sexo:");
            String sexo = sc.nextLine();
            System.out.println("sexo es:" + sexo);
            System.out.println("-------------------");
            
            System.out.println("Digite direccion:");
            String direccion = sc.nextLine();
            System.out.println("direccion es:" + direccion);
            System.out.println("-------------------");
            
            System.out.println("Digite telefono:");
            String telefono = sc.nextLine();
            System.out.println("telefono es:" + telefono);
            System.out.println("-------------------");
            
            System.out.println("Digite fecha de nacimiento en el formato YYYY-MM-DD:");
            String sFechaNacimiento = sc.nextLine();
            Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(sFechaNacimiento);
            System.out.println("fecha de nacimiento es:" + sFechaNacimiento);
            System.out.println("-------------------");
            
            System.out.println("Digite titulo academico:");
            String tituloGrado = sc.nextLine();
            System.out.println("titulo academico es:" + tituloGrado);
            System.out.println("-------------------");
            
            System.out.println("Digite nivel academico:");
            String nivelAcademico = sc.nextLine();
            System.out.println("nivel academico es:" + nivelAcademico);
            System.out.println("-------------------");
            
            System.out.println("Digite universidad:");
            String universidad = sc.nextLine();
            System.out.println("universidad es:" + universidad);
            System.out.println("-------------------");
            
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(tipoIdentificacion);
            funcionario.setIdentificacion(identificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadoCivil(estadoCivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionario.setTituloGrado(tituloGrado);
            funcionario.setNivelAcademico(nivelAcademico);
            funcionario.setUniversidad(universidad);
            
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado con exito:");
            
            imprimirFuncionarios(funcionarioController);
        } catch (SQLException|ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        
        //imprimirFuncionarios(funcionarioController);
        crearFuncionario(funcionarioController);
    }
}
