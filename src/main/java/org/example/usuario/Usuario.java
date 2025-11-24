package org.example.usuario;

import java.sql.Time;
import java.time.LocalDate;

public class Usuario {
    private int id;
    private String correo;
    private String plataforma;
    private boolean rol;
    private String version;
    private LocalDate fecha;

    public Usuario(Integer id,String correo, String plataforma, Boolean rol, String version, LocalDate fecha) {
        setId(id);
        setCorreo(correo);
        setPlataforma(plataforma);
        setRol(rol);
        setVersion(version);
        setFecha(fecha);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
