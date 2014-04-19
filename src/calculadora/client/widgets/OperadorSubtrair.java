package calculadora.client.widgets;

import calculadora.client.dados.CalculadoraDados;

public class OperadorSubtrair extends OperadorBinario {

	OperadorSubtrair(String label) {
		super(label);
	}

	public void operar(CalculadoraDados dados) {
		dados.setDisplay(String.valueOf(dados.getBuffer() - Double.parseDouble(dados.getDisplay())));
		dados.setInitDisplay(true);
	}
}
