package view;

import controller.CtrlLista;
import model.FechaInvalidaException;
import model.SaldoInferiorException;

import javax.swing.*;
import java.awt.*;

public class MenuBarPrincipal {
    private JFrame frame;
    private JPanel mainPanel;
    private PanelPrincipal panelPrincipal;
    private PanelAgregarCC panelAgregarCC;
    private PanelAgregarCA panelAgregarCA;
    private PanelVisualizarTodo panelVisualizarTodo;
    private PanelVisualizarIndividual panelVisualizarIndividual; // Nuevo panel
    private CtrlLista ctrlLista; // Controlador de la lista
    private JMenuBar menuBar;

    
    public MenuBarPrincipal() {
        // Configuración del frame principal
        frame = new JFrame("Gestión de Cuentas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Controlador para la lista
        ctrlLista = new CtrlLista();

        // Crear los paneles y el mainPanel
        mainPanel = new JPanel(new CardLayout());
        panelPrincipal = new PanelPrincipal();

        try {
            panelAgregarCC = new PanelAgregarCC(ctrlLista);
			panelAgregarCA = new PanelAgregarCA(ctrlLista);
		} catch (FechaInvalidaException | SaldoInferiorException e) {
			e.printStackTrace();
		}
        panelVisualizarTodo = new PanelVisualizarTodo();
        panelVisualizarIndividual = new PanelVisualizarIndividual(ctrlLista);

        // Agregar los paneles al mainPanel
        mainPanel.add(panelPrincipal, "MenuPrincipal");
        mainPanel.add(panelAgregarCC, "AgregarCuentaCorriente");
        mainPanel.add(panelAgregarCA, "AgregarCuentaAhorro");
        mainPanel.add(panelVisualizarTodo, "VisualizarTodo");
        mainPanel.add(panelVisualizarIndividual, "VisualizarIndividual");

        // Crear la barra de menú
        menuBar = new JMenuBar();

        // Crear los menús "Menu Principal", "Agregar" y "Visualizar"
        JMenu menuPrincipal = new JMenu("Menú Principal");
        JMenu agregarMenu = new JMenu("Agregar");
        JMenu visualizarMenu = new JMenu("Visualizar");

        // Crear los ítems del menú
        JMenuItem menuPrincipalItem = new JMenuItem("Menú");
        JMenuItem agregarCuentaCCItem = new JMenuItem("Cuenta Corriente");
        JMenuItem agregarCuentaCAItem = new JMenuItem("Cuenta Ahorro");
        JMenuItem visualizarTodoItem = new JMenuItem("Todo");
        JMenuItem visualizarIndividualItem = new JMenuItem("Individualmente");

        // Añadir los ítems a los submenús correspondientes
        menuPrincipal.add(menuPrincipalItem);
        agregarMenu.add(agregarCuentaCCItem);
        agregarMenu.add(agregarCuentaCAItem);
        visualizarMenu.add(visualizarTodoItem);
        visualizarMenu.add(visualizarIndividualItem);

        // Añadir los menús a la barra de menú
        menuBar.add(menuPrincipal);
        menuBar.add(agregarMenu);
        menuBar.add(visualizarMenu);

        // Listeners para cambiar de panel
        menuPrincipalItem.addActionListener(e -> switchPanel("MenuPrincipal"));
        agregarCuentaCCItem.addActionListener(e -> switchPanel("AgregarCuentaCorriente"));
        agregarCuentaCAItem.addActionListener(e -> switchPanel("AgregarCuentaAhorro"));
        visualizarTodoItem.addActionListener(e -> {
            // Actualizar lista antes de mostrar el panel
            panelVisualizarTodo.actualizarLista(ctrlLista.obtenerDatosLista());
            switchPanel("VisualizarTodo");
        });
        visualizarIndividualItem.addActionListener(e -> {
            // Actualizar datos disponibles en el panel individual
            panelVisualizarIndividual.actualizarOpciones(ctrlLista.obtenerDatosLista());
            switchPanel("VisualizarIndividual");
        });

        // Conectar botones del panel principal con el controlador
        panelPrincipal.addCargarArchivoListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                ctrlLista.cargarDesdeArchivo(fileChooser.getSelectedFile());
            }
        });

        panelPrincipal.addGuardarArchivoListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                ctrlLista.guardarEnArchivo(fileChooser.getSelectedFile());
            }
        });

        panelPrincipal.addVaciarListaListener(e -> ctrlLista.vaciarLista());

        panelPrincipal.addCargarPruebaListener(e -> ctrlLista.cargarPruebas());

        // Agregar los componentes al frame
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    // Método para cambiar de panel
    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }
}
