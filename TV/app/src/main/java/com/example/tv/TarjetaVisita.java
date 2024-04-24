package com.example.tv;

import java.io.Serializable;

public class TarjetaVisita implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String puesto;
    private final String telefono;
    private final String correo;
    private final String direccion;

    public TarjetaVisita(String nombre, String apellido, String puesto, String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }


}