package com.sistema.intranet.models.IdClasses;

import java.io.Serializable;
import java.util.Objects;

public class TbAlumnoCarreraId implements Serializable {

    private String alumno; // ID de TbAlumno
    private String carrera; // ID de TbCarrera

    public TbAlumnoCarreraId() {
    }

    public TbAlumnoCarreraId(String alumno, String carrera) {
        this.alumno = alumno;
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAlumnoCarreraId that = (TbAlumnoCarreraId) o;
        return Objects.equals(alumno, that.alumno) &&
                Objects.equals(carrera, that.carrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumno, carrera);
    }
}
