package controllers;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;
import entities.Produto;
import repositories.EstoqueRepositoryJsonImpl;
import repositories.EstoqueRepositoryTxtImpl;
import repositories.EstoqueRepositoryXmlImpl;

public class EstoqueController {
	
	/*
	 * Método para fazer a captura dos dados do estoque
	 */
	public void cadastraEstoque() {
		var estoque = obterDadosEstoque();
		
		
		var numProdutos = Integer.parseInt(JOptionPane.showInputDialog("INFORME O NUMERO DE PRODUTOS: "));
		if (numProdutos >0) {
			
			//criar uma lista de produtos
			var lista = new ArrayList<Produto>();
			
			for(var i = 0; i< numProdutos; i++) {
				JOptionPane.showMessageDialog(null, "PREECHIMENTO DO " + (i+1) + "º PRODUTO:");
				lista.add(obterDadosProduto());
			}
			
			//adicionando a lista de produtos na classe estoque
			estoque.setProdutos(lista);
		}
		
		EstoqueRepositoryAbstract estoqueRepository = null;
		
		var formato = JOptionPane.showInputDialog("INFORME 'TXT' OU 'XML' OU 'JSON'");
		switch(formato) {
		case "TXT":
			estoqueRepository = new EstoqueRepositoryTxtImpl();
			break;
			
		case "XML":
			estoqueRepository = new EstoqueRepositoryXmlImpl();
			break;
			
		case "JSON":
			estoqueRepository = new EstoqueRepositoryJsonImpl();
			break;
		}
		
		estoqueRepository.exportarDados(estoque);
	}
	
	/*
	 * Método para ler e retornar os dados de um estoque
	 */
	
	private Estoque obterDadosEstoque() {
		
		var estoque = new Estoque();
		
		estoque.setId(UUID.randomUUID());
		estoque.setNome(JOptionPane.showInputDialog("NOME DO ESTOQUE: "));
		
		return estoque;
		
	}
	
	/*
	 * Método para ler e retornar os dados de um produto
	 */
	
	private Produto obterDadosProduto() {
		
		var produto = new Produto();
		
		produto.setId(UUID.randomUUID());
		produto.setNome(JOptionPane.showInputDialog("NOME DO PRODUTO: "));
		produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("PREÇO: ")));
		produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("QUANTIDADE: ")));
		
		return produto;
		
	}
}
