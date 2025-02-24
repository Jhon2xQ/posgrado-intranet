package com.sistema.intranet.services;

import com.sistema.intranet.repositories.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotaService {

    private final NotaRepository notaRepository;
}
