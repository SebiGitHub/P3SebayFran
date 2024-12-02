package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {
    private JButton btnCargarArchivo;
    private JButton btnGuardarArchivo;
    private JButton btnVaciarLista;
    private JButton btnCargarPrueba;

    public PanelPrincipal() {

        btnCargarArchivo = new JButton("Cargar desde archivo");
        btnCargarArchivo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCargarArchivo.setBounds(20, 238, 131, 21);
        btnGuardarArchivo = new JButton("Guardar en archivo");
        btnGuardarArchivo.setBounds(20, 269, 119, 21);
        btnVaciarLista = new JButton("Vaciar lista");
        btnVaciarLista.setBounds(206, 269, 83, 21);
        btnCargarPrueba = new JButton("Cargar datos de prueba");
        btnCargarPrueba.setBounds(299, 269, 141, 21);
        setLayout(null);

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
