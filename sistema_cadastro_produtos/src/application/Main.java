package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import util.CadastroProdutos;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		CadastroProdutos cadastro = new CadastroProdutos();
		
		while(true) {
			System.out.println();
			System.out.println("Sistema de Cadastro de Produtos");
			System.out.println("Menu:");
			System.out.println("1 - Adicionar um produto ao sistema");
			System.out.println("2 - Listar produtos do sistema");
			System.out.println("3 - Buscar produto por ID");
			System.out.println("4 - Atualizar produto");
			System.out.println("5 - Sair do sistema");
			System.out.print("Opção: ");
			int opcao = sc.nextInt();
			System.out.println();
			
			if(opcao == 1) {
				System.out.print("Deseja cadastrar um produto com ID próprio (s/n)? ");
				sc.nextLine();
				char tipoCadastro = sc.nextLine().charAt(0);
				if(tipoCadastro == 's') {
					System.out.print("Digite um ID para o produto ( 4 digitos / ex: 1234): ");
					int id = sc.nextInt();
					if(cadastro.existeProdutoComId(id) || id > 9999) {
			            System.out.println("Este ID já existe no sistema. "
			            		+ "OBS.:Ou quantidade de digitos incorretos.");
			        } else {
					System.out.print("Nome do produto: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Preço do produto: R$ ");
					double preco = sc.nextDouble();
					Produto produto = new Produto(id, nome, preco);
					//Produto produto = new Produto(nome, preco);
					cadastro.adicionarProduto(produto);
			        }
				} else {
					//System.out.print("Digite um ID para o produto ( 4 digitos / ex: 1234): ");
					//int id = sc.nextInt();
					System.out.print("Nome do produto: ");
					//sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Preço do produto: R$ ");
					double preco = sc.nextDouble();
					//Produto produto = new Produto(id, nome, preco);
					Produto produto = new Produto(nome, preco);
					cadastro.adicionarProduto(produto);
				}
				
			} else if (opcao == 2) {
				cadastro.listarProdutos();
			} else if(opcao == 3) {
				System.out.print("Digite o ID do produto que deseja buscar: ");
				int idProdutoBuscado = sc.nextInt();
				Produto produtoEncontrado = cadastro.buscarProduto(idProdutoBuscado);
				if(produtoEncontrado != null) {
					produtoEncontrado.mostrarDetalhes();
				} else {
					System.out.println("ID não encontrado. Desculpe!");
				}
			} else if(opcao == 4) {
				System.out.print("Digite o ID do produto que deseja atualizar: ");
				int atualizacaoId = sc.nextInt();
				System.out.print("Digite um novo nome do produto: ");
				sc.nextLine();
				String atualizacaoNome = sc.nextLine();
				System.out.print("Digite um novo preço do produto: R$ ");
				double atualizacaoPreco = sc.nextDouble();
				cadastro.atualizarProduto(atualizacaoId, atualizacaoNome, atualizacaoPreco);
			} else if(opcao == 5) {
				System.out.println("Sistema Encerrado, Obrigado!");
				break;
			} else {
				System.out.println("Opção inválida, tente novamente!");
			}
		}
		sc.close();
		
		
	}

}
