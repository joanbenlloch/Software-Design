package Template;

import java.util.Random;

/*
Ofensivo:
Atacar 80%
Esquivar 5%
Contraatacar 10%
*/

public class EnemigoOfensiva extends EnemigoEstrategia {
	
	public String accionOfensiva() {
		Random rand = new Random();
		int prob = rand.nextInt(101);
		String accion = "";
		
		if(prob <= 80) {
			accion = "atacar";
		}
		else if(prob > 80 && prob <= 85) {
			accion = "esquivar";
		}
		else if(prob > 85) {
			accion = "contraatacar";
		}
		
		return accion;
	}
	
	public String accionDefensiva() {
		return "";
	}

	public String accionEvasiva() {
		return "";
	}

}
