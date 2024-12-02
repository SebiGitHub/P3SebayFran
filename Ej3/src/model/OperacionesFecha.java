package model;

import java.util.Calendar;
import java.util.Date;

public interface OperacionesFecha {
    // Constantes de Calendar en español
    int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
    int MES = Calendar.MONTH;
    int ANIO = Calendar.YEAR;

    // Métodos para verificar periodos
    boolean cumpleMes();
    boolean cumpleAnio();

    // Método auxiliar estático para verificar si una fecha es futura
    static boolean esFechaFutura(Date fecha) {
        return fecha.after(new Date());
    }
}
