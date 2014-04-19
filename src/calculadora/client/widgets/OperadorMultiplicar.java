package calculadora.client.widgets;

import calculadora.client.dados.CalculadoraDados;

public class OperadorMultiplicar extends OperadorBinario{

	OperadorMultiplicar(String label) {
		super(label);
	}

	public void operar(CalculadoraDados dados) {
		dados.setDisplay(String.valueOf(dados.getBuffer() * Double.parseDouble(dados.getDisplay())));
		dados.setInitDisplay(true);
	}
}
