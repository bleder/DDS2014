import org.junit.Before
import org.junit.Test
import org.junit.Assert

class TstInscripcion {
	
	var Jugador jugador
	var Partido partido
	var Estandar tipoIncEstandar
	var Condicional tipoIncCondicional
	var Solidaria tipoIncSolidaria

@Before

	def void init() {

		jugador = new Jugador ("Rodolfo")
		partido = new Partido ("Partido_1")
		tipoIncEstandar = new Estandar()
		tipoIncCondicional = new Condicional()
		tipoIncSolidaria = new Solidaria()

		}
//Caso 1: Inscribir jugador con modo inscripcion estandar lista del partido <10
@Test


def void inscribirJugadorModoEstandarListaMenor10(){

	Assert.assertTrue(jugador.inscribite("Partido_1",tipoIncEstandar))
	}

//Caso 2: Inscribir jugador con modo inscripcion estandar lista del partido >10
@Test	

def void inscribirJugadorModoEstandarListaMayor10(){

	Assert.assertFalse(jugador.Inscribite("Partido_1",tipoIncEstandar))
	}

@Test	
//Caso 3: Inscribir jugador con modo inscripcion solidaria lista del partido <10	

def void inscribirJugadorModoSolidarioListaMenor10(){

	Assert.assertTrue(jugador.Inscribite("Partido_1",tipoIncSolidaria))
	}	

@Test	
//Caso 4 : Inscribir jugador con modo inscripcion solidaria lista del partido >10	

def void inscribirJugadorModoSolidarioListaMayor10(){

	Assert.assertFalse(jugador.Inscribite("Partido_1",tipoIncSolidaria))
	}	

@Test	
//Caso 5 : Inscribir jugador con modo inscripcion condicional cumple condicion	

def void inscribirJugadorModoCondicionalCumpleCondicion(){

	Assert.assertTrue(jugador.Inscribite("Partido_1",tipoIncCondicional))
	}	

@Test	
//Caso 6 : Inscribir jugador con modo inscripcion condicional no cumple condicion	

def void inscribirJugadorModoCondicionalNoCumpleCondicion(){

	Assert.assertFalse(jugador.Inscribite("Partido_1",tipoIncCondicional))
	}	

@Test		
//Caso 7: Inscribir jugador con modo inscripcion estandar lista del partido >10 con un jugador solidario

def void inscribirJugadorModoEstandarListaMayor10ConUnSolidario(){

	Assert.assertTrue(jugador.Inscribite("Partido_1",tipoIncEstandar))
	}	

@Test		
//Caso 8: Inscribir jugador con modo inscripcion estandar lista del partido >10 con mas de un jugador solidario

def void inscribirJugadorModoEstandarListaMayor10ConMasSolidario(){

	Assert.assertTrue(jugador.Inscribite("Partido_1",tipoIncEstandar))
	}						 
