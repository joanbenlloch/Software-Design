package Decorator;

public class DefensaDecorator extends Decorator{

	public DefensaDecorator(ComponentePersonaje componente) {
		super(componente);
	}
	
	public void defensaMejorada() {
		System.out.println("Estrategia defensiva: ¡Contraataque activado!");
	}
	
	public void verAtaque() {
	
	}
	
	public void verDefensa() {
		defensaMejorada();
		//System.out.println("Defensa mejorada: " + getDefensa());
	}
	public void verVida() {
		
	}
	public void verEvasion() {
		
	}
}
