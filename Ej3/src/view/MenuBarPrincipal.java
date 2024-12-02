package view;

import java.awt.CardLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarPrincipal {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel menuPrincipalPanel;
    private JPanel agregarCuentaPanel;
    private JPanel visualizarPanel;

    public MenuBarPrincipal() {
        frame = new JFrame("Barra de Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear los paneles
        mainPanel = new JPanel(new CardLayout());
        menuPrincipalPanel = new JPanel();
        agregarCuentaPanel = new JPanel();
        visualizarPanel = new JPanel();

        // Configuración de cada panel
        menuPrincipalPanel.add(new JLabel("Bienvenido al Menú Principal"));
        agregarCuentaPanel.add(new JLabel("Panel para Agregar Cuenta"));
        visualizarPanel.add(new JLabel("Panel para Visualizar"));

        // Añadir los paneles al mainPanel
        mainPanel.add(menuPrincipalPanel, "MenuPrincipal");
        mainPanel.add(agregarCuentaPanel, "AgregarCuenta");
        mainPanel.add(visualizarPanel, "Visualizar");

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear menú
        JMenu menu = new JMenu("Opciones");

        // Crear items del menú
        JMenuItem menuPrincipalItem = new JMenuItem("Menú Principal");
        JMenuItem agregarCuentaItem = new JMenuItem("Agregar Cuenta");
        JMenuItem visualizarItem = new JMenuItem("Visualizar");

        // Agregar ActionListeners para cambiar de panel
        menuPrincipalItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("MenuPrincipal");
            }
        });

        agregarCuentaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("AgregarCuenta");
            }
        });

        visualizarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("Visualizar");
            }
        });

        // Agregar items al menú
        menu.add(menuPrincipalItem);
        menu.add(agregarCuentaItem);
        menu.add(visualizarItem);

        // Agregar menú a la barra de menú
        menuBar.add(menu);

        // Configurar el frame
        frame.setJMenuBar(menuBar);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Método para cambiar de panel
    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }
}
