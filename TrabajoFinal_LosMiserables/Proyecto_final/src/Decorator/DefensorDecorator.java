package Decorator;

public class DefensorDecorator extends Decorator{

	public DefensorDecorator(ComponentePersonaje componente) {
		super(componente);
	}

	public void bonusDefensor() {
		System.out.println("Bonus de defensor: ¡Coraza impenetrable!");
	}
	public void verAtaque() {
		
	}
	
	public void verDefensa() {
		bonusDefensor();
		//componente.verDefensa();
	}
	public void verVida() {
		
	}
	public void verEvasion() {
		
	}

}
