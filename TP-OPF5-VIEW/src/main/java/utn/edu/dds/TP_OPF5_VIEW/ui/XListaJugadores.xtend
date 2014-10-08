package utn.edu.dds.TP_OPF5_VIEW.ui

import org.uqbar.wicket.xtend.XListView
import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.basic.Label
import org.uqbar.wicket.xtend.XButton
import partido.core.Jugador
import org.apache.wicket.markup.html.list.ListItem

class XListaJugadores extends XListView<Jugador> {
	
	new(String id, ListaJugadoresPage page) {
		super(id)
		this.populateItem = [ ListItem<Jugador> item |
			item.model = page.asCompoundModel(item.modelObject)
			val colorAzul = new AttributeModifier("class", page.colorHandicap(item.modelObject))
			page.addChild(item, new Label("nombre").add(colorAzul))
			page.addChild(item, new Label("apodo").add(colorAzul))
			page.addChild(item, new Label("nivelJuego").add(colorAzul))
			page.addChild(item, new Label("promedioUltimoPartido").add(colorAzul))
			page.addChild(item, new XButton("verDatos").onClick = [| page.verJugador(item.modelObject) ])
		]
	}
	
}