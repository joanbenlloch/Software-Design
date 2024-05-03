package State;

import Otros.Enemigo;

public abstract class EstadoEnemigo {
	protected Enemigo enemigo;
	
	public EstadoEnemigo(Enemigo enemigo) {
		this.enemigo=enemigo;
	}
	public abstract void mostrar();
	public abstract EstadoEnemigo estadoSiguiente();

}
