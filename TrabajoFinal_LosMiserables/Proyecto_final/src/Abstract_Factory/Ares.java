package Abstract_Factory;

import Otros.Personaje;
import Singleton.Calculador;

public class Ares extends EnemigoTanque{

	protected String nombre="Ares, dios de la guerra";
	protected Personaje pj;

	public Ares(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		//super(2500, 600, 500, 300, null, "sano", "tanque");
		super(vida, ataque, defensa, evasion, estrategia, estado, rol, calc, nombre);
	}

	@Override
	public void datos() {
		System.out.println(nombre+" esta listo para el combate, su salud es de "+vida+" y esta "+estado);
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
