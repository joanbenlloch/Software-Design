package Singleton;

import Otros.Enemigo;
import Otros.Personaje;

public class Calculador {
	private int vida_pj, vida_en, dam_pj, dam_en, def_pj, def_en, ev_pj, ev_en;
	private String estado_en, rol_pj;
	private char estrategia_pj;
	//private Personaje jugador = new Personaje (vida_pj, dam_pj, def_pj, ev_pj, rol_pj, estrategia_pj, estado_pj);
	private Personaje jugador = new Personaje (vida_pj, dam_pj, def_pj, ev_pj, rol_pj, estrategia_pj);
	//private Enemigo enemy;
	private static Calculador instance = null; 
	
	private Calculador(Personaje pj) {
		this.jugador=pj;
	}
	
	public static Calculador instance(Personaje pj) {
		if(instance == null) {
			instance = new Calculador(pj);
		}
		
		return instance;
	}
	
	//Ataque hacia un jugador
	public void atacar_jugador(Enemigo enemy) {
			int vp=jugador.getVida();
			int dp=jugador.getDefensa();
			int de=enemy.getAtaque();
			
			vp-=(de/(dp/10));
			
			jugador.setVida(vp);
			
			System.out.println("El enemigo ha atacado, ¡has sido herido!");
	}
	
	//Ataque hacia un enemigo
	public void atacar_enemigo(Enemigo enemy) {
			int ve=enemy.getVida();
			int de=enemy.getDefensa();
			int dp=jugador.getAtaque();
			
			ve-=(dp/(de/10));
			
			enemy.setVida(ve);
			
			System.out.println("Se atacó al enemigo, un golpe certero");
	}
	
	//Personaje contrataca
	public void contra_personaje(Enemigo enemy) {
		int probabilidad=(int) (Math.random()*1001);
		
		if(probabilidad > jugador.getDefensa()) {
			atacar_jugador(enemy);
			System.out.println("Fallaste el contraataque, el enemigo te ha alcanzado...");
		}else{
			//Jugador recibe daño
			int vp=jugador.getVida();
			int dp=jugador.getDefensa();
			int de=enemy.getAtaque()/3;
			
			vp-=(de/(dp/10));
			
			jugador.setVida(vp);
			
			//Lo devuelve
			int ve=enemy.getVida();
			int devolucion=enemy.getAtaque()*(2/3);
			
			ve-=(devolucion/(dp/10));
			
			enemy.setVida(ve);
			
			System.out.println("El enemigo te alcanzó, ¡pero devolviste el golpe!");
		}
	}
	
	//Enemigo contrataca
	public void contra_enemy(Enemigo enemy) {
		int probabilidad=(int) (Math.random()*1001);
		
		if(probabilidad > enemy.getDefensa()) {
			atacar_enemigo(enemy);
			System.out.println("El enemigo trata de contraatacar, ¡pero eres más fuerte!");
		}else{
			//Enemigo recibe daño
			int ve=enemy.getVida();
			int de=enemy.getDefensa();
			int dp=jugador.getAtaque()/3;
			
			ve-=(dp/(de/10));
			
			enemy.setVida(ve);
			
			//Lo devuelve
			int vp=jugador.getVida();
			int devolucion=jugador.getAtaque()*(2/3);
			
			vp-=(devolucion/(de/10));
			
			jugador.setVida(vp);
			
			System.out.println("El enemigo es alcanzado, pero golpeo más fuerte...");
		}
	}
	
	//Jugador esquiva
	public boolean esquivar_jugador(Enemigo enemy) {
		boolean esquivado = false;
		int probabilidad=(int) (Math.random()*1001);
		
		if(probabilidad > jugador.getEvasion()) {
			atacar_jugador(enemy);
			System.out.println("No consigues evadir el atque, el enemigo te golpea...");
		}else{
			esquivado = true;
			int ve=enemy.getVida();
			int de=enemy.getDefensa();
			int dp=jugador.getAtaque()/5;
			
			ve-=(dp/(de/10));
			
			enemy.setVida(ve);
			System.out.println("Has esquivado el ataque enemigo, ¡le dañas un poco!");
		}
		return esquivado;
	}
	
	//Enemigo esquiva
	public void esquivar_enemigo(Enemigo enemy) {
		int probabilidad=(int) (Math.random()*1001);
		
		if(probabilidad > enemy.getEvasion()) {
			atacar_enemigo(enemy);
			System.out.println("El enemigo trata de esquivarte, ¡pero te adelantas a sus movimientos!");
		}else{
			int vp=jugador.getVida();
			int dp=jugador.getDefensa();
			int de=enemy.getAtaque()/5;
			
			vp-=(de/(dp/10));
			
			jugador.setVida(vp);
			System.out.println("El enemigo ha esquivado tu ataque, te ha dañado un poco...");
		}
	}

	//GETTERS & SETTERS
	public int getVida_en() {
		return vida_en;
	}

	public void setVida_en(int vida_en) {
		this.vida_en = vida_en;
	}

	public int getDam_en() {
		return dam_en;
	}

	public void setDam_en(int dam_en) {
		this.dam_en = dam_en;
	}

	public int getDef_en() {
		return def_en;
	}

	public void setDef_en(int def_en) {
		this.def_en = def_en;
	}

	public int getEv_en() {
		return ev_en;
	}

	public void setEv_en(int ev_en) {
		this.ev_en = ev_en;
	}

	public String getEstado_en() {
		return estado_en;
	}

	public void setEstado_en(String estado_en) {
		this.estado_en = estado_en;
	}

	public Personaje getJugador() {
		return jugador;
	}

	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}
	
}
