package calculadora.client.widgets;

import calculadora.client.controller.CalculadoraController;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class BotaoOperador extends Button{
	
	public BotaoOperador(final CalculadoraController controller, final AbstractOperador op){
		super(op.label);
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.processarOperador(op);
			}
		});
//		this.setStyleName(CalculadoraConstants.STYLE_BOTAO_OPERADOR);
	}
}
