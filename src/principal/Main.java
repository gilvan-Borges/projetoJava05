package principal;

import controllers.EstoqueController;

public class Main {

	public static void main(String[] args) {
		
		var estoqueController = new EstoqueController();
		estoqueController.cadastraEstoque();

	}
}
