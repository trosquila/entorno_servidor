package com.daw.onepiece.dtos;

import com.daw.onepiece.entities.IslaEntity;

public class IslaDTO {
    private Integer id;
    private String nombre;

    public IslaDTO() {}

    public IslaDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static IslaDTO fromEntity(IslaEntity e) {
        if (e == null) return null;
        return new IslaDTO(e.getId(), e.getNombre());
    }

    public IslaEntity toEntity() {
        IslaEntity e = new IslaEntity();
        e.setId(this.id);
        e.setNombre(this.nombre);
        return e;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

