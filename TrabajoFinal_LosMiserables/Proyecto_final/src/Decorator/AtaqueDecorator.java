package Decorator;

public class AtaqueDecorator extends Decorator{

	public AtaqueDecorator(ComponentePersonaje componente) {
		super(componente);
	}
	
	public void ataqueMejorado() {
		System.out.println("Estrategia ofensiva: ¡Ataque potenciado!");
	}
	public void verAtaque() {
		ataqueMejorado();
		//System.out.println("Ataque mejorado: " + getAtaque());
	}
	
	public void verDefensa() {
		
	}
	public void verVida() {
		
	}
	public void verEvasion() {
		
	}
	
}
