package br.edu.ifsp.demo_clean.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Representação de uma venda")
public record SaleDTO(
        @Schema(description = "Código único da venda", example = "1") int code,
        @Schema(description = "Código do cliente comprador", example = "1") int buyerCode,
        @Schema(description = "Código do carro vendido", example = "1") int carCode,
        @Schema(description = "Data da venda", example = "2025-09-02") LocalDate saleDateTime
) {}
