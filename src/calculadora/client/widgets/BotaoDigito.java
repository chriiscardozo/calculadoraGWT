package calculadora.client.widgets;

import calculadora.client.controller.CalculadoraController;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class BotaoDigito extends Button {
	
	public BotaoDigito(final CalculadoraController controller, final String label){
		super(label);
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.processarDigito(label);
			}
		});
//		this.setStyleName(CalculadoraConstants.STYLE_BOTAO_DIGITO);
	}
}
