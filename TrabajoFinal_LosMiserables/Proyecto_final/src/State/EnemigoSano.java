package State;

import Otros.Enemigo;

public class EnemigoSano extends EstadoEnemigo{

	public EnemigoSano(Enemigo enemigo) {
		super(enemigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mostrar() {
		System.out.println("Estado del enemigo: Sano");
		
	}

	@Override
	public EstadoEnemigo estadoSiguiente() {
		// TODO Auto-generated method stub
		return new EnemigoHerido(enemigo);
	}

}
