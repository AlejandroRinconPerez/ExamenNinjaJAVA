
package com.mycompany.examenninjaalejo.Clases;

import java.time.LocalDate;


public class MisionNinja {
    
    
    private Integer IdNinja;
    private Integer IdMision;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;

    public MisionNinja() {
    }

    public MisionNinja(Integer IdMision, LocalDate FechaInicio, LocalDate FechaFin) {
        this.IdMision = IdMision;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public MisionNinja(Integer IdNinja, Integer IdMision, LocalDate FechaInicio, LocalDate FechaFin) {
        this.IdNinja = IdNinja;
        this.IdMision = IdMision;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public Integer getIdNinja() {
        return IdNinja;
    }

    public void setIdNinja(Integer IdNinja) {
        this.IdNinja = IdNinja;
    }

    public Integer getIdMision() {
        return IdMision;
    }

    public void setIdMision(Integer IdMision) {
        this.IdMision = IdMision;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    
    
    
            
  
    
    
    
}
