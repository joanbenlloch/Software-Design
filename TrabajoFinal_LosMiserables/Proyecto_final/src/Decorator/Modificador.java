/*package Decorator;

import java.util.*;

import Otros.Personaje;

public class Modificador {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String rol = "defensor";
		String estrategia = "defensiva";
		
		Personaje heroe = new Personaje(100, 20, 50, 60, rol, estrategia);
		
		System.out.println("¿Qué acción realizará tu héroe?\n1- Atacar\n2- Defender");
		int opcion = entrada.nextInt();
		
		//hacer diferente de si es por un rol o por estrategia
		if(opcion == 1) {
			if(rol == "asesino") {
				AsesinoDecorator heroeAsesino = new AsesinoDecorator(heroe);
				heroeAsesino.verAtaque();
				
				if(estrategia == "ofensiva") {  //si es asesino y además tiene estrategia ofensiva
					AtaqueDecorator heroeAtaque = new AtaqueDecorator(heroeAsesino);
					heroeAtaque.verAtaque();
				}else if(estrategia == "evasiva") {
					EvasionDecorator heroeEvasion = new EvasionDecorator(heroeAsesino);
					heroeEvasion.verEvasion();
				}else{
					//heroeAsesino.verAtaque();
				}
				
			}else if(estrategia == "ofensiva") {
				AtaqueDecorator heroeAtaque = new AtaqueDecorator(heroe);
				heroeAtaque.verAtaque();
			}else if(estrategia == "evasiva") {
				EvasionDecorator heroeEvasion= new EvasionDecorator(heroe);
				heroeEvasion.verEvasion();
			}
		}else if(opcion == 2) {
			if(rol == "defensor") {
				DefensorDecorator heroeDefensor = new DefensorDecorator(heroe);
				heroeDefensor.verDefensa();
				
				if(estrategia == "defensiva") {
					DefensaDecorator heroeDefensa = new DefensaDecorator(heroeDefensor);
					heroeDefensa.verDefensa();
				}else if(estrategia == "evasiva") {
					EvasionDecorator heroeEvasion = new EvasionDecorator(heroeDefensor);
					heroeEvasion.verEvasion();
				}else {
					//heroeDefensor.verDefensa();
				}
			}else if(estrategia == "defensiva") {
				DefensaDecorator heroeDefensa = new DefensaDecorator(heroe);
				heroeDefensa.verDefensa();
			}else if(estrategia == "evasiva") {
				EvasionDecorator heroeEvasion= new EvasionDecorator(heroe);
				heroeEvasion.verEvasion();
			}
		}
	}

}*/
