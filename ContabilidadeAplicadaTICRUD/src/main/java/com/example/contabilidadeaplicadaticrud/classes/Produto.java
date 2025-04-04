package com.example.contabilidadeaplicadaticrud.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    private int codigo;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private int quantidade;
    private double icms;

    public double getCreditoIcms() {
        return this.precoDeCompra * (this.icms / 100.0);
    }

    public double getDebitoIcms() {
        return this.precoDeVenda * (this.icms / 100.0);
    }

    public double calcularCusto() {
        return this.precoDeCompra - this.getCreditoIcms();
    }
}
