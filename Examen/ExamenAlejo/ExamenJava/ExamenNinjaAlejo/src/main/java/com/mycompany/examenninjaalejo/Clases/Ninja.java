
package com.mycompany.examenninjaalejo.Clases;


public class Ninja {
    private int idNinja;
    private String nombre;
    private String rango;
    private String aldea;

    public Ninja() {
    }

    public Ninja(String nombre, String rango, String aldea) {
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public Ninja(int idNinja, String nombre, String rango, String aldea) {
        this.idNinja = idNinja;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public int getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    @Override
    public String toString() {
        return "Ninja{" + "idNinja=" + idNinja + ", nombre=" + nombre + ", rango=" + rango + ", aldea=" + aldea + '}';
    }
    
    
    
    
    
    
           
    
    
}
