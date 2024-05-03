package Strategy;

public class Contexto{
	private Gestor_Strategy dios;
	public Contexto(Gestor_Strategy dios)
	{
		this.dios=dios;
	}
	public char getEstrategia()
	{
		return dios.MetodoEstrategia();
	}
}
