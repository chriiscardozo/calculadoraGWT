package calculadora.client;

import calculadora.client.widgets.CalculadoraWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class CalculadoraGWT implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(new CalculadoraWidget("Calculadora Gluglu"));
	}
}