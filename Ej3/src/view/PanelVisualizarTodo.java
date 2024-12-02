package view;

import javax.swing.*;
import java.awt.*;

public class PanelVisualizarTodo extends JPanel {
    private JList<String> listaCuentas;
    private DefaultListModel<String> modeloLista;

    public PanelVisualizarTodo() {
        setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        listaCuentas = new JList<>(modeloLista);

        add(new JScrollPane(listaCuentas), BorderLayout.CENTER);
    }

    public void actualizarLista(String[] datos) {
        modeloLista.clear();
        for (String dato : datos) {
            modeloLista.addElement(dato);
        }
    }

    public String getCuentaSeleccionada() {
        return listaCuentas.getSelectedValue();
    }
}
