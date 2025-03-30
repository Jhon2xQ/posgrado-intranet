package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.NotaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotasCompletoDto {
    private List<NotaDto> notas;
    private List<String> semestres;
    private Integer totalCreditos;
}
