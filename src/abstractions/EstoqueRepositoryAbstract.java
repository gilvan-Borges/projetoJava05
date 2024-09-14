package abstractions;

import java.io.File;

import entities.Estoque;

//Classe abstrata para definição de rotinas

public abstract class EstoqueRepositoryAbstract {

	/*
	 * Método para criar a pasta onde os arquivos serão gravados
	 */
	public void criarDiretorio(String caminho) {
		
		var file = new File(caminho);
		if(!file.exists()) {// verificando se o caminho existe
			
			file.mkdir();//criando a pasta para gravar
			System.out.println("DIRETÓRIO CRIADO COM SUCESSO!");
		}
		else {
			System.out.println("DIRETÒRIO JÀ EXISTENTE!");
		}
	}
	
	/*
	 * Método abstratos para exportar dados do funcionario
	 */
	
	public abstract void exportarDados(Estoque estoque);
}
