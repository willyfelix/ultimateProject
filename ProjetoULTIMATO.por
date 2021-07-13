programa {
    
	inteiro listaDeProdutos[] = { 7, 10, 20, 50 }
	
// 	Produto
// 	    - codigo
// 	    - nome
// 	    - quantidade

	
	funcao inicio() {
		inteiro opcao, codigoDoProduto, quantidade, saida, cadastro, exclusao, produto
		inteiro arroz=1,fuba=2,feijao=3,macarrao=4
	
		menu()
		leia(opcao)

		escolha (opcao) {
			caso 1:
    			escreva("Insira o código do produto que deseja dar entrada: ")
    			leia(codigoDoProduto)
    			logico existe = verificarSeCodigoDoProdutoExiste(codigoDoProduto)
    			se (existe) {
        			escreva("Qual é a quantidade do produto? ")
        			leia(quantidade)
        			escreva("Produto selecionado: ", codigo, " Quantidade: ", volume)
        			listaDeProdutos()
    			}
    		    pare
		}
	}
	
	funcao menu() {
	    escreva("Olá, seja Bem Vindo ao SCdE\n")
		escreva("Escolha uma opção: \n")
		escreva("1) Entrada de Produtos \n")
		escreva("2) Saída de Produtos \n")
		escreva("3) Cadastro de Novo Produto \n")
		escreva("4) Exclusão de Produto \n")
		escreva("5) Sair \n")
	}
	
	funcao logico verificarSeCodigoDoProdutoExiste(inteiro codigoDoProduto) {
	    logico achou = falso
	    
		para (inteiro posicao = 0; posicao < 4; posicao++) {
		    inteiro produto = listaDeProdutos[posicao]
			se (produto == codigoDoProduto) {
				achou = verdadeiro  
			}
		}
		
		retorne achou
	}
	
}
