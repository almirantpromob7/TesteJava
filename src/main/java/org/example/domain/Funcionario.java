package org.example.domain;
import java.time.LocalDate;

public class Funcionario {
    private String nome;
    private Cargo cargo;
    private LocalDate dataContratacao;

    public Funcionario(String nome, Cargo cargo, LocalDate dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public double calcularSalario(int mes, int ano) {
        return cargo.calcularSalario(this, mes, ano);
    }

    public double calcularBeneficios(int mes, int ano) {
        return cargo.calcularBeneficios(this, mes, ano);
    }
}