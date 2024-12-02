package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel {
    private JButton btnCargarArchivo;
    private JButton btnGuardarArchivo;
    private JButton btnVaciarLista;
    private JButton btnCargarPrueba;

    public PanelPrincipal() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        btnCargarArchivo = new JButton("Cargar desde archivo");
        btnGuardarArchivo = new JButton("Guardar en archivo");
        btnVaciarLista = new JButton("Vaciar lista");
        btnCargarPrueba = new JButton("Cargar datos de prueba");

        add(btnCargarArchivo);
        add(btnGuardarArchivo);
        add(btnVaciarLista);
        add(btnCargarPrueba);
    }

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
