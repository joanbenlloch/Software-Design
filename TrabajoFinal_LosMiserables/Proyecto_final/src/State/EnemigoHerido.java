package State;

import Otros.Enemigo;

public class EnemigoHerido extends EstadoEnemigo{
	
	public EnemigoHerido(Enemigo enemigo) {
		super(enemigo);
	}
	@Override
	public void mostrar() {
		System.out.println("Estado del enemigo: Herido");
	}
	@Override
	public EstadoEnemigo estadoSiguiente() {
		// TODO Auto-generated method stub
		return new EnemigoHerido(enemigo);
	}
}
