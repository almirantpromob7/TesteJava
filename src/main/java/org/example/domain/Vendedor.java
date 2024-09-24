package org.example.domain;

import java.util.Map;

public class Vendedor implements Cargo{
    private static final double SALARIO_BASE = 12000;
    private static final double BONUS_ANUAL = 1800;
    private static final double PERCENTUAL_COMISSAO = 0.30;

    private Map<String, Double> vendas; // Exemplo: {"12/2021": 5000, "01/2022": 7000}

    public Vendedor(Map<String, Double> vendas) {
        this.vendas = vendas;
    }


    public double calcularSalario(Funcionario funcionario, int mes, int ano) {
        int anosDeServico = ano - funcionario.getDataContratacao().getYear();
        return SALARIO_BASE + (BONUS_ANUAL * anosDeServico);
    }


    public double calcularBeneficios(Funcionario funcionario, int mes, int ano) {
        String mesAno = String.format("%02d/%d", mes, ano);
        double valorVendas = vendas.getOrDefault(mesAno, 0.0);
        return valorVendas * PERCENTUAL_COMISSAO;
    }

    public double getValorVendas(int mes, int ano) {
        String mesAno = String.format("%02d/%d", mes, ano);
        return vendas.getOrDefault(mesAno, 0.0);
    }
}
