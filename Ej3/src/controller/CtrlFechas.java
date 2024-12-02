package controller;

import java.util.Date;

public class CtrlFechas {
    public static boolean esFechaFutura(Date fecha) {
        return fecha.after(new Date());
    }
}
