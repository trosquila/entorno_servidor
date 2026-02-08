package com.daw.onepiece.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Recompensa")
public class RecompensaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private PirataEntity pirata;
    
    @Column(name = "cantidad", precision = 20, scale = 2)
    private BigDecimal cantidad;
    
    @Column(name = "estavigente")
    private Boolean estaVigente;

    public RecompensaEntity() {
    }

    public RecompensaEntity(Integer id, PirataEntity pirata, BigDecimal cantidad, Boolean estaVigente) {
        this.id = id;
        this.pirata = pirata;
        this.cantidad = cantidad;
        this.estaVigente = estaVigente;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PirataEntity getPirata() {
        return pirata;
    }

    public void setPirata(PirataEntity pirata) {
        this.pirata = pirata;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstaVigente() {
        return estaVigente;
    }

    public void setEstaVigente(Boolean estaVigente) {
        this.estaVigente = estaVigente;
    }
}