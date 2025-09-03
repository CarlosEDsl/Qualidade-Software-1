package br.edu.ifsp.demo_clean.model;

import br.edu.ifsp.demo_clean.DTOs.CarDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Código único do carro", example = "1")
    private int code;

    @Column(nullable = false)
    @Schema(description = "Nome do carro", example = "Fiat Uno")
    private String nome;

    @Column
    @Schema(description = "Cor do carro", example = "Vermelho")
    private String color;

    @Column(nullable = false)
    @Schema(description = "Valor do carro", example = "45000.50")
    private double value;

    public Car() {}

    public Car(String name, String color, double value){
        this.nome = name;
        this.color = color;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static Car fromDTO(CarDTO dto) {
        return new Car(
                dto.nome(),
                dto.color(),
                dto.value()
        );
    }

}

