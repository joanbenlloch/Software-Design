package State;

import Otros.Personaje;

public abstract class EstadoPersonaje {
	protected Personaje personaje;
	
	public EstadoPersonaje(Personaje personaje) {
		this.personaje=personaje;
	}
	public abstract void mostrar();
	public abstract EstadoPersonaje estadoSiguiente();
}
