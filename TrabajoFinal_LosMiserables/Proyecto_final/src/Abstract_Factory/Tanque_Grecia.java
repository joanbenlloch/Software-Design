package Abstract_Factory;

import Otros.Personaje;
import Singleton.Calculador;

public class Tanque_Grecia extends EnemigoTanque{

	protected String nombre="Aquiles de Grecia";
	protected Personaje pj;
	
	public Tanque_Grecia(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		//super(2400, 300, 400, 150, null, "sano", "tanque");
		super(vida, ataque, defensa, evasion, estrategia, estado, rol, calc, nombre);
	}

	@Override
	public void datos() {
		System.out.println("Tu enemigo "+nombre+" esta listo para el combate, su salud es de "+vida+" y esta "+estado);
	}

	@Override
	public void ataqueTanque() {
		calc.atacar_jugador(this);
	}

	@Override
	public void ataqueDefensor() {}

	@Override
	public void ataqueAsesino() {}

	@Override
	public void ataqueDios() {}

	@Override
	public void contraataqueTanque() {
		calc.contra_enemy(this);
	}

	@Override
	public void contraataqueDefensor() {}

	@Override
	public void contraataqueAsesino() {}

	@Override
	public void contraataqueDios() {}

	@Override
	public void esquivarTanque() {
		calc.esquivar_enemigo(this);
	}

	@Override
	public void esquivarDefensor() {}

	@Override
	public void esquivarAsesino() {}

	@Override
	public void esquivarDios() {}
}
