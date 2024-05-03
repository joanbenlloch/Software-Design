package State;

import Otros.Personaje;

public class PersonajeHerido extends EstadoPersonaje{
	public PersonajeHerido(Personaje personaje) {
		super(personaje);
	}
	@Override
	public EstadoPersonaje estadoSiguiente() {
		return new PersonajeMuerto(personaje);
	}
	@Override
	public void mostrar() {
		System.out.println("Estado del héroe: Herido");
	}
}
