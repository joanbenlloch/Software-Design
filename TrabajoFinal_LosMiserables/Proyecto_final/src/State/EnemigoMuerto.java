package State;

import Otros.Enemigo;

public class EnemigoMuerto extends EstadoEnemigo{

	public EnemigoMuerto(Enemigo enemigo) {
		super(enemigo);
	}

	@Override
	public void mostrar() {
		System.out.println("Estado del enemigo: Muerto");
	}

	@Override
	public EstadoEnemigo estadoSiguiente() {
		return this;
	}

}
