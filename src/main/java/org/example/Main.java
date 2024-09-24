package org.example;

import org.example.domain.Funcionario;
import org.example.domain.Gerente;
import org.example.domain.Secretario;
import org.example.domain.Vendedor;
import org.example.service.FuncionarioServicec;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static FuncionarioServicec servicec = new FuncionarioServicec();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Jorge Carvalho", new Secretario(), LocalDate.of(2018, 1, 1)));
        funcionarios.add(new Funcionario("Maria Souza", new Secretario(), LocalDate.of(2015, 12, 1)));
        Map<String, Double> vendasAna = new HashMap<>();
        vendasAna.put("12/2021", 5000.0);
        funcionarios.add(new Funcionario("Ana Silva", new Vendedor(vendasAna), LocalDate.of(2021, 12, 1)));
        Map<String, Double> vendasJoao = new HashMap<>();
        vendasJoao.put("12/2021", 7000.0);
        funcionarios.add(new Funcionario("João Mendes", new Vendedor(vendasJoao), LocalDate.of(2021, 12, 1)));
        funcionarios.add(new Funcionario("Juliana Alves", new Gerente(), LocalDate.of(2017, 7, 1)));
        funcionarios.add(new Funcionario("Bento Albino", new Gerente(), LocalDate.of(2014, 3, 1)));

        do {
            System.out.println("Escolha uma Opção");
            System.out.println("1 - Retorna o valor total\n" +
                    "pago (salário e benefício) a esses funcionários no mês.");
            System.out.println("2 - Retorna o total pago\n" +
                    "somente em salários no mês.");
            System.out.println("3 - Retorna o total pago em benefícios no mês.");
            System.out.println("4 - Retorna o que\n" +
                    "recebeu o valor mais alto no mês.");
            System.out.println("5 -  Retorna o nome do funcionário que recebeu o valor mais\n" +
                    "alto em benefícios no mês.");
            System.out.println("6 - Retorna o que mais\n" +
                    "vendeu no mês.");
            System.out.println("0 - Sair");

            opcao =  sc.nextInt();
            sc.nextLine();
            if(opcao == 0){
                System.out.println("Saindo");
                sc.close();
                return;
            }
            System.out.print("Informe o mês (1-12): ");
            int mes = sc.nextInt();
            System.out.print("Informe o ano: ");
            int ano = sc.nextInt();

            switch (opcao) {
                case 1:
                    double totalPago = servicec.calcularTotalPago(funcionarios, mes, ano);
                    System.out.println("Total pago (salário + benefícios): " + totalPago);
                    break;

                case 2:
                    double totalSalarios = servicec.calcularTotalSalarios(funcionarios, mes, ano);
                    System.out.println("Total pago em salários: " + totalSalarios);
                    break;

                case 3:
                    double totalBeneficios = servicec.calcularTotalBeneficios(funcionarios, mes, ano);
                    System.out.println("Total pago em benefícios: " + totalBeneficios);
                    break;

                case 4:
                    Funcionario maiorPagamento = servicec.maiorPagamento(funcionarios, mes, ano);
                    if (maiorPagamento != null) {
                        System.out.println("Funcionário com maior pagamento: " + maiorPagamento.getNome());
                    } else {
                        System.out.println("Nenhum funcionário encontrado.");
                    }
                    break;

                case 5:
                    Funcionario maiorBeneficio = servicec.maiorBeneficio(funcionarios, mes, ano);
                    if (maiorBeneficio != null) {
                        System.out.println("Funcionário com maior benefício: " + maiorBeneficio.getNome());
                    } else {
                        System.out.println("Nenhum funcionário com benefícios encontrado.");
                    }
                    break;

                case 6:
                    List<Vendedor> vendedores = new ArrayList<>();
                    for (Funcionario f : funcionarios) {
                        if (f.getCargo() instanceof Vendedor) {
                            vendedores.add((Vendedor) f.getCargo());
                        }
                    }

                    Vendedor melhorVendedor = servicec.melhorVendedor(vendedores, mes, ano);
                    if (melhorVendedor != null) {
                        System.out.println("Melhor vendedor: " + melhorVendedor);
                    } else {
                        System.out.println("Nenhum vendedor encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);

        sc.close();
    }
    }
