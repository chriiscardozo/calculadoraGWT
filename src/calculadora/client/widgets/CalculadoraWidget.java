package calculadora.client.widgets;

import calculadora.client.CalculadoraConstants;
import calculadora.client.controller.CalculadoraController;
import calculadora.client.dados.CalculadoraDados;
import calculadora.client.listeners.CalculadoraChangeListener;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CalculadoraWidget extends VerticalPanel{
	private TextBox display;
	
	public CalculadoraWidget(final String titulo){
		super();
		
		final CalculadoraDados dados = new CalculadoraDados();
		final CalculadoraController controller = new CalculadoraController(dados);
		
		VerticalPanel p = new VerticalPanel();
		p.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
//		p.setStyleName(CalculadoraConstants.STYLE_PANEL);
		
		Grid g = new Grid(4, 4);
//		g.setStyleName(CalculadoraConstants.STYLE_GRID);
		
		final Button zero = new BotaoDigito(controller, "0");
		g.setWidget(3, 0, zero);
		
		final Button um = new BotaoDigito(controller, "1");
		g.setWidget(2, 0, um);
		
		final Button dois = new BotaoDigito(controller, "2");
		g.setWidget(2, 1, dois);
		
		final Button tres = new BotaoDigito(controller, "3");
		g.setWidget(2, 2, tres);
		
		final Button quatro = new BotaoDigito(controller, "4");
		g.setWidget(1, 0, quatro);
		
		final Button cinco = new BotaoDigito(controller, "5");
		g.setWidget(1, 1, cinco);
		
		final Button seis = new BotaoDigito(controller, "6");
		g.setWidget(1, 2, seis);
		
		final Button sete = new BotaoDigito(controller, "7");
		g.setWidget(0, 0, sete);
		
		final Button oito = new BotaoDigito(controller, "8");
		g.setWidget(0, 1, oito);
		
		final Button nove = new BotaoDigito(controller, "9");
		g.setWidget(0, 2, nove);
		
		final Button dividir = new BotaoOperador(controller, new OperadorDividir("/"));
		g.setWidget(0, 3, dividir);
		final Button multiplicar = new BotaoOperador(controller, new OperadorMultiplicar("*"));
		g.setWidget(1, 3, multiplicar);
		final Button subtrair = new BotaoOperador(controller, new OperadorSubtrair("-"));
		g.setWidget(2, 3, subtrair);
		final Button somar = new BotaoOperador(controller, new OperadorSomar("+"));
		g.setWidget(3, 3, somar);
		
		final Button limpar = new Button();
		limpar.setText(CalculadoraConstants.LIMPAR);
		limpar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.processarLimpar();
			}
		});
//		limpar.setStyleName(CalculadoraConstants.STYLE_BUTTON);
		g.setWidget(3, 1, limpar);
		
		final Button igual = new Button();
		igual.setText(CalculadoraConstants.IGUAL);
		igual.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.processarIgual();
			}
		});
		g.setWidget(3, 2, igual);
		
		display = new TextBox();
		
		dados.addChangeListener(new CalculadoraChangeListener() {
			public void onChange(CalculadoraDados dados) {
				display.setText(String.valueOf(dados.getDisplay()));
			}
		});
		
		display.setText("0");
		display.setAlignment(TextAlignment.RIGHT);
		
		p.add(display);
		p.add(g);
		this.add(p);
	}

}
