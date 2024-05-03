package Abstract_Factory;

import Otros.Enemigo;
import Singleton.*;

public abstract class EnemigoAsesino extends Enemigo{

	public EnemigoAsesino(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		super(vida, ataque, defensa, evasion, estrategia, estado, rol, calc, nombre);
	}

	abstract void datos();
}
