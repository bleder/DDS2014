package utn.edu.dds.TP_OPF5_VIEW.ui

import partido.core.Jugador
import org.apache.wicket.model.IModel
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.Component

interface ListaJugadoresPage {
	def String colorHandicap(Jugador jug)
	def void verJugador(Jugador jug)
	def IModel<Jugador> asCompoundModel(Jugador jugador)
	def void addChild(ListItem<Jugador> item, Component component)
	
}