package entities;

import java.util.Random;

public class Produto {

	private int id;
	private String nome;
	private double preco;

	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(String nome, double preco) {
		this.id = gerarIdAleatorio();
		this.nome = nome;
		this.preco = preco;
	}

	private int gerarIdAleatorio() {
		Random random = new Random();
		int automaticoId = random.nextInt(9000) + 1000;
		return automaticoId;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void mostrarDetalhes() {
		System.out.println("Id: " + id);
		System.out.println("Nome: " + nome);
		System.out.printf("Preço: R$ %.2f%n", preco);
	}

}
