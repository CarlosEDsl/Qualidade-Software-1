package br.edu.ifsp.demo_clean.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representação de um cliente")
public record CustomerDTO(
        @Schema(description = "Código único do cliente", example = "1") int code,
        @Schema(description = "Nome do cliente", example = "João Silva") String name
) {}
