package br.edu.ifsp.demo_clean.model;

import br.edu.ifsp.demo_clean.DTOs.CustomerDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Código único do cliente", example = "1")
    private int code;

    @Column(nullable = false)
    @Schema(description = "Nome do cliente", example = "João Silva")
    private String name;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Customer fromDTO(CustomerDTO dto) {
        return new Customer(dto.name());
    }

}
