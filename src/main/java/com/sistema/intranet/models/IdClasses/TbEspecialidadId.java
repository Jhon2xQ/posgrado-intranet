package com.sistema.intranet.models.IdClasses;

import java.io.Serializable;
import java.util.Objects;

public class TbEspecialidadId implements Serializable {
    private String especialidad;
    private String carrera;

    public TbEspecialidadId() {}

    public TbEspecialidadId(String especialidad, String carrera) {
        this.especialidad = especialidad;
        this.carrera = carrera;
    }

    // Getters, Setters, hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbEspecialidadId that = (TbEspecialidadId) o;
        return Objects.equals(especialidad, that.especialidad) &&
                Objects.equals(carrera, that.carrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(especialidad, carrera);
    }
}
