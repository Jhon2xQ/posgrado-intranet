package com.sistema.intranet.config;

import com.sistema.intranet.dtos.*;
import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private ModelMapper mapperToPersona(ModelMapper modelMapper) {
        modelMapper.typeMap(TbPersona.class, PersonaDto.class);
        return modelMapper;
    }

    private ModelMapper mapperToCarrera(ModelMapper modelMapper) {
        modelMapper.typeMap(TbCarrera.class, CarreraDto.class);
        return modelMapper;
    }

    private ModelMapper mapperToEspecialidad(ModelMapper modelMapper) {
        modelMapper.typeMap(TbEspecialidad.class, EspecialidadDto.class);
        return modelMapper;
    }

    private ModelMapper mapperToCurricula(ModelMapper modelMapper) {
        modelMapper.typeMap(TbCurricula.class, CurriculaDto.class);
        return modelMapper;
    }

    private ModelMapper mapperToPagoDetalle(ModelMapper modelMapper) {
        modelMapper.typeMap(TbPagoDetalle.class, PagoDetalleDto.class);
        return modelMapper;
    }

    private ModelMapper mapperToNota(ModelMapper modelMapper) {
        modelMapper.typeMap(TbNota.class, NotasCompletoDto.class);
        return modelMapper;
    }
    private ModelMapper mapperToCurriculaCurso(ModelMapper modelMapper) {
        modelMapper.typeMap(TbCurriculaCurso.class, CurriculaCursoDto.class);
        return modelMapper;
    }

    @Bean("personaMapper")
    public ModelMapper PersonaModelMapper() {
        return mapperToPersona(this.modelMapper());
    }

    @Bean("carreraMapper")
    public ModelMapper CarreraModelMapper() {
        return mapperToCarrera(this.modelMapper());
    }

    @Bean("especialidadMapper")
    public ModelMapper EspecialidadModelMapper() {
        return mapperToEspecialidad(this.modelMapper());
    }

    @Bean("curriculaMapper")
    public ModelMapper CurriculaModelMapper() {
        return mapperToCurricula(this.modelMapper());
    }

    @Bean("pagoDetalleMapper")
    public ModelMapper PagoDetalleModelMapper() {
        return mapperToPagoDetalle(this.modelMapper());
    }

    @Bean("notaMapper")
    public ModelMapper NotaModelMapper() {
        return mapperToNota(this.modelMapper());
    }

    @Bean("curriculaCursoMapper")
    public ModelMapper CurriculaCursoModelMapper() {
        return mapperToCurriculaCurso(this.modelMapper());
    }
}
