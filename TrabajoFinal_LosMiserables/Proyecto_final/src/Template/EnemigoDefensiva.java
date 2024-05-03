package Template;

import java.util.Random;

/*
Defensivo
Atacar 50%
Esquivar 20%
Contraatacar 30%
*/

public class EnemigoDefensiva extends EnemigoEstrategia {
	
	public String accionOfensiva() {
		return "";
	}
	
	public String accionDefensiva() {
		Random rand = new Random();
		int prob = rand.nextInt(101);
		String accion = "";
		
		if(prob <= 50) {
			accion = "atacar";
		}
		else if(prob > 50 && prob <= 70) {
			accion = "esquivar";
		}
		else if(prob > 70) {
			accion = "contraatacar";
		}
		
		return accion;
	}

	public String accionEvasiva() {
		return "";
	}

}
