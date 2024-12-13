
package com.mycompany.examenninjaalejo.Clases;

import java.util.ArrayList;



public class Mision {
    
    private Integer idMision;
    private String descripcion;
    private String rango; 
    private Double recompensa; 
    private ArrayList <Ninja> listaNinjas;
  

    public Mision() {
    }

    public Mision(String descripcion, String rango, Double recompensa) {
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
        this.listaNinjas = new ArrayList<>();
    }

    public Mision(Integer idMision, String descripcion, String rango, Double recompensa) {
        this.idMision = idMision;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
        this.listaNinjas = new ArrayList<>();
    }

    public Integer getIdMision() {
        return idMision;
    }

    public void setIdMision(Integer idMision) {
        this.idMision = idMision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public Double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    public ArrayList<Ninja> getListaNinjas() {
        return listaNinjas;
    }

    public void setListaNinjas(ArrayList<Ninja> listaNinjas) {
        this.listaNinjas = listaNinjas;
    }

    @Override
    public String toString() {
        return "Mision{" + "idMision=" + idMision + ", descripcion=" + descripcion + ", rango=" + rango + ", recompensa=" + recompensa + ", listaNinjas=" + listaNinjas + '}';
    }

  

    
    
    
    
    
}
