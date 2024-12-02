package view;

import javax.swing.*;
import java.awt.*;

public class PanelVisualizarIndividual extends JPanel {
    private JLabel lblCuenta;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnCalcular;

    public PanelVisualizarIndividual() {
        setLayout(new BorderLayout());

        lblCuenta = new JLabel("Cuenta actual: ");
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnCalcular = new JButton("Calcular");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(btnAnterior);
        botonesPanel.add(btnSiguiente);
        botonesPanel.add(btnCalcular);

        add(lblCuenta, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);
    }

    public void actualizarCuenta(String cuentaInfo) {
        lblCuenta.setText("Cuenta actual: " + cuentaInfo);
    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }
}
