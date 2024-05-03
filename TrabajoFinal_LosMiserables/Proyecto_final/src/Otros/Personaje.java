package Otros;

import Decorator.*;

public class Personaje implements ComponentePersonaje {

	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int evasion;
	protected String rol;
	protected char estrategia;
	//protected String estado;
	
	public Personaje(int vida, int ataque, int defensa, int evasion, String rol, char estrategia) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.evasion = evasion;
		this.rol = rol;
		this.estrategia = estrategia;
	}
	
	
	public int getVida() {
		return vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public int getEvasion() {
		return evasion;
	}
	
	public void setVida(int num) {
		this.vida = num;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
	public void setAtaque(int num) {
		ataque = num;
	}
	public void setDefensa(int num) {
		defensa = num;
	}
	
	public void verAtaque() {
		System.out.println("Ataque: " + ataque);
	}
	public void verDefensa() {
		System.out.println("Defensa: " + defensa);
	}
	public void verVida() {
		System.out.println("Vida del héroe: " + vida);
	}
	public void verEvasion() {
		System.out.println("Evasión: " + evasion);
	}
	
	public void verStats() {
		System.out.println("Rol: " + rol); 
		verAtaque();
		verDefensa();
		verVida();
		verEvasion();
	}
	
	public void interfazJugador(int opcion) { //interfaz para elegir las acciones jugador
		
		//hacer diferente de si es por un rol o por estrategia
		if(opcion == 1) {
			if(this.rol  == "asesino" ) {
				AsesinoDecorator heroeAsesino = new AsesinoDecorator(this);
				heroeAsesino.verAtaque();
				
				if(estrategia == 'O') {  //si es asesino y además tiene estrategia ofensiva
					AtaqueDecorator heroeAtaque = new AtaqueDecorator(heroeAsesino);
					heroeAtaque.verAtaque();
				}else if(estrategia == 'E') {
					EvasionDecorator heroeEvasion = new EvasionDecorator(heroeAsesino);
					heroeEvasion.verEvasion();
				}else{
					//heroeAsesino.verAtaque();
				}
				
			}else if(estrategia == 'O') {
				AtaqueDecorator heroeAtaque = new AtaqueDecorator(this);
				heroeAtaque.verAtaque();
			}else if(estrategia == 'E') {
				EvasionDecorator heroeEvasion= new EvasionDecorator(this);
				heroeEvasion.verEvasion();
			}
		}else if(opcion == 3) {
			if(rol == "defensor") {
				DefensorDecorator heroeDefensor = new DefensorDecorator(this);
				heroeDefensor.verDefensa();
				
				if(estrategia == 'D') {
					DefensaDecorator heroeDefensa = new DefensaDecorator(heroeDefensor);
					heroeDefensa.verDefensa();
				}else if(estrategia == 'E') {
					EvasionDecorator heroeEvasion = new EvasionDecorator(heroeDefensor);
					heroeEvasion.verEvasion();
				}else {
					//heroeDefensor.verDefensa();
				}
			}else if(estrategia == 'D') {
				DefensaDecorator heroeDefensa = new DefensaDecorator(this);
				heroeDefensa.verDefensa();
			}else if(estrategia == 'E') {
				EvasionDecorator heroeEvasion= new EvasionDecorator(this);
				heroeEvasion.verEvasion();
			}
		}else if(opcion == 2) {
			if(estrategia == 'E') {
				EvasionDecorator heroeEvasion = new EvasionDecorator(this);
				heroeEvasion.verEvasion();
			}
		}
	}
	
}
