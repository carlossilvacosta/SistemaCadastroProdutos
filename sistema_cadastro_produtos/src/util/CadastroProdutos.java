package util;

import java.util.ArrayList;

import entities.Produto;

public class CadastroProdutos {

	private ArrayList<Produto> produtos = new ArrayList<>();

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
		System.out.println("Produto adicionado no sistema!");
		System.out.println();
	}

	public void listarProdutos() {
		for (Produto produto : produtos) {
			produto.mostrarDetalhes();
			System.out.println("-----------------------");
		}
	}

	public Produto buscarProduto(int id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
	
	public void atualizarProduto(int id, String novoNome, double novoPreco) {
		Produto produto = buscarProduto(id);
		if(produto != null) {
			produto.setNome(novoNome);
			produto.setPreco(novoPreco);
			System.out.println("Nome e Preço do produto atualizados!");
		} else {
			System.out.println("Esse produto não se encontra no sistema.");
		}
	}
	
	public boolean existeProdutoComId(int id) {
	    for (Produto produto : produtos) {
	        if (produto.getId() == id) {
	            return true;
	        }
	    }
	    return false;
	}

	

}
