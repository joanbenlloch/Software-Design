package Template;

import java.util.Random;

/*
Evasivo
Atacar 60%
Esquivar 30%
Contraatacar 10%
*/

public class EnemigoEvasiva extends EnemigoEstrategia {
	
	public String accionOfensiva() {
		return "";
	}
	
	public String accionDefensiva() {
		return "";
	}

	public String accionEvasiva() {
		
		Random rand = new Random();
		int prob = rand.nextInt(101);
		String accion = "";
		
		if(prob <= 60) {
			accion = "atacar";
		}
		else if(prob > 60 && prob <= 90) {
			accion = "esquivar";
		}
		else if(prob > 90) {
			accion = "contraatacar";
		}
		
		return accion;
	}
}
