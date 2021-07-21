package ultimateProject.view;

import java.util.List;
import java.util.Scanner;

import ultimateProject.model.Produto;
import ultimateProject.controller.Estoque;

public class Aplicacao {

    Scanner input = new Scanner(System.in);
    Estoque estoque = new Estoque();

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        app.menu();
    }

    public void menu() {
        int opcao = 0;
        while (opcao != 1 && opcao != 2 && opcao != 3) {
            System.out.println("\n\n------------------------------------------------\n");
            System.out.println("\n\n Sistema Universal Ultra Galatico de Estoque \n\n");
            System.out.println("\n------------------------------------------------\n\n");
            System.out.println("1) Listar todos os produtos no estoque");
            System.out.println("2) Gerenciar um produto específico");
            System.out.println("3) Sair");
            System.out.print("\n> ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    gerenciarProduto();
                    break;
                case 3:
                    System.out.println("\n\n\t:: Até logo!!\n\n");
                    break;
                default:
                    System.out.println("\n\t:: Opção inválida\n\n");
                    break;
            }
        }
    }

    public void listarProdutos() {
        System.out.println("\n");

        List<Produto> produtos = estoque.pegarProdutos();
        if (produtos.size() == 0) {
            System.out.println("\t:: Não existe nenhum produto no estoque ainda!");
        }

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println("\t:: Existem " + produto.quantidade + " unidades de " + produto.nome + " no estoque!");
        }

        System.out.println("\n\n");
        menu();
    }

    public void gerenciarProduto() {

        System.out.print("\n\n> Digite aqui o nome do produto: ");
        String nomeDoProduto = input.nextLine();

        boolean produtoExiste = estoque.esteProdutoExiste(nomeDoProduto);
        if (produtoExiste == true) {

            Produto produto = estoque.encontraProduto(nomeDoProduto);
            System.out.println("\n\t:: Existem " + produto.quantidade + " unidades de " + produto.nome + " no estoque!\n\n");
            
            int opcao = 0;
            while (opcao != 1 && opcao != 2 && opcao != 3) {
                System.out.println("(1) Deseja aumentar o estoque deste produto?");
                System.out.println("(2) Deseja diminuir o estoque deste produto?");
                System.out.print("(3) Voltar ao menu principal\n\n> ");
                opcao = input.nextInt();
                input.nextLine();

                int quantidade;
                switch (opcao) {
                    case 1:
                        System.out.print("> Digite a quantidade que deseja aumentar: ");
                        quantidade = input.nextInt();
                        input.nextLine();

                        estoque.adicionar(nomeDoProduto, quantidade);
                        System.out.println("\n\t:: " + quantidade + " unidades adicionadas");
                        break;
                    case 2:
                        System.out.print("> Digite a quantidade que deseja diminuir: ");
                        quantidade = input.nextInt();
                        input.nextLine();

                        estoque.remover(nomeDoProduto, quantidade);
                        System.out.println("\n\t:: " + quantidade + " unidades removidas");
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("\n\t:: Opção inválida\n");
                        break;
                }
            }

        } else {

            System.out.println("\nEsse produto não existe no estoque! Deseja cadastrar?");
            System.out.print("(0) Não (1) Sim\n\n> ");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                estoque.cadastrar(nomeDoProduto);
                System.out.println("\nProduto cadastrado com sucesso!\n\n");
            }

        }

        System.out.println("\n\n\n");
        menu();

    }

}