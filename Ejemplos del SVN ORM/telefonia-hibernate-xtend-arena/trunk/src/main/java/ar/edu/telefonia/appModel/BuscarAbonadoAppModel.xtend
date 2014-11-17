package ar.edu.telefonia.appModel

import ar.edu.telefonia.domain.Abonado
import ar.edu.telefonia.repo.RepoTelefonia
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
class BuscarAbonadoAppModel {
	@Property BusquedaAbonados busquedaAbonados
	@Property List<Abonado> abonados
	@Property Abonado abonadoSeleccionado
	
	new() {
		busquedaAbonados = new BusquedaAbonados
		abonados = new ArrayList<Abonado>	
	}
	
	def void buscar() {
		abonados = RepoTelefonia.instance.getAbonados(busquedaAbonados)
	}
	
	def void limpiar() {
		busquedaAbonados.clear()
		abonados.clear()
		abonadoSeleccionado = null
	}
	
	def eliminarAbonado() {
		RepoTelefonia.getInstance().eliminarAbonado(abonadoSeleccionado)
		this.buscar
	}
	
}