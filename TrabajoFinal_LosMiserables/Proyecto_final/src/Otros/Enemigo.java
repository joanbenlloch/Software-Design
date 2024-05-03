package Otros;

import Singleton.*;

public abstract class Enemigo{
	protected int vida;
	protected int ataque;
	protected int defensa;
	protected int evasion;
	protected char estrategia;
	protected String estado;
	protected String rol;
	protected Calculador calc;
	protected String nombre;
	
	public Enemigo(int vida, int ataque, int defensa, int evasion, char estrategia, String estado, String rol, Calculador calc, String nombre) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.evasion = evasion;
		this.estrategia = estrategia;
		this.estado = estado;
		this.rol = rol;
		this.calc = calc;
		this.nombre = nombre;
	}
	
	public abstract void ataqueTanque();
	public abstract void ataqueDefensor();
	public abstract void ataqueAsesino();
	public abstract void ataqueDios();
	
	public abstract void contraataqueTanque();
	public abstract void contraataqueDefensor();
	public abstract void contraataqueAsesino();
	public abstract void contraataqueDios();

	
	public abstract void esquivarTanque();
	public abstract void esquivarDefensor();
	public abstract void esquivarAsesino();
	public abstract void esquivarDios();

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public char getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(char estrategia) {
		this.estrategia = estrategia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void mostrarDatos() {
		System.out.println("Tu enemigo "+nombre+" esta listo para el combate, su salud es de "+vida+" y esta "+estado);
		System.out.println("Rol: " + rol); 
	}
	
	public void verVida() {
		System.out.println("Vida del Enemigo: " + getVida());
	}
	
}
