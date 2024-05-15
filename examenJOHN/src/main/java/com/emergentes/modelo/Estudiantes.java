
package com.emergentes.modelo;

public class Estudiantes {
    private int id;
    private String nombre;
    private String apellido;
    private String seminario;
    private String confirmado;
    private String fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Aviso{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", seminario=" + seminario + ","
                + " confirmado=" + confirmado + ", fecha=" + fecha + '}';
    }
    
    

    
    
}
