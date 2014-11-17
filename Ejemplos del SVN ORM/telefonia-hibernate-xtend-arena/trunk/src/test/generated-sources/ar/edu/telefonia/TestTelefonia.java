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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestTelefonia {
  private Abonado walterWhite;
  
  private Abonado jessePinkman;
  
  private RepoTelefonia repoTelefonia;
  
  private Llamada llamada1 = new Llamada(this.walterWhite, this.jessePinkman, Integer.valueOf(10));
  
  @Before
  public void init() {
    RepoTelefonia _instance = RepoTelefonia.getInstance();
    this.repoTelefonia = _instance;
    Residencial _residencial = new Residencial();
    final Procedure1<Residencial> _function = new Procedure1<Residencial>() {
      public void apply(final Residencial it) {
        it.setNombre("Walter White");
        it.setNumero("46710080");
        Date _date = new Date(10, 1, 109);
        Factura _factura = new Factura(_date, 500, 240);
        it.agregarFactura(_factura);
        Date _date_1 = new Date(10, 1, 111);
        Factura _factura_1 = new Factura(_date_1, 1200, 600);
        it.agregarFactura(_factura_1);
      }
    };
    Residencial _doubleArrow = ObjectExtensions.<Residencial>operator_doubleArrow(_residencial, _function);
    this.walterWhite = _doubleArrow;
    Rural _rural = new Rural(Integer.valueOf(100));
    final Procedure1<Rural> _function_1 = new Procedure1<Rural>() {
      public void apply(final Rural it) {
        it.setNombre("Jesse Pinkman");
        it.setNumero("45673887");
        Date _date = new Date(5, 5, 113);
        Factura _factura = new Factura(_date, 1200, 1200);
        it.agregarFactura(_factura);
      }
    };
    Rural _doubleArrow_1 = ObjectExtensions.<Rural>operator_doubleArrow(_rural, _function_1);
    this.jessePinkman = _doubleArrow_1;
    Empresa _empresa = new Empresa("30-50396126-8");
    final Procedure1<Empresa> _function_2 = new Procedure1<Empresa>() {
      public void apply(final Empresa it) {
        it.setNombre("IBM");
        it.setNumero("47609272");
      }
    };
    Abonado ibm = ObjectExtensions.<Empresa>operator_doubleArrow(_empresa, _function_2);
    this.createIfNotExists(this.jessePinkman);
    final boolean existeIBM = this.createIfNotExists(ibm);
    final boolean existeWalterWhite = this.createIfNotExists(this.walterWhite);
    Abonado _abonado = this.repoTelefonia.getAbonado(this.jessePinkman, true);
    this.jessePinkman = _abonado;
    Abonado _abonado_1 = this.repoTelefonia.getAbonado(ibm, true);
    ibm = _abonado_1;
    Abonado _abonado_2 = this.repoTelefonia.getAbonado(this.walterWhite, true);
    this.walterWhite = _abonado_2;
    if ((!existeWalterWhite)) {
      Llamada llamada2 = new Llamada(this.walterWhite, ibm, Integer.valueOf(2));
      this.walterWhite.agregarLlamada(this.llamada1);
      this.walterWhite.agregarLlamada(llamada2);
      this.repoTelefonia.actualizarAbonado(this.walterWhite);
    }
    if ((!existeIBM)) {
      Llamada _llamada = new Llamada(ibm, this.jessePinkman, Integer.valueOf(5));
      ibm.agregarLlamada(_llamada);
      this.repoTelefonia.actualizarAbonado(ibm);
    }
  }
  
  public boolean createIfNotExists(final Abonado abonado) {
    boolean _xblockexpression = false;
    {
      Abonado _abonado = this.repoTelefonia.getAbonado(abonado);
      final boolean existe = (!Objects.equal(_abonado, null));
      if ((!existe)) {
        this.repoTelefonia.actualizarAbonado(abonado);
      }
      _xblockexpression = existe;
    }
    return _xblockexpression;
  }
  
  @Test
  public void walterWhiteTiene2Llamadas() {
    Abonado walterWhiteBD = this.repoTelefonia.getAbonado(this.walterWhite, true);
    List<Llamada> llamadasDeWalterWhite = walterWhiteBD.getLlamadas();
    int _size = llamadasDeWalterWhite.size();
    Assert.assertEquals(2, _size);
  }
  
  @Test(expected = LazyInitializationException.class)
  public void walterWhiteTiene2LlamadasSinSesionHibernate() {
    final Abonado walterWhiteBD = this.repoTelefonia.getAbonado(this.walterWhite, false);
    List<Llamada> _llamadas = walterWhiteBD.getLlamadas();
    _llamadas.size();
  }
  
  @Test
  public void deudaDeWalterWhite() {
    final Abonado walterWhiteBD = this.repoTelefonia.getAbonado(this.walterWhite, true);
    Double _deuda = walterWhiteBD.deuda();
    Assert.assertEquals(860, (_deuda).doubleValue(), 0.1);
  }
  
  @Test
  public void walterWhiteCostoDeLlamada1() {
    final Abonado walterWhiteBD = this.repoTelefonia.getAbonado(this.walterWhite, true);
    float _costo = walterWhiteBD.costo(this.llamada1);
    Assert.assertEquals(20, _costo, 0.1);
  }
}
