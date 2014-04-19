package calculadora.client.widgets;

import calculadora.client.dados.CalculadoraDados;

public abstract class AbstractOperador {
	public String label;
	
	AbstractOperador(final String label) {
		this.label = label;
	}
	
	public abstract void operar(final CalculadoraDados dados);
}
