package Template;

public abstract class EnemigoEstrategia{
	
	
	public final String accion(char estrategia) {
		String accion = "";
		
		if(estrategia == 'O') { //Estrategia ofensiva
			accion = accionOfensiva();
		}
		else if(estrategia == 'D') { //Estrategia defensiva
			accion = accionDefensiva();
		}
		else if(estrategia == 'E') { //Estrategia evasiva
			accion = accionEvasiva();
		}
		
		return accion;
	}
	
	public abstract String accionOfensiva();
	public abstract String accionDefensiva();
	public abstract String accionEvasiva();
}
