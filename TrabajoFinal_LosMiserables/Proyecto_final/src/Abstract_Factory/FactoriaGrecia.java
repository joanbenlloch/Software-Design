package Abstract_Factory;

import Singleton.*;

public class FactoriaGrecia implements EnemyFactory{
	
	public EnemigoTanque creaTanque(Calculador calc) {
		return new Tanque_Grecia(400, 300, 400, 150, 'O', "sano", "tanque", calc, "Aquiles de Grecia");  //los tanques siguen una estrategia Ofensiva (O)
	}
	public EnemigoAsesino creaAsesino(Calculador calc) {
		return new Asesino_Grecia(200, 400, 100, 500, 'E', "sano", "asesino", calc, "Ayax de Grecia"); //los asesinos siguen una estrategia Evasiva (E)
	}
	public EnemigoDefensor creaDefensor(Calculador calc) {
		return new Defensor_Grecia(300, 200, 550, 200, 'D', "sano", "defensor", calc, "Odiseo de Grecia"); //los defensores siguen una estrategia Defensiva (D)
	}
	
	public EnemigoAsesino creaDios(Calculador calc) {
		return new Atenea(650, 700, 300, 600, 'E', "sano", "asesino", calc, "Atenea, diosa de la sabiduría");
	}

}
