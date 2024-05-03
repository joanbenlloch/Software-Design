package Facade;

import java.util.*;
import java.util.ArrayList;

import Abstract_Factory.*;
import Otros.Enemigo;
import Otros.Personaje;
import Singleton.*;
import Template.*;
import Strategy.*;
import State.*;	

public class GameController {
	
	Scanner entrada = new Scanner(System.in);
	
	protected int faccion; // 1=Grecia   2=Troya
	protected String strFaccion;
	protected int nombreHeroe; 
	protected String strHeroe;
	protected int nombreDios;
	protected String strDios;
	protected Personaje heroe;
	protected char estrategia;
	protected String rol;
	protected int batallaActual;
	
	//tendremos los siguientes enemigos
	protected Calculador calc;
	protected EnemigoAsesino asesino;
	protected EnemigoTanque tanque;
	protected EnemigoDefensor defensor;
	
	protected EnemigoAsesino Atenea;
	protected EnemigoTanque Ares;
	
	protected ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
	
	
	
	public void start() //funcion que se llama desde el main y que lleva el orden de acontecimientos.
	{
		this.batallaActual = 0;
		System.out.println("_______________LA GUERRA DE TROYA_______________\n"
				+ "   ,,)\\.~,,.\r\n"
				+ "   (()`  ``)\\))),,_\r\n"
				+ "    |     \\ ''((\\)))),,_          __\r\n"
				+ "    |6`   |   ''((\\())) \"-.__.-\"    `-.-,\r\n"
				+ "    |    .'\\    ''))))'                  \\)))\r\n"
				+ "    |   |   `.     ''                     ((((\r\n"
				+ "    \\, _)     \\/                          |))))\r\n"
				+ "     `'        |                          (((((\r\n"
				+ "               \\                  |       ))))))\r\n"
				+ "                `|    |           ,\\     /((((((\r\n"
				+ "                 |   / `-.__.<  \\   |   /  )))))\r\n"
				+ "                 |   |  /         `. \\  \\  ((((\r\n"
				+ "                 |  / \\ |           `.\\  | (((\r\n"
				+ "                 \\  | | |             \\| |  ))\r\n"
				+ "                  | | ooo              / /ooo   '\r\n"
				+ "               ooo| |o___o___________ooo_o_  o\r\n"
				+ "              o   o_________________o   o_/oo \r\n"
				+ "               ooo                   ooo");
		
		elegirFaccion();
		elegirHeroe();
		elegirDios();
		
		this.calc = Calculador.instance(heroe);
		
		fabricaEnemigos();
		
		for(int i=0;i<listaEnemigos.size();i++) {  //empezamos con los combates
			
			listaEnemigos.get(i).mostrarDatos();
			combate(listaEnemigos.get(i));  //combatimos con un enemigo en cada turno
			
			if(heroe.getVida()<=0) {
				break;  //si el héroe muere, sale del bucle de combates
			}
		}
		
		if(heroe.getVida() > 0 && strFaccion == "Grecia") {
			System.out.println("¡Enhorabuena! Eres el nuevo héroe de Grecia, les diste para el pelo a esos troyanos.");
			
		}else if(heroe.getVida() > 0 && strFaccion == "Troya") {
			System.out.println("¡Hurra! Eres la salvación de Troya, esos griegos no tuvieron ninguna posibilidad.");
			
		}else {  //esta opción es si el heroe tiene 0 o menos puntos de vida, es decir, está muerto
			System.out.println("Nuestro valiente héroe no pudo contra sus feroces enemigos, que le dieron muerte en el campo de batalla.");
		}
		
	}
	//menú para elegir facción
	public void elegirFaccion() {
		
		System.out.println("Elige Faccion: \n1.Grecia  2.Troya");
		
		faccion = entrada.nextInt();
		
		while(faccion != 1 && faccion != 2) {
			System.out.println("Selecciona una faccion valida: 1 / 2");
			faccion = entrada.nextInt();		
		}
		strFaccion = faccionStr(faccion);
	}
	
	public String faccionStr(int i) {
		String strFaccion;
		if (i == 1) {
			strFaccion = "Grecia";
		}else {
			strFaccion = "Troya";
		}
		return strFaccion;
		
	}
	
	//menu para elegir personaje
	
