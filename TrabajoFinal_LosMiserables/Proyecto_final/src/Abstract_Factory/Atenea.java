package Abstract_Factory;

import Otros.Personaje;
import Singleton.Calculador;

public class Atenea extends EnemigoAsesino{

	protected String nombre="Atenea, diosa de la sabidur�a";
	protected Personaje pj;
	
	public Atenea(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		super(vida, ataque, defensa, evasion, estrategia, estado, rol, calc, nombre);
	}

	@Override
	public void datos() {
		System.out.println("Tu enemigo "+nombre+" esta listo para el combate, su salud es de "+vida+" y esta "+estado);
	}

	@Override
	public void ataqueTanque() {}

	@Override
	public void ataqueDefensor() {}

	@Override
	public void ataqueAsesino() {
		calc.atacar_jugador(this);
	}

	@Override
	public void ataqueDios() {}

	@Override
	public void contraataqueTanque() {}

	@Override
	public void contraataqueDefensor() {}

	@Override
	public void contraataqueAsesino() {
		calc.contra_enemy(this);
	}

	@Override
	public void contraataqueDios() {}

	@Override
	public void esquivarTanque() {}

	@Override
	public void esquivarDefensor() {}

	@Override
	public void esquivarAsesino() {
		calc.esquivar_enemigo(this);
	}

	@Override
	public void esquivarDios() {}
}
