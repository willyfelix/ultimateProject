package ultimateProject.view;

import java.util.Scanner;

import ultimateProject.model.Produto;
import ultimateProject.controller.Estoque;

public class Aplicacao {

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner input = new Scanner(System.in);
        boolean repete = true;

        System.out.println("\n\n------------------------ SCdE MoDAFOCA ------------------------\n\n");
        while(repete) {
            System.out.print("> Digite aqui o produto que você deseja gerenciar: ");
            String nomeDoProduto = input.nextLine();
    
            boolean produtoExiste = estoque.esteProdutoExiste(nomeDoProduto);
            if ( produtoExiste == true ) {
    
                Produto produto = estoque.encontraProduto(nomeDoProduto);
                System.out.println("Existem " + produto.quantidade + " unidades de " + produto.nome + " no estoque!");
    
            } else {
    
                System.out.println("Esse produto não existe no estoque! Deseja cadastrar?");
                System.out.println("(0) Não (1) Sim\n");
                int opcao = input.nextInt();
                if (opcao == 1) {
                    estoque.cadastrar(nomeDoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                }
    
            }
            input.nextLine();
        }

        input.close();
    }

}