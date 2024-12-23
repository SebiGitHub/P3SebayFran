package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import controller.CtrlFechas;
import controller.CtrlLista;
import model.Beneficio;
import model.CuentaAhorro;
import model.FechaInvalidaException;
import model.SaldoInferiorException;

public class PanelAgregarCA extends JPanel {
    private JTextField txtNumero;
    private JTextField txtTitular;
    private JTextField txtSaldo;
    private JTextField txtSaldoMinimo;
    private JSpinner spinnerFecha;
    private JTextField txtInteresAnual;
    private JComboBox<Beneficio> comboBeneficioAdicional;
    private JButton btnAgregar;

    public PanelAgregarCA(CtrlLista ctrlLista) throws FechaInvalidaException, SaldoInferiorException {
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

        // Campo Interés anual
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(crearEtiqueta("Interés anual (%):", etiquetaFont), gbc);

        gbc.gridx = 1;
        txtInteresAnual = new JTextField();
        txtInteresAnual.setFont(campoFont);
        txtInteresAnual.setPreferredSize(new Dimension(200, 30));
        add(txtInteresAnual, gbc);

        // Campo Beneficio adicional (ahora un JComboBox con las opciones del enum Beneficio)
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(crearEtiqueta("Beneficio adicional:", etiquetaFont), gbc);

        gbc.gridx = 1;
        comboBeneficioAdicional = new JComboBox<>(Beneficio.values()); // Llenamos el JComboBox con los valores del enum
        comboBeneficioAdicional.setFont(campoFont);
        comboBeneficioAdicional.setPreferredSize(new Dimension(200, 30));
        add(comboBeneficioAdicional, gbc);

        // Botón Agregar
        gbc.gridx = 1;
        gbc.gridy = 7;
        btnAgregar = new JButton("Agregar Cuenta");
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 16));
        btnAgregar.setPreferredSize(new Dimension(200, 40));
        add(btnAgregar, gbc);

        // Acción al presionar el botón Agregar
        btnAgregar.addActionListener(e -> {
            try {
                // Crear la cuenta según los datos ingresados
                int numero = Integer.parseInt(txtNumero.getText());
                String titular = txtTitular.getText();
                double saldo = Double.parseDouble(txtSaldo.getText());
                double saldoMinimo = Double.parseDouble(txtSaldoMinimo.getText());
                Date fechaApertura = (Date) spinnerFecha.getValue();

                // Comprobar si la fecha es futura utilizando CtrlFechas
                if (CtrlFechas.esFechaFutura(fechaApertura)) {
                    JOptionPane.showMessageDialog(this, "La fecha de apertura no puede ser futura.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si la fecha es futura
                }

                // Comprobar si el saldo es menor al saldo mínimo
                if (saldo < saldoMinimo) {
                    throw new SaldoInferiorException("El saldo es inferior al saldo mínimo requerido. El saldo mínimo es: " + saldoMinimo);
                }

                // Crear la cuenta de ahorro (o puedes usar otra clase según sea necesario)
                double interesAnual = Double.parseDouble(txtInteresAnual.getText());
                Beneficio beneficioAdicional = (Beneficio) comboBeneficioAdicional.getSelectedItem(); // Obtener el beneficio seleccionado

                // Crear la cuenta de ahorro (o de otro tipo si es necesario)
                CuentaAhorro nuevaCuenta = new CuentaAhorro(numero, titular, saldo, saldoMinimo, fechaApertura, interesAnual, beneficioAdicional);

                // Agregar la cuenta al controlador
                ctrlLista.agregarCuenta(nuevaCuenta);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Cuenta agregada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos
                txtNumero.setText("");
                txtTitular.setText("");
                txtSaldo.setText("");
                txtSaldoMinimo.setText("");
                spinnerFecha.setValue(new Date());
                txtInteresAnual.setText("");
                comboBeneficioAdicional.setSelectedIndex(0); // Reseteamos el combo box al primer valor
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SaldoInferiorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Método para crear etiquetas con estilo personalizado
    private JLabel crearEtiqueta(String texto, Font font) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(font);
        return etiqueta;
    }
}
