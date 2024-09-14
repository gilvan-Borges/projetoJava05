package repositories;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryJsonImpl extends EstoqueRepositoryAbstract {

	@Override
	public void exportarDados(Estoque estoque) {
		
		try {
			
			var diretorio = "c:\\arquivos_json";
			criarDiretorio(diretorio);
			
			//exportar os dados do estoque para JSON
			var objectMapper = new ObjectMapper();
			objectMapper.writeValue(new File(diretorio + "\\estoque_" + estoque.getId() + ".json"), estoque);
			
			System.out.println("\nARQUIVO JSON GRAVADO COM SUCESSO!");
			
		} catch (Exception e) {
			System.out.println("\nERRO:" + e.getMessage());
		}
		
	}
}
