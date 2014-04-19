package calculadora.client.dados;

import calculadora.client.listeners.CalculadoraChangeListener;
import calculadora.client.notifiers.CalculadoraChangeNotifier;

public class CalculadoraDados implements CalculadoraChangeNotifier{
	
	private String display;
	private double buffer;
	private boolean initDisplay;
	private boolean ultimaOpIgual;
	private CalculadoraChangeListener listener;
	
	public CalculadoraDados(){
		this.limpar();
	}
	
	public void addChangeListener(CalculadoraChangeListener listener) {
		this.listener = listener;
	}
	
	public void limpar(){
		this.display = "0";
		this.buffer = 0.0;
		this.initDisplay = true;
		this.ultimaOpIgual = false;
		if (listener != null) listener.onChange(this);
	}
	
	public double getBuffer(){
		return buffer;
	}
	
	public void setBuffer(double buffer){
		this.buffer = buffer;
		listener.onChange(this);
	}
	
	public String getDisplay(){
		return this.display;
	}
	
	public void setDisplay(String display){
		this.display = display;
		listener.onChange(this);
	}
	
	public boolean isInitDisplay(){
		return this.initDisplay;
	}
	
	public void setInitDisplay(boolean initDisplay){
		this.initDisplay = initDisplay;
	}
	
	public boolean isUltimaOpIgual(){
		return this.ultimaOpIgual;
	}
	
	public void setUltimaOpIgual(boolean ultimaOpIgual){
		this.ultimaOpIgual = ultimaOpIgual;
	}
}
