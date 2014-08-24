package arena.prueba

import java.awt.Color
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.ErrorsPanel

/**
 * Ejemplo de conversor millas -> kilometros en xtend
 */
class ConversorWindow extends MainWindow<Conversor> {
	new() {
		super(new Conversor)
	}

	override createContents(Panel mainPanel) {
		this.setTitle("Conversor de millas a kilometros (XTend)")
		mainPanel.setLayout(new VerticalLayout)
		
		new ErrorsPanel(mainPanel, "Listo para convertir")

		new Label(mainPanel).setText("Ingrese la longitud en millas")

		new TextBox(mainPanel).bindValueToProperty("millas")

		new Button(mainPanel) => [
			caption = "Convertir a kilometros"
			onClick [ | this.modelObject.convertir ]
		]

		new Label(mainPanel)
			.setBackground(Color::ORANGE)
			.bindValueToProperty("kilometros")

		new Label(mainPanel).setText(" kilometros")
	}

	def static main(String[] args) {
		new ConversorWindow().startApplication
	}

}