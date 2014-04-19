package calculadora.client.controller;

import calculadora.client.CalculadoraConstants;
import calculadora.client.dados.CalculadoraDados;
import calculadora.client.widgets.AbstractOperador;
import calculadora.client.widgets.OperadorBinario;
import calculadora.client.widgets.OperadorUnario;

public class CalculadoraController {
	CalculadoraDados dados;
	AbstractOperador ultimoOperador;
	private double prevBuffer;
	
	public CalculadoraController(final CalculadoraDados dados){
		this.dados = dados;
	}
	
	public void processarLimpar(){
		dados.limpar();
		this.ultimoOperador = null;
	}
	
	public void processarIgual(){
		if(this.ultimoOperador != null){
			if(!dados.isUltimaOpIgual()) prevBuffer = Double.parseDouble(dados.getDisplay());
			ultimoOperador.operar(dados);
			dados.setBuffer(prevBuffer);
			dados.setUltimaOpIgual(true);
		}
	}
	
	public void processarOperador(final AbstractOperador op){
		
		if(op instanceof OperadorBinario){
			if((ultimoOperador == null) || dados.isUltimaOpIgual()){
				dados.setBuffer(Double.parseDouble(dados.getDisplay()));
				dados.setInitDisplay(true);
			}
			else{
				ultimoOperador.operar(dados);
			}
			ultimoOperador = op;
		}
		else if(op instanceof OperadorUnario){
			op.operar(dados);
		}
		dados.setUltimaOpIgual(false);
	}
	
	public void processarDigito(final String s){
		if(dados.isUltimaOpIgual()) ultimoOperador = null;
		
		if(dados.isInitDisplay()){
			if(dados.isUltimaOpIgual()) dados.setBuffer(0.0);
			else dados.setBuffer(Double.parseDouble(dados.getDisplay()));
			dados.setDisplay(s);
			dados.setInitDisplay(false);
		}
		else{
			if(dados.getDisplay().indexOf(CalculadoraConstants.PONTO) == -1)
				dados.setDisplay(dados.getDisplay() + s);
			
			else if(!s.equals(CalculadoraConstants.PONTO))
				dados.setDisplay(dados.getDisplay() + s);
		}
		
		dados.setUltimaOpIgual(false);
	}
}
