package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import model.Cuenta;

public class PanelVisualizarTodo extends JPanel {
    private JList<String> listaCuentas;
    private DefaultListModel<String> modeloLista;

    public PanelVisualizarTodo() {
        setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        listaCuentas = new JList<>(modeloLista);

        add(new JScrollPane(listaCuentas), BorderLayout.CENTER);
    }

    // Actualizar la lista con los datos de las cuentas
    public void actualizarLista(List<Cuenta> cuentas) {
        modeloLista.clear(); // Limpiar el modelo actual

        // Agregar cuentas a la lista
        for (Cuenta cuenta : cuentas) {
            modeloLista.addElement(cuenta.toString()); // Mostrar solo los datos como texto
        }
    }
}