	public void elegirHeroe() {
		if(strFaccion == "Grecia") {
			System.out.println("Personajes de Grecia: \n 1.Aquiles (Tanque)\n 2.Ayax (Asesino)"
					+ "\n 3.Odiseo (Defensor)\n\n ");
			System.out.println("Elige uno de los heroes: \n");
			
			nombreHeroe = entrada.nextInt();
			while(nombreHeroe<  1 || nombreHeroe > 3) {
				System.out.println("Selecciona un personaje valido: 1 - 3");
				nombreHeroe = entrada.nextInt();		
			}
			
			this.strHeroe = heroeGrecia(nombreHeroe);
			
		}else if(strFaccion == "Troya") {
			System.out.println("Personajes de Troya: \n 1.Hector (Tanque)\n 2.Paris (Asesino)"
					+ "\n 3.Eneas (Defensor)\n\n ");
			System.out.println("Elige uno de los heroes: \n");
			
			nombreHeroe = entrada.nextInt();
			while(nombreHeroe<  1 || nombreHeroe > 3) {
				System.out.println("Selecciona un personaje valido: 1 - 3");
				nombreHeroe = entrada.nextInt();		
			}
			this.strHeroe = heroeTroya(nombreHeroe);
		}
		
		crearPersonaje();
		
	}
	
	public String heroeTroya(int i) {
		String strHeroe;
		strHeroe  = "";
		if (i == 1) {
			strHeroe = "Hector";
			this.rol = "tanque";
		}else if(i == 2){
			strHeroe = "Paris";
			this.rol = "asesino";
		}else if (i == 3){
			strHeroe = "Eneas";
			this.rol = "defensor";
		}
		
		return strHeroe;
	}
	public String heroeGrecia(int i) {
		String strHeroe;
		strHeroe  = "";
		if (i == 1) {
			strHeroe = "Aquiles";
			this.rol = "tanque";
		}else if(i == 2){
			strHeroe = "Ayax";
			this.rol = "asesino";
		}else if (i == 3){
			strHeroe = "Odiseo";
			this.rol = "defensor";
		}
		return strHeroe;
	}
	
	public void crearPersonaje() {
		
		if(rol == "tanque") {
			this.heroe = new Personaje(1000, 400, 350, 150, rol, estrategia);
			
		}else if(rol == "asesino") {
			this.heroe = new Personaje(500, 600, 250, 550, rol, estrategia);
			
		}else if(rol == "defensor") {
			this.heroe = new Personaje(0, 500, 600, 250, rol, estrategia);
			
		}
		
	}
	
	
	//menú para establecer dios
	
	public void elegirDios() {
		
		if(strFaccion == "Grecia") {
			System.out.println("Dioses de Grecia: \n 1.Atenea \n 2.Poseidon"
					+ "\n 3.Hera\n\n ");
			System.out.println("Elige la bendicion de uno de los dioses: \n");
			
			nombreDios = entrada.nextInt();
			while(nombreDios<  1 || nombreDios > 3) {
				System.out.println("Selecciona un dios valido: 1 - 3");
				nombreDios = entrada.nextInt();		
			}
			strDios = strDiosGrecia(nombreDios);
		}else if(strFaccion == "Troya") {
			System.out.println("Dioses de Troya: \n 1.Ares \n 2.Apollo "
					+ "\n 3.Afrodita\n\n ");
			System.out.println("Elige uno de los heroes: \n");
			
			nombreDios = entrada.nextInt();
			while(nombreDios<  1 || nombreDios > 3) {
				System.out.println("Selecciona un dios valido: 1 - 3");
				nombreDios = entrada.nextInt();		
			}
			
			strDios = strDiosTroya(nombreDios);
		}
		
		establecerDios();
	}
	
	public String strDiosGrecia(int i) {
		String strDios;
		switch(i) {
			case 1:
				strDios = "Atenea";
				break;
			case 2:
				strDios = "Poseidon";
				break;
			case 3:
				strDios = "Hera";
				break;
			default:
				strDios = "";
				break;
		}
		return strDios;
	}
	public String strDiosTroya(int i) {
		String strDios;
		switch(i) {
			case 1:
				strDios = "Ares";
				break;
			case 2:
				strDios = "Apollo";
				break;
			case 3:
				strDios = "Afrodita";
				break;
			default:
				strDios = "";
				break;
		}
		return strDios;
	}
	
	
	
	//Llamada al Strategy
	public void establecerDios() { 
		Contexto c;
		
		switch(strDios) {
			case "Ares":
				c = new Contexto(new Ofensiva());
				estrategia = c.getEstrategia();
				break;
			case "Apollo":
				c = new Contexto(new Defensiva());
				estrategia = c.getEstrategia();
				break;
			case "Afrodita":
				c = new Contexto(new Evasiva());
				estrategia = c.getEstrategia();
				break;
			case "Atenea":
				c = new Contexto(new Ofensiva());
				estrategia = c.getEstrategia();
				break;
			case "Poseidon":
				c = new Contexto(new Defensiva());
				estrategia = c.getEstrategia();
				break;
			case "Hera":
				c = new Contexto(new Evasiva());
				estrategia = c.getEstrategia();
				break;
			default:
				System.out.printf("Error\n");
				break;
		}
	
	}
	
