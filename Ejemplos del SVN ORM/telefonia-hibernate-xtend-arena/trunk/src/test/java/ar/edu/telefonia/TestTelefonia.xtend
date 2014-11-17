package ar.edu.telefonia

import ar.edu.telefonia.domain.Abonado
import ar.edu.telefonia.domain.Empresa
import ar.edu.telefonia.domain.Factura
import ar.edu.telefonia.domain.Llamada
import ar.edu.telefonia.domain.Residencial
import ar.edu.telefonia.domain.Rural
import ar.edu.telefonia.repo.RepoTelefonia
import java.util.Date
import org.hibernate.LazyInitializationException
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestTelefonia {

	Abonado walterWhite
	Abonado jessePinkman
	RepoTelefonia repoTelefonia
	Llamada llamada1 = new Llamada(walterWhite, jessePinkman, 10)

	@Before
	def init() {
		repoTelefonia = RepoTelefonia.instance

		walterWhite = new Residencial => [
			nombre = "Walter White"
			numero = "46710080"
			agregarFactura(new Factura(new Date(10, 1, 109), 500, 240))
			agregarFactura(new Factura(new Date(10, 1, 111), 1200, 600))
		]

		jessePinkman = new Rural(100) => [
			nombre = "Jesse Pinkman"
			numero = "45673887"
			agregarFactura(new Factura(new Date(5, 5, 113), 1200, 1200))
		]

		var Abonado ibm = new Empresa("30-50396126-8") => [
			nombre = "IBM"
			numero = "47609272"
		]

		createIfNotExists(jessePinkman)
		val existeIBM = createIfNotExists(ibm)
		val existeWalterWhite = createIfNotExists(walterWhite)

		jessePinkman = repoTelefonia.getAbonado(jessePinkman, true)
		ibm = repoTelefonia.getAbonado(ibm, true)
		walterWhite = repoTelefonia.getAbonado(walterWhite, true)

		// El update lo tenemos que hacer por separado por las referencias circulares
		if (!existeWalterWhite) {
			var Llamada llamada2 = new Llamada(walterWhite, ibm, 2)
			walterWhite.agregarLlamada(llamada1)
			walterWhite.agregarLlamada(llamada2)
			repoTelefonia.actualizarAbonado(walterWhite)
		}

		if (!existeIBM) {
			ibm.agregarLlamada(new Llamada(ibm, jessePinkman, 5))
			repoTelefonia.actualizarAbonado(ibm)
		}
	}

	def createIfNotExists(Abonado abonado) {
		val existe = repoTelefonia.getAbonado(abonado) != null
		if (!existe) {
			repoTelefonia.actualizarAbonado(abonado)
		}
		existe
	}

	@Test
	def void walterWhiteTiene2Llamadas() {
		var walterWhiteBD = repoTelefonia.getAbonado(walterWhite, true)
		var llamadasDeWalterWhite = walterWhiteBD.llamadas
		Assert.assertEquals(2, llamadasDeWalterWhite.size)
	}

	@Test(expected=LazyInitializationException)
	def void walterWhiteTiene2LlamadasSinSesionHibernate() {
		val walterWhiteBD = repoTelefonia.getAbonado(walterWhite, false)
		walterWhiteBD.llamadas.size
	}

	@Test
	def void deudaDeWalterWhite() {
		val walterWhiteBD = repoTelefonia.getAbonado(walterWhite, true)
		Assert.assertEquals(860, walterWhiteBD.deuda, 0.1)
	}

	@Test
	def void walterWhiteCostoDeLlamada1() {
		val walterWhiteBD = repoTelefonia.getAbonado(walterWhite, true)
		Assert.assertEquals(20, walterWhiteBD.costo(llamada1), 0.1)
	}

}
