package Abstract_Factory;

import Singleton.Calculador;

public class Defensor_Grecia extends EnemigoDefensor{

	protected String nombre="Odiseo de Grecia";
	
	public Defensor_Grecia(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		super(vida, ataque, defensa, evasion, estrategia, estado, rol, calc, nombre);
	}

	@Override
	public void datos() {
		System.out.println("Tu enemigo "+nombre+" esta listo para el combate, su salud es de "+vida+" y esta "+estado);
	}

	@Override
	public void ataqueTanque() {}

	@Override
	public void ataqueDefensor() {
		calc.atacar_jugador(this);
	}

	@Override
	public void ataqueAsesino() {}

	@Override
	public void ataqueDios() {}

	@Override
	public void contraataqueTanque() {}

	@Override
	public void contraataqueDefensor() {
		calc.contra_enemy(this);
	}

	@Override
	public void contraataqueAsesino() {}

	@Override
	public void contraataqueDios() {}

	@Override
	public void esquivarTanque() {}

	@Override
	public void esquivarDefensor() {
		calc.esquivar_enemigo(this);
	}

	@Override
	public void esquivarAsesino() {}

	@Override
	public void esquivarDios() {}
}
