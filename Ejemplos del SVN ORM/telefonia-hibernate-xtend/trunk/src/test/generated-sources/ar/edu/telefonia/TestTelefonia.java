package ar.edu.telefonia;

import ar.edu.telefonia.domain.Abonado;
import ar.edu.telefonia.domain.Empresa;
import ar.edu.telefonia.domain.Factura;
import ar.edu.telefonia.domain.Llamada;
import ar.edu.telefonia.domain.Residencial;
import ar.edu.telefonia.domain.Rural;
import ar.edu.telefonia.repo.RepoTelefonia;
import com.google.common.base.Objects;
import java.util.Date;
import java.util.List;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestTelefonia {
  private Abonado walterWhite;
  
  private Abonado jessePinkman;
  
  private RepoTelefonia homeTelefonia;
  
  private Llamada llamada1 = new Llamada(this.walterWhite, this.jessePinkman, Integer.valueOf(10));
  
  @Before
  public void init() {
    RepoTelefonia _instance = RepoTelefonia.getInstance();
    this.homeTelefonia = _instance;
    Residencial _residencial = new Residencial();
    this.walterWhite = _residencial;
    this.walterWhite.setNombre("Walter White");
    this.walterWhite.setNumero("46710080");
    Date _date = new Date(10, 1, 109);
    Factura _factura = new Factura(_date, 500, 240);
    this.walterWhite.agregarFactura(_factura);
    Date _date_1 = new Date(10, 1, 111);
    Factura _factura_1 = new Factura(_date_1, 1200, 600);
    this.walterWhite.agregarFactura(_factura_1);
    Rural _rural = new Rural(Integer.valueOf(100));
    this.jessePinkman = _rural;
    this.jessePinkman.setNombre("Jesse Pinkman");
    this.jessePinkman.setNumero("45673887");
    Date _date_2 = new Date(5, 5, 113);
    Factura _factura_2 = new Factura(_date_2, 1200, 1200);
    this.jessePinkman.agregarFactura(_factura_2);
    Abonado ibm = new Empresa("30-50396126-8");
    ibm.setNombre("IBM");
    ibm.setNumero("47609272");
    this.createIfNotExists(this.jessePinkman);
    final boolean existeIBM = this.createIfNotExists(ibm);
    final boolean existeWalterWhite = this.createIfNotExists(this.walterWhite);
    Abonado _abonado = this.homeTelefonia.getAbonado(this.jessePinkman, true);
    this.jessePinkman = _abonado;
    Abonado _abonado_1 = this.homeTelefonia.getAbonado(ibm, true);
    ibm = _abonado_1;
    Abonado _abonado_2 = this.homeTelefonia.getAbonado(this.walterWhite, true);
    this.walterWhite = _abonado_2;
    if ((!existeWalterWhite)) {
      Llamada llamada2 = new Llamada(this.walterWhite, ibm, Integer.valueOf(2));
      this.walterWhite.agregarLlamada(this.llamada1);
      this.walterWhite.agregarLlamada(llamada2);
      this.homeTelefonia.actualizarAbonado(this.walterWhite);
    }
    if ((!existeIBM)) {
      Llamada _llamada = new Llamada(ibm, this.jessePinkman, Integer.valueOf(5));
      ibm.agregarLlamada(_llamada);
      this.homeTelefonia.actualizarAbonado(ibm);
    }
  }
  
  public boolean createIfNotExists(final Abonado abonado) {
    boolean _xblockexpression = false;
    {
      Abonado _abonado = this.homeTelefonia.getAbonado(abonado);
      final boolean existe = (!Objects.equal(_abonado, null));
      if ((!existe)) {
        this.homeTelefonia.actualizarAbonado(abonado);
      }
      _xblockexpression = existe;
    }
    return _xblockexpression;
  }
  
  @Test
  public void walterWhiteTiene2Llamadas() {
    Abonado walterWhiteBD = this.homeTelefonia.getAbonado(this.walterWhite, true);
    List<Llamada> llamadasDeWalterWhite = walterWhiteBD.getLlamadas();
    int _size = llamadasDeWalterWhite.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test(expected = LazyInitializationException.class)
  public void walterWhiteTiene2LlamadasSinSesionHibernate() {
    final Abonado walterWhiteBD = this.homeTelefonia.getAbonado(this.walterWhite, false);
    List<Llamada> _llamadas = walterWhiteBD.getLlamadas();
    _llamadas.size();
  }
  
  @Test
  public void deudaDeWalterWhite() {
    final Abonado walterWhiteBD = this.homeTelefonia.getAbonado(this.walterWhite, true);
    Double _deuda = walterWhiteBD.deuda();
    Assert.assertEquals(860, (_deuda).doubleValue(), 0.1);
  }
  
  @Test
  public void walterWhiteCostoDeLlamada1() {
    final Abonado walterWhiteBD = this.homeTelefonia.getAbonado(this.walterWhite, true);
    float _costo = walterWhiteBD.costo(this.llamada1);
    Assert.assertEquals(20, _costo, 0.1);
  }
}
