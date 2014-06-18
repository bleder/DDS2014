package partido.dividirEquipos

import partido.core.Partido

class DivisorPorPosiciones extends DivisorDeEquipos{

	override dividirEquiposDeUnPartido(Partido partido)
	{
		for (a : 0 ..< partido.jugadoresInscriptos.size)
		{
			if (a==0 || a==2 || a==4 || a==6 || a==8 )
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