package State;

import Otros.Personaje;
import Otros.Enemigo;

public class ComprobarEstado {
	public int getVidaI(Personaje personaje) {
		return personaje.getVida();
	}
	public int getVidaI(int vida) {
		return vida;
	}
	//El metodo que recibe personajes y calcula el estado
	public void estadoPersonaje(Personaje personaje, int vidaI) {
		PersonajeSano psano = new PersonajeSano(personaje);
		PersonajeHerido pherido = new PersonajeHerido(personaje);
		PersonajeMuerto pmuerto = new PersonajeMuerto(personaje);
		int a = vidaI;
		int b=personaje.getVida();
		int c = a/2;
		//El estado si la vida es mayor a la mitad se muestra sano
		if(b>=c) {
			psano.mostrar();
		//El estado si la vida es 0 o menos se muestra muerto
		}else if(b<=0) {
			pmuerto.mostrar();
			pherido.estadoSiguiente();
		//El estado si la vida es menor a la mitad se muestra herido
		}else {
			pherido.mostrar();
			psano.estadoSiguiente();
		}
	}
	//El mismo metodo pero recibe un enemigo en vez de recibir un personaje
	public void estadoEnemigo(Enemigo enemigo, int vidaI) {
		EnemigoSano esano = new EnemigoSano(enemigo);
		EnemigoHerido eherido = new EnemigoHerido(enemigo);
		EnemigoMuerto emuerto = new EnemigoMuerto(enemigo);
		int a = vidaI;
		int b=enemigo.getVida();
		int c = a/2;
		//El estado si la vida es mayor a la mitad se muestra sano
		if(b>=c) {
			esano.mostrar();
		//El estado si la vida es 0 o menos se muestra muerto
		}else if(b<=0) {
			emuerto.mostrar();
			eherido.estadoSiguiente();
		//El estado si la vida es menor a la mitad se muestra herido
		}else {
			eherido.mostrar();
			esano.estadoSiguiente();
		}
	}	
}
