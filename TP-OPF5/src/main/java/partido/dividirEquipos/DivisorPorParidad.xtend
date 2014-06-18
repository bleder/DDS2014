package partido.dividirEquipos

import partido.core.Partido

class DivisorPorParidad extends DivisorDeEquipos{
	
	
	override dividirEquiposDeUnPartido(Partido partido)
	{
		for (a : 0 ..<partido.jugadoresInscriptos.size)
		{
			if (a%2==0)
			{
				partido.equipo1.add(partido.jugadoresInscriptos.get(a).jugador)
			}
			else
			{
				partido.equipo2.add(partido.jugadoresInscriptos.get(a).jugador)
			}
		}
		
	}
}