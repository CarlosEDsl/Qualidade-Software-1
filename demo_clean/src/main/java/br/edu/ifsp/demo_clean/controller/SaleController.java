package br.edu.ifsp.demo_clean.controller;

import br.edu.ifsp.demo_clean.DTOs.SaleDTO;
import br.edu.ifsp.demo_clean.model.Sale;
import br.edu.ifsp.demo_clean.service.SaleService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sales")
@Schema(title = "Rota de vendas")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO sale) {
        Sale saved = saleService.createSale(sale);
        URI location = URI.create("/sales/" + saved.getCode());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }
}