	public void fabricaEnemigos() {//inicializa todos los enemigos del bando contrario al elegir bando
		
		//los hemos creado de esta manera para que el patrón Abstract Factory tenga sentido y se use como tal
		
		if(strFaccion == "Grecia") { //la facción elegida es Grecia
			
			FactoriaTroya enemigosT = new FactoriaTroya();   //creamos todos los enemigos de Troya
			asesino = enemigosT.creaAsesino(calc);   //creamos un EnemigoAsesino, que hace todo los que un Enemigo
			tanque = enemigosT.creaTanque(calc);
			defensor = enemigosT.creaDefensor(calc);
			Ares = enemigosT.creaDios(calc);
			listaEnemigos.add(asesino);
			listaEnemigos.add(tanque);
			listaEnemigos.add(defensor);
			listaEnemigos.add(Ares);
			
		}else {  //en este caso, la facción elegida es Troya
			
			FactoriaGrecia enemigosG = new FactoriaGrecia();
			asesino = enemigosG.creaAsesino(calc);
			tanque = enemigosG.creaTanque(calc);
			defensor = enemigosG.creaDefensor(calc);
			Atenea = enemigosG.creaDios(calc);
			listaEnemigos.add(tanque);
			listaEnemigos.add(defensor);
			listaEnemigos.add(asesino);
			listaEnemigos.add(Atenea);
		}
		
	}

	
	public void combate(Enemigo enemigo) { //do while hasta derrotar al dios rival o nos maten
		
		do {
			//PRIMERO ELIGE EL JUGADOR
			System.out.println("¿Qué acción realizarás ahora?\n1- Atacar\n2- Esquivar\n3- Defender/contraatacar");
			int opcion = entrada.nextInt();
			heroe.interfazJugador(opcion);  //muestra los decoradores
			boolean esquivar = false;
			
			if(opcion == 1) {
				calc.atacar_enemigo(enemigo);
			}else if(opcion == 2) {
				esquivar = calc.esquivar_jugador(enemigo);
			}else if(opcion == 3) {
				calc.contra_personaje(enemigo);
			}
			
			//DESPUÉS ACTÚA EL ENEMIGO, SEGÚN LA ESTRATEGIA (los enemigos siempre tienen la misma estrategia: Tanques-ofensiva, Defensores-defensiva, Asesinos-evasiva)
			if(enemigo.getEstrategia() == 'D') {
				EnemigoDefensiva estrategiaEnemigo = new EnemigoDefensiva();
				String accion = estrategiaEnemigo.accion(enemigo.getEstrategia());
				
				if(accion == "atacar") {
					if(!esquivar) {
						enemigo.ataqueDefensor();
					}
				}else if(accion == "esquivar") {
					enemigo.esquivarDefensor();
				}else if(accion == "contraatacar") {
					enemigo.contraataqueDefensor();
				}
			}else if(enemigo.getEstrategia() == 'O') {
				EnemigoOfensiva estrategiaEnemigo = new EnemigoOfensiva();
				String accion = estrategiaEnemigo.accion(enemigo.getEstrategia());
				
				if(accion == "atacar") {
					if(!esquivar) {
						enemigo.ataqueTanque();
					}
				}else if(accion == "esquivar") {
					enemigo.esquivarTanque();
				}else if(accion == "contraatacar") {
					enemigo.contraataqueTanque();
				}
			}else if(enemigo.getEstrategia() == 'E') {
				EnemigoEvasiva estrategiaEnemigo = new EnemigoEvasiva();
				String accion = estrategiaEnemigo.accion(enemigo.getEstrategia());
				
				if(accion == "atacar") {
					if(!esquivar) {
						enemigo.ataqueAsesino();
					}
				}else if(accion == "esquivar") {
					enemigo.esquivarAsesino();
				}else if(accion == "contraatacar") {
					enemigo.contraataqueAsesino();
				}
			}
			
			//A continuación, comprobamos el estado de los personajes
			ComprobarEstado estados = new ComprobarEstado();  //clase con la que comprobaremos el estado de los enemigos y del personajeç
			estados.estadoPersonaje(heroe, heroe.getVida());
			estados.estadoEnemigo(enemigo, enemigo.getVida());  //con esto veríamos los estados del personaje y del enemigo combatiendo en ese momento
			
			heroe.verVida();
			enemigo.verVida();
			
		}while(heroe.getVida()>0 && enemigo.getVida()>0);  //si ninguno de los dos constrincantes ha muerto todavía, se continua el combate
		
	}

	
	
}
