package br.edu.ifsp.demo_clean.model;

import br.edu.ifsp.demo_clean.DTOs.SaleDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Código único da venda", example = "1")
    private int code;

    @ManyToOne
    @JsonBackReference
    @Schema(description = "Cliente comprador da venda")
    private Customer buyer;

    @ManyToOne
    @JsonBackReference
    @Schema(description = "Carro vendido")
    private Car car;

    @Column
    @Schema(description = "Data da venda", example = "2025-09-02")
    private LocalDate saleDateTime;

    public Sale(){}

    public Sale(Customer buyer, Car car, LocalDate saleDateTime) {
        this.buyer = buyer;
        this.car = car;
        this.saleDateTime = saleDateTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getData() {
        return saleDateTime;
    }

    public void setSaleDateTime(LocalDate data) {
        this.saleDateTime = data;
    }

    public static Sale fromDTO(SaleDTO dto, Customer buyer, Car car) {
        return new Sale(
                buyer,
                car,
                dto.saleDateTime()
        );
    }
}