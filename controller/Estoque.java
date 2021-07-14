package ultimateProject.controller;

import java.util.ArrayList;
import java.util.List;

import ultimateProject.model.Produto;

public class Estoque {

    private List<Produto> produtos = new ArrayList<Produto>();

    public boolean esteProdutoExiste(String nomeDoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.nome.equals(nomeDoProduto)) {
                return true;
            }
        }

        return false;
    }

    public Produto encontraProduto(String nomeDoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.nome.equals(nomeDoProduto)) {
                return produto;
            }
        }

        return null;
    }

    public void cadastrar(String nomeDoProduto) {
        Produto produto = new Produto();
        produto.nome = nomeDoProduto;
        produto.quantidade = 0;

        produtos.add(produto);
    }

    public void excluir(String nomeDoProduto) {
        
    }

    public void adicionar(String nomeDoProduto, int quantidade) {

    }

    public void remover(String nomeDoProduto, int quantidade) {

    }

}