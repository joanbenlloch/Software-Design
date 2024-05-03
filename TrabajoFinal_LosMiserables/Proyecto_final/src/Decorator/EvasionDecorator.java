package Decorator;

public class EvasionDecorator extends Decorator{

	public EvasionDecorator(ComponentePersonaje componente) {
		super(componente);
	}
	
	public void evasionMejorada() {
		System.out.println("Estrategia evasiva: ¡Evasión aumentada!");
	}
	
	public void verAtaque() {
		
	}
	
	public void verDefensa() {
		
	}
	public void verVida() {
		
	}
	public void verEvasion() {
		evasionMejorada();
		//System.out.println("Evasion mejorada: " + getEvasion());
	}
}
