package model;
import java.time.LocalDate;
<<<<<<< Updated upstream
import java.util.Calendar;


public interface VerificacionFecha {
	 int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
	    int MES = Calendar.MONTH;
	    int ANO = Calendar.YEAR;

	    /**
	     * Verifica si se cumple un mes entre la fecha de apertura y la fecha del sistema.
	     * 
	     * @return true si se cumple un mes, false en caso contrario.
	     */
	    boolean seCumpleMes();

	    /**
	     * Verifica si se cumple un año entre la fecha de apertura y la fecha del sistema.
	     * 
	     * @return true si se cumple un año, false en caso contrario.
	     */
	    boolean seCumpleAno();
=======

public interface VerificacionFecha {
	
	  
>>>>>>> Stashed changes
	   
   boolean hanPasadoTiempo(int meses, int anios);
	

}
