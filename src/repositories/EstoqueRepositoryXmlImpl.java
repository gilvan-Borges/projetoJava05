package repositories;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryXmlImpl extends EstoqueRepositoryAbstract {

	@Override
	public void exportarDados(Estoque estoque) {
		try {

			var diretorio = "c:\\arquivos_xml";
			criarDiretorio(diretorio);

			// exportar os dados do estoque para XML
			var xmlMapper = new XmlMapper();
			xmlMapper.writeValue(new File(diretorio + "\\estoque_" + estoque.getId() + ".xml"), estoque);

			System.out.println("\nARQUIVO XML GRAVADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nERRO:" + e.getMessage());
		}

	}

}
