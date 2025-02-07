package com.sistema.intranet.models.IdClasses;

import java.io.Serializable;
import java.util.Objects;

public class TbAlumnoCarreraId implements Serializable {

    private String alumno;
    private String carrera;
    private String especialidad;

    public TbAlumnoCarreraId() {}

    public TbAlumnoCarreraId(String alumno, String carrera, String especialidad, Integer curricula) {
        this.alumno = alumno;
        this.carrera = carrera;
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAlumnoCarreraId that = (TbAlumnoCarreraId) o;
        return Objects.equals(alumno, that.alumno) &&
                Objects.equals(carrera, that.carrera) &&
                Objects.equals(especialidad, that.especialidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumno, carrera, especialidad);
    }
}
