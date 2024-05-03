package Decorator;

public class AsesinoDecorator extends Decorator{

	public AsesinoDecorator(ComponentePersonaje componente) {
		super(componente);
	}

	public void bonusAsesino() {
		System.out.println("Bonus de asesino: �Ataque r�pido afilado!");
	}
	public void verAtaque() {
		bonusAsesino();
		//componente.verAtaque();
	}
	
	public void verDefensa() {
		
	}
	public void verVida() {
		
	}
	public void verEvasion() {
		
	}
	
}
