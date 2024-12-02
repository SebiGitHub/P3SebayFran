package view;

import javax.swing.*;
import controller.CtrlLista;

import java.awt.*;
import java.util.Date;

public class PanelAgregarCC extends JPanel {
    private JTextField txtNumero;
    private JTextField txtTitular;
    private JTextField txtSaldo;
    private JTextField txtSaldoMinimo;
    private JSpinner spinnerFecha;
    private JTextField txtComisionMantenimiento;
    private JTextField txtTipoComision;
    private JButton btnAgregar;

    public PanelAgregarCC(CtrlLista ctrlLista) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear una fuente más grande para las etiquetas
        Font etiquetaFont = new Font("Arial", Font.BOLD, 18);
        Font campoFont = new Font("Arial", Font.PLAIN, 16); // Fuente para campos de texto y botones

        // Campo Número
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(crearEtiqueta("Número:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtNumero = new JTextField();
        txtNumero.setFont(campoFont);
        txtNumero.setPreferredSize(new Dimension(200, 30)); // Tamaño más grande
        add(txtNumero, gbc);

        // Campo Titular
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(crearEtiqueta("Titular:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtTitular = new JTextField();
        txtTitular.setFont(campoFont);
        txtTitular.setPreferredSize(new Dimension(200, 30));
        add(txtTitular, gbc);

        // Campo Saldo
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(crearEtiqueta("Saldo:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtSaldo = new JTextField();
        txtSaldo.setFont(campoFont);
        txtSaldo.setPreferredSize(new Dimension(200, 30));
        add(txtSaldo, gbc);

        // Campo Saldo mínimo
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(crearEtiqueta("Saldo mínimo:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtSaldoMinimo = new JTextField();
        txtSaldoMinimo.setFont(campoFont);
        txtSaldoMinimo.setPreferredSize(new Dimension(200, 30));
        add(txtSaldoMinimo, gbc);

        // Campo Fecha de apertura
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(crearEtiqueta("Fecha de apertura:", etiquetaFont), gbc);

        gbc.gridx = 1;
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(editor);
        spinnerFecha.setFont(campoFont);
        spinnerFecha.setPreferredSize(new Dimension(200, 30));
        add(spinnerFecha, gbc);

        // Campo Comisión de mantenimiento
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(crearEtiqueta("Comisión de mantenimiento:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtComisionMantenimiento = new JTextField();
        txtComisionMantenimiento.setFont(campoFont);
        txtComisionMantenimiento.setPreferredSize(new Dimension(200, 30));
        add(txtComisionMantenimiento, gbc);

        // Campo Tipo de comisión
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(crearEtiqueta("Tipo de comisión:", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtTipoComision = new JTextField();
        txtTipoComision.setFont(campoFont);
        txtTipoComision.setPreferredSize(new Dimension(200, 30));
        add(txtTipoComision, gbc);

        // Botón Agregar
        gbc.gridx = 1;
        gbc.gridy = 7;
        btnAgregar = new JButton("Agregar Cuenta");
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        btnAgregar.setPreferredSize(new Dimension(200, 40)); // Tamaño más grande
        add(btnAgregar, gbc);
    }

    // Método para crear etiquetas con estilo personalizado
    private JLabel crearEtiqueta(String texto, Font font) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(font);
        return etiqueta;
    }

    // Métodos para obtener los valores de los campos
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

    public double getComisionMantenimiento() throws NumberFormatException {
        return Double.parseDouble(txtComisionMantenimiento.getText());
    }

    public String getTipoComision() {
        return txtTipoComision.getText();
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
}
