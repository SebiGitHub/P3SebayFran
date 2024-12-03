package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {
    private JButton btnCargarArchivo;
    private JButton btnGuardarArchivo;
    private JButton btnVaciarLista;
    private JButton btnCargarPrueba;

    public PanelPrincipal() {
        // Establecemos el layout principal como BorderLayout
        setLayout(new BorderLayout());

        // Creamos el panel de botones con GridLayout para que ocupen todo el espacio
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10)); // 4 botones en columna, espacio entre ellos

        // Botón Cargar desde archivo
        btnCargarArchivo = new JButton("Cargar desde archivo");
        btnCargarArchivo.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente negrita y grande
        btnCargarArchivo.setBackground(Color.BLUE); // Fondo azul
        btnCargarArchivo.setForeground(Color.WHITE); // Texto blanco
        btnCargarArchivo.setFocusPainted(false); // Para evitar el borde al seleccionar
        panelBotones.add(btnCargarArchivo);

        // Botón Guardar en archivo
        btnGuardarArchivo = new JButton("Guardar en archivo");
        btnGuardarArchivo.setFont(new Font("Arial", Font.BOLD, 20));
        btnGuardarArchivo.setBackground(Color.GREEN);
        btnGuardarArchivo.setForeground(Color.WHITE);
        btnGuardarArchivo.setFocusPainted(false);
        panelBotones.add(btnGuardarArchivo);

        // Botón Vaciar lista
        btnVaciarLista = new JButton("Vaciar lista");
        btnVaciarLista.setFont(new Font("Arial", Font.BOLD, 20));
        btnVaciarLista.setBackground(Color.RED);
        btnVaciarLista.setForeground(Color.WHITE);
        btnVaciarLista.setFocusPainted(false);
        panelBotones.add(btnVaciarLista);

        // Botón Cargar datos de prueba
        btnCargarPrueba = new JButton("Cargar datos de prueba");
        btnCargarPrueba.setFont(new Font("Arial", Font.BOLD, 20));
        btnCargarPrueba.setBackground(Color.ORANGE);
        btnCargarPrueba.setForeground(Color.WHITE);
        btnCargarPrueba.setFocusPainted(false);
        panelBotones.add(btnCargarPrueba);

        // Agregamos el panel de botones al panel principal (en la parte central)
        add(panelBotones, BorderLayout.CENTER);

        // Ajustamos la ubicación de los botones para que siempre ocupen el espacio disponible
        setPreferredSize(new Dimension(600, 400)); // Ajusta el tamaño total del panel
    }

    // Métodos para agregar los listeners a los botones
    public void addCargarArchivoListener(ActionListener listener) {
        btnCargarArchivo.addActionListener(listener);
    }

    public void addGuardarArchivoListener(ActionListener listener) {
        btnGuardarArchivo.addActionListener(listener);
    }

    public void addVaciarListaListener(ActionListener listener) {
        btnVaciarLista.addActionListener(listener);
    }

    public void addCargarPruebaListener(ActionListener listener) {
        btnCargarPrueba.addActionListener(listener);
    }
}
