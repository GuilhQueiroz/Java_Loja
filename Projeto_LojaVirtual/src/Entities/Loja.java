package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
	
	private static ArrayList<Produto> produtos = new ArrayList<>();
	private static int codigoProduto = 1;
	private Scanner sc = new Scanner(System.in);
	
	public void executar() {
		while (true) {
			exibirMenu();		
			int opcao = sc.nextInt();
			sc.nextLine(); // Limpar o buffer
			
			switch (opcao) {
			case 1:
				listarProdutos();
				break;
				
			case 2: 
				cadastrarProduto();
				break;
				
			case 3:
				adicionarEstoque();
				break;
				
			case 4:
				removerProduto();
				break;
				
			case 5:
				venderProduto();
				break;
				
			case 6: 
				encerrarPrograma();
				break;
				
				default: 
					System.out.println("Opção inválida. Tente novamente");
					break;
			}
		}
	}
	
	private void exibirMenu() {
		System.out.println();
		System.out.println("Menu: ");
		System.out.println("1) Listar Produtos");
		System.out.println("2) Cadastrar um novo produto");
		System.out.println("3) Adicionar estoque de um produto");
		System.out.println("4) Remover um produto da loja");
		System.out.println("5) Vender algum produto");
		System.out.println("6) Sair");
		System.out.println();
		System.out.println("Escolha uma opção: ");
	}
	
	private void listarProdutos() {
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
		} else {
			for (Produto produto : produtos) {
				System.out.println(produto.toString());
			}
		}
	}
	
	private void cadastrarProduto() {
		System.out.println("Nome do produto: ");
		String nome = sc.nextLine();
		produtos.add(new Produto(nome, codigoProduto, 0 ));
		System.out.println("Produto cadastrado com sucesso. Código: " + codigoProduto);
		codigoProduto++;
	}
	
	private void adicionarEstoque() {
		System.out.println("Informe o código do produto: ");
		int codigo = sc.nextInt();
		System.out.println("Informe a quantidade a ser adicionada ao estoque: ");
		int quantidade = sc.nextInt();
		
		for (Produto produto : produtos) { 
			if (produto.getCodigo() == codigo) {
				produto.adicionarEstoque(quantidade);
				System.out.println("Estoque atualizado para: " + produto.getEstoque());
				return;
			}
		}
		
		System.out.println("Produto não encontrado.");
	}
	
	private void removerProduto() {
		System.out.println("Informe o código do produto a ser removido: ");
		int codigo = sc.nextInt();
		
		for (Produto produto : produtos) {
			if (produto.getCodigo() == codigo) {
				produtos.remove(produto);
				System.out.println("Produto removido com sucesso");
				return;
			}
		}
		
		System.out.println("Produto não encontrado.");
	}
	
	private void venderProduto() {
		System.out.println("Informe o código do produto a ser vendido: ");
		int codigo = sc.nextInt();
		System.out.println("Informe a quantidade a ser vendida: ");
		int quantidade = sc.nextInt();
		
		for (Produto produto : produtos) {
			if (produto.getCodigo() == codigo);
				if (produto.venda(quantidade)) {
					System.out.println("Venda realizada com sucesso. Estoque atualizado para: " + produto.getEstoque());
				} else {
					System.out.println("Estoque insuficiente");
				}
				return;
		}
		
		System.out.println("Produto não encontrado.");
	}
	
	private void encerrarPrograma() {
		System.out.println("Saindo do programa.");
		sc.close();
		System.exit(0);
	}
}
