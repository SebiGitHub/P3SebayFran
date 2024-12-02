package view;
import java.util.*;
//////////////////////////////////////////////////////////////////
// Interfaz IFecha: m�todos y constantes para obtener
//                  el d�a, mes y a�o
//

public interface IFecha
{
  public final static int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
  public final static int MES_DEL_A�O = Calendar.MONTH;
  public final static int A�O = Calendar.YEAR;
  
  public abstract int d�a();
  public abstract int mes();
  public abstract int a�o();
}
//////////////////////////////////////////////////////////////////

/*
  public int d�a()
  {
    GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(DIA_DEL_MES);
  }
  public int mes()
  {
    GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(MES_DEL_A�O)+1;
  }
  public int a�o()
  {
    GregorianCalendar fechaActual = new GregorianCalendar();
    return fechaActual.get(A�O);
  }
*/