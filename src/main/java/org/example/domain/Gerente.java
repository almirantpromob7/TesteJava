package org.example.domain;

public class Gerente implements Cargo{
    private static final double SALARIO_BASE = 20000;
    private static final double BONUS_ANUAL = 3000;


    public double calcularSalario(Funcionario funcionario, int mes, int ano) {
        int anosDeServico = ano - funcionario.getDataContratacao().getYear();
        return SALARIO_BASE + (BONUS_ANUAL * anosDeServico);
    }

    public double calcularBeneficios(Funcionario funcionario, int mes, int ano) {
        return 0;
    }
}
