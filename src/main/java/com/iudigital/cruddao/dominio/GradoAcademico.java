package com.iudigital.cruddao.dominio;

public class GradoAcademico {
    private int id;
    private String tituloGrado;
    private String nivelAcademico;
    private String universidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloGrado() {
        return tituloGrado;
    }

    public void setTituloGrado(String tituloGrado) {
        this.tituloGrado = tituloGrado;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
}
