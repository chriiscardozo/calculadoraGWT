package calculadora.client.notifiers;

import calculadora.client.listeners.CalculadoraChangeListener;

public interface CalculadoraChangeNotifier {
	public void addChangeListener(final CalculadoraChangeListener listener);
}
