package calculadora.client.widgets;

import calculadora.client.CalculadoraConstants;
import calculadora.client.dados.CalculadoraDados;

public class OperadorSomar extends OperadorBinario{

	OperadorSomar(String label) {
		super(CalculadoraConstants.ADD);
	}

	public void operar(CalculadoraDados dados) {
		dados.setDisplay(String.valueOf(dados.getBuffer() + Double.parseDouble(dados.getDisplay())));
		dados.setInitDisplay(true);
	}
}
