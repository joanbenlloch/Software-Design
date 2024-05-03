package Abstract_Factory;

import Singleton.*;

public class FactoriaTroya implements EnemyFactory{

	
	public EnemigoTanque creaTanque(Calculador calc) {
		return new Tanque_Troya(400, 300, 200, 100, 'O', "sano", "tanque", calc, "Hector de Troya");
	}
	public EnemigoAsesino creaAsesino(Calculador calc) {
		return new Asesino_Troya(200, 500, 200, 500, 'E', "sano", "asesino", calc, "Paris de Troya");
	}
	public EnemigoDefensor creaDefensor(Calculador calc) {
		return new Defensor_Troya(300, 200, 700, 300, 'D', "sano", "defensor", calc, "Eneas de Troya");
	}
	public EnemigoTanque creaDios(Calculador calc) {
		return new Ares(750, 300, 250, 150, 'O', "sano", "tanque", calc, "Ares, dios de la guerra");
	}
}
