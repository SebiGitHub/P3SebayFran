package view;

import controller.CtrlLista;
import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuBarPrincipal {
    private JFrame frame;
    private JPanel mainPanel;
    private PanelPrincipal panelPrincipal;
    private PanelAgregarCC panelAgregarCC;
    private PanelAgregarCA panelAgregarCA;
    private PanelVisualizarTodo panelVisualizarTodo;
    private CtrlLista ctrlLista; // Controlador de la lista

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
        panelAgregarCC = new PanelAgregarCC(ctrlLista);
        panelAgregarCA = new PanelAgregarCA(ctrlLista);
        panelVisualizarTodo = new PanelVisualizarTodo();

        // Agregar los paneles al mainPanel
        mainPanel.add(panelPrincipal, "MenuPrincipal");
        mainPanel.add(panelAgregarCC, "AgregarCuentaCorriente");
        mainPanel.add(panelAgregarCA, "AgregarCuentaAhorro");
        mainPanel.add(panelVisualizarTodo, "VisualizarTodo");

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Opciones del menú
        JMenuItem menuPrincipalItem = new JMenuItem("Menú Principal");
        JMenuItem agregarCuentaCCItem = new JMenuItem("Agregar Cuenta Corriente");
        JMenuItem agregarCuentaCAItem = new JMenuItem("Agregar Cuenta Ahorro");
        JMenuItem visualizarTodoItem = new JMenuItem("Visualizar Todo");

        // Añadir opciones a la barra de menú
        menuBar.add(menuPrincipalItem);
        menuBar.add(agregarCuentaCCItem);
        menuBar.add(agregarCuentaCAItem);
        menuBar.add(visualizarTodoItem);

        // Listeners para cambiar de panel
        menuPrincipalItem.addActionListener(e -> switchPanel("MenuPrincipal"));
        agregarCuentaCCItem.addActionListener(e -> switchPanel("AgregarCuentaCorriente"));
        agregarCuentaCAItem.addActionListener(e -> switchPanel("AgregarCuentaAhorro"));
        visualizarTodoItem.addActionListener(e -> {
            // Actualizar lista antes de mostrar el panel
            panelVisualizarTodo.actualizarLista(ctrlLista.obtenerDatosLista());
            switchPanel("VisualizarTodo");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuBarPrincipal::new);
    }
}
