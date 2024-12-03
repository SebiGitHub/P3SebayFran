package view;

import javax.swing.SwingUtilities;

public class Main {

	//Main que inicializa el menu Bar con su panelPrincipal
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MenuBarPrincipal());
		
	}

}
