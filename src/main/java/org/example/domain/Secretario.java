package org.example.domain;

public class Secretario implements Cargo{
    private static final double SALARIO_BASE = 7000;
    private static final double BONUS_ANUAL = 1000;
    private static final double PERCENTUAL_BENEFICIOS = 0.20;


    public double calcularSalario(Funcionario funcionario, int mes, int ano) {
        int anosDeServico = ano - funcionario.getDataContratacao().getYear();
        return SALARIO_BASE + (BONUS_ANUAL * anosDeServico);
    }

    public double calcularBeneficios(Funcionario funcionario, int mes, int ano) {
        return calcularSalario(funcionario, mes, ano) * PERCENTUAL_BENEFICIOS;
    }
}
