package org.example.domain;

public interface Cargo {
    double calcularSalario(Funcionario funcionario, int mes, int ano);
    double calcularBeneficios(Funcionario funcionario, int mes, int ano);
}
