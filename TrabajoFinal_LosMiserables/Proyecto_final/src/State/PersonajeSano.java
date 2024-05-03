package State;

import Otros.Personaje;

public class PersonajeSano extends EstadoPersonaje{
	public PersonajeSano(Personaje personaje) {
		super(personaje);
	}
	@Override
	public EstadoPersonaje estadoSiguiente() {
		return new PersonajeHerido(personaje);
	}
	@Override
	public void mostrar() {
		System.out.println("Estado del héroe: Sano");
	}
}