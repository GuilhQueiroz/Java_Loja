package Entities;

public class Produto { 
	
	private String nome;
	private int codigo;
	private int estoque;
	
	public Produto (String nome, int codigo, int estoque) {
		this.nome = nome;
		this.codigo = codigo;
		this.estoque = estoque;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public void adicionarEstoque(int quantidade) {
		estoque += quantidade;
	}
	
	public boolean venda(int quantidade) {
		if (quantidade <= estoque) {
			estoque -= quantidade;
			return true;
		} 
		
		return false;
	}
	
	@Override
	public String toString() {
		return nome + "(código: " + codigo + " | estoque: " + estoque + ")";
	}
}
