
package com.mycompany.examenninjaalejo.Clases;


public class Habilidad {
    
    private Integer id_Ninja;
    private String Nombre;
    private String descripcion;

    public Habilidad() {
    }



    public Habilidad(Integer id_Ninja, String Nombre, String descripcion) {
        this.id_Ninja = id_Ninja;
        this.Nombre = Nombre;
        this.descripcion = descripcion;
    }

    public Integer getId_Ninja() {
        return id_Ninja;
    }

    public void setId_Ninja(Integer id_Ninja) {
        this.id_Ninja = id_Ninja;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habilidad{" + "id_Ninja=" + id_Ninja + ", Nombre=" + Nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
    
    
}
