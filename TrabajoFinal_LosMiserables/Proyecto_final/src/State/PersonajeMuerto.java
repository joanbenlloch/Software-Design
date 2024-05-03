package State;

import Otros.Personaje;

public class PersonajeMuerto extends EstadoPersonaje{
	public PersonajeMuerto(Personaje personaje) {
		super(personaje);
	}
	@Override
	public EstadoPersonaje estadoSiguiente() {
		return this;
	}
	@Override
	public void mostrar() {
		System.out.println("Estado del héroe: Muerto");	
	}
}
