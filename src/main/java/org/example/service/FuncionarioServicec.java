package org.example.service;

import org.example.domain.Funcionario;
import org.example.domain.Vendedor;

import java.util.List;

public class FuncionarioServicec {
    public double calcularTotalPago(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .mapToDouble(f -> f.calcularSalario(mes, ano) + f.calcularBeneficios(mes, ano))
                .sum();
    }

    public double calcularTotalSalarios(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .mapToDouble(f -> f.calcularSalario(mes, ano))
                .sum();
    }
    public double calcularTotalBeneficios(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .filter(f -> f.calcularBeneficios(mes, ano) > 0)
                .mapToDouble(f -> f.calcularBeneficios(mes, ano))
                .sum();
    }

    public Funcionario maiorPagamento(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .max((f1, f2) -> Double.compare(
                        f1.calcularSalario(mes, ano) + f1.calcularBeneficios(mes, ano),
                        f2.calcularSalario(mes, ano) + f2.calcularBeneficios(mes, ano)
                ))
                .orElse(null);
    }

    public Funcionario maiorBeneficio(List<Funcionario> funcionarios, int mes, int ano) {
        return funcionarios.stream()
                .filter(f -> f.calcularBeneficios(mes, ano) > 0)
                .max((f1, f2) -> Double.compare(f1.calcularBeneficios(mes, ano), f2.calcularBeneficios(mes, ano)))
                .orElse(null);
    }

    public Vendedor melhorVendedor(List<Vendedor> vendedores, int mes, int ano) {
        return vendedores.stream()
                .max((v1, v2) -> Double.compare(v1.getValorVendas(mes, ano), v2.getValorVendas(mes, ano)))
                .orElse(null);
    }
}
