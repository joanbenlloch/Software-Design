package Decorator;

public abstract class Decorator implements ComponentePersonaje{

	protected ComponentePersonaje componente;
	
	public Decorator(ComponentePersonaje componente) {
		this.componente = componente;
	}
	
	protected ComponentePersonaje getComponente() {
		return componente;
	}
	
}
