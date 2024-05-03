package Abstract_Factory;

import Singleton.*;

public interface EnemyFactory {

	EnemigoTanque creaTanque(Calculador calc);
	EnemigoAsesino creaAsesino(Calculador calc);
	EnemigoDefensor creaDefensor(Calculador calc);
	
}
