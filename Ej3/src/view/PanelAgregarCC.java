package view;

import javax.swing.*;

import controller.CtrlLista;

import java.awt.*;
import java.util.Date;

public class PanelAgregarCC extends JPanel {
    private JRadioButton rbCuentaAhorro;
    private JRadioButton rbCuentaCorriente;
    private JTextField txtNumero;
    private JTextField txtTitular;
    private JTextField txtSaldo;
    private JTextField txtSaldoMinimo;
    private JSpinner spinnerFecha;
    private JTextField txtAtributoExtra;
    private JButton btnAgregar;

    public PanelAgregarCC(CtrlLista ctrlLista) {
        setLayout(new GridLayout(9, 2));

        ButtonGroup group = new ButtonGroup();
        rbCuentaAhorro = new JRadioButton("Cuenta de Ahorro");
        rbCuentaCorriente = new JRadioButton("Cuenta Corriente");
        group.add(rbCuentaAhorro);
        group.add(rbCuentaCorriente);

        txtNumero = new JTextField();
        txtTitular = new JTextField();
        txtSaldo = new JTextField();
        txtSaldoMinimo = new JTextField();
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        txtAtributoExtra = new JTextField();
        btnAgregar = new JButton("Agregar Cuenta");

        add(new JLabel("Tipo de cuenta:"));
        add(rbCuentaAhorro);
        add(new JLabel());
        add(rbCuentaCorriente);

        add(new JLabel("Número:"));
        add(txtNumero);

        add(new JLabel("Titular:"));
        add(txtTitular);

        add(new JLabel("Saldo:"));
        add(txtSaldo);

        add(new JLabel("Saldo mínimo:"));
        add(txtSaldoMinimo);

        add(new JLabel("Fecha de apertura:"));
        add(spinnerFecha);

        add(new JLabel("Atributo extra:"));
        add(txtAtributoExtra);

        add(new JLabel());
        add(btnAgregar);
    }

    public String getTipoCuenta() {
        if (rbCuentaAhorro.isSelected()) {
            return "Ahorro";
        } else if (rbCuentaCorriente.isSelected()) {
            return "Corriente";
        }
        return null;
    }

    public int getNumero() throws NumberFormatException {
        return Integer.parseInt(txtNumero.getText());
    }

    public String getTitular() {
        return txtTitular.getText();
    }

    public double getSaldo() throws NumberFormatException {
        return Double.parseDouble(txtSaldo.getText());
    }

    public double getSaldoMinimo() throws NumberFormatException {
        return Double.parseDouble(txtSaldoMinimo.getText());
    }

    public Date getFechaApertura() {
        return (Date) spinnerFecha.getValue();
    }

    public String getAtributoExtra() {
        return txtAtributoExtra.getText();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
}
