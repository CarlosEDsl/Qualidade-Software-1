package br.edu.ifsp.demo_clean.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Representação de um carro")
public record CarDTO(
        @Schema(description = "Código único do carro", example = "1") int code,
        @Schema(description = "Nome do carro", example = "Fiat Uno") String nome,
        @Schema(description = "Cor do carro", example = "Vermelho") String color,
        @Schema(description = "Valor do carro", example = "45000.50") double value
) {}