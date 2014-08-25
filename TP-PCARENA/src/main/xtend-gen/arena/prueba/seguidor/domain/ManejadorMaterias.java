package arena.prueba.seguidor.domain;

import arena.prueba.seguidor.domain.Materia;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ManejadorMaterias {
  private List<Materia> _materias = new ArrayList<Materia>();
  
  public List<Materia> getMaterias() {
    return this._materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this._materias = materias;
  }
}
