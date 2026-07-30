package com.agencia;
import com.agencia.dao.ClienteDAO;
import com.agencia.dao.JPAUtil;
import com.agencia.model.Cliente;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        int opcao;
        do {
            System.out.println("\n===== AGÊNCIA DE TURISMO =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Buscar cliente por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF (somente números): ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Destino preferido: ");
                    String destino = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, telefone, email, destino);
                    clienteDAO.salvar(cliente);
                    System.out.println("Cliente salvo com sucesso! ID gerado: " + cliente.getId());
                    break;

                case 2:
                    System.out.print("Informe o CPF a pesquisar: ");
                    String cpfBusca = scanner.nextLine();
                    Cliente encontrado = clienteDAO.buscarPorCpf(cpfBusca);
                    if (encontrado != null) {
                        System.out.println("Cliente encontrado: " + encontrado);
                    } else {
                        System.out.println("Nenhum cliente encontrado com o CPF " + cpfBusca);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        JPAUtil.close();
        scanner.close();
    }
}
