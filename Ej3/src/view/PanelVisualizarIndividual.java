package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.CtrlLista;
import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;
import model.SaldoInferiorException;

public class PanelVisualizarIndividual extends JPanel {
    private JComboBox<String> comboCuentas;
    private JPanel panelDetalles;
    private CtrlLista ctrlLista;

    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnCalcular;

    private int indexActual; // Mantener el índice de la cuenta actual

    public PanelVisualizarIndividual(CtrlLista ctrlLista) {
        this.ctrlLista = ctrlLista;
        this.indexActual = 0; // Empezamos con la primera cuenta

        setLayout(new BorderLayout());

        // Dropdown para seleccionar una cuenta
        comboCuentas = new JComboBox<>();
        comboCuentas.addActionListener(e -> mostrarDetallesCuenta());

        // Panel para mostrar los detalles de la cuenta
        panelDetalles = new JPanel();
        panelDetalles.setLayout(new GridLayout(0, 2, 10, 10)); // Dos columnas (etiqueta, valor)

        // Botones de navegación
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnCalcular = new JButton("Calcular");

        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCalcular);

        // Acción de los botones
        btnAnterior.addActionListener(e -> navegarCuenta(-1));  // Ir a la cuenta anterior
        btnSiguiente.addActionListener(e -> navegarCuenta(1));  // Ir a la cuenta siguiente
        btnCalcular.addActionListener(e -> calcularSaldo());

        // Desactivar botón calcular por defecto
        btnCalcular.setEnabled(false);

        add(comboCuentas, BorderLayout.NORTH);
        add(new JScrollPane(panelDetalles), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Actualizar las opciones del ComboBox con las cuentas
    public void actualizarOpciones(List<Cuenta> cuentas) {
        comboCuentas.removeAllItems();
        for (Cuenta cuenta : cuentas) {
            comboCuentas.addItem(cuenta.toString());
        }
        if (!cuentas.isEmpty()) {
            comboCuentas.setSelectedIndex(0);
            mostrarDetallesCuenta();
        }
    }

    // Mostrar los detalles de la cuenta seleccionada
    private void mostrarDetallesCuenta() {
        if (comboCuentas.getItemCount() > 0) {
            int index = comboCuentas.getSelectedIndex();
            if (index >= 0) {
                Cuenta cuentaSeleccionada = ctrlLista.obtenerDatosLista().get(index);
                panelDetalles.removeAll(); // Limpiar el panel antes de agregar los nuevos detalles

                // Crear y añadir las etiquetas y los campos de texto con los detalles de la cuenta
                panelDetalles.add(new JLabel("Número:"));
                panelDetalles.add(new JTextField(String.valueOf(cuentaSeleccionada.getNumero()), 15));
                
                panelDetalles.add(new JLabel("Titular:"));
                panelDetalles.add(new JTextField(cuentaSeleccionada.getTitular(), 15));
                
                panelDetalles.add(new JLabel("Saldo:"));
                panelDetalles.add(new JTextField(String.format("%.2f", cuentaSeleccionada.getSaldo()), 15));
                
                panelDetalles.add(new JLabel("Saldo Mínimo:"));
                panelDetalles.add(new JTextField(String.format("%.2f", cuentaSeleccionada.getSaldoMinimo()), 15));
                
                panelDetalles.add(new JLabel("Fecha de Apertura:"));
                panelDetalles.add(new JTextField(cuentaSeleccionada.getFechaApertura().toString(), 15));
                
                // Añadir detalles específicos de CuentaCorriente o CuentaAhorro
                if (cuentaSeleccionada instanceof CuentaCorriente) {
                    CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaSeleccionada;
                    panelDetalles.add(new JLabel("Comisión Mantenimiento:"));
                    panelDetalles.add(new JTextField(String.format("%.2f", cuentaCorriente.getComisionMantenimiento()), 15));

                    panelDetalles.add(new JLabel("Tipo de Comisión:"));
                    panelDetalles.add(new JTextField(cuentaCorriente.getTipoComision(), 15));
                } else if (cuentaSeleccionada instanceof CuentaAhorro) {
                    CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentaSeleccionada;
                    panelDetalles.add(new JLabel("Interés Anual:"));
                    panelDetalles.add(new JTextField(String.format("%.2f", cuentaAhorro.getInteresAnual()), 15));

                    panelDetalles.add(new JLabel("Beneficio Adicional:"));
                    panelDetalles.add(new JTextField(cuentaAhorro.getBeneficioAdicional(), 15));
                }

                panelDetalles.revalidate(); // Asegurarse de que el panel se actualice correctamente
                panelDetalles.repaint(); // Forzar el repaint del panel

                indexActual = index;

                // Verificar si se cumple el periodo para habilitar el botón calcular
                verificarPeriodo(cuentaSeleccionada);
            }
        }
    }

    // Navegar entre cuentas (anterior o siguiente)
    private void navegarCuenta(int direccion) {
        int totalCuentas = comboCuentas.getItemCount();
        indexActual += direccion;

        if (indexActual < 0) {
            indexActual = totalCuentas - 1; // Volver al final si estamos al principio
        } else if (indexActual >= totalCuentas) {
            indexActual = 0; // Volver al principio si estamos al final
        }

        comboCuentas.setSelectedIndex(indexActual); // Actualizar la selección en el combo
        mostrarDetallesCuenta(); // Mostrar los detalles de la cuenta seleccionada
    }

    // Verificar si el periodo mensual o anual se cumple para habilitar el botón de calcular
    private void verificarPeriodo(Cuenta cuenta) {
        Calendar fechaCuenta = Calendar.getInstance();
        fechaCuenta.setTime(cuenta.getFechaApertura());

        Calendar fechaActual = Calendar.getInstance();
        int diferenciaMeses = fechaActual.get(Calendar.MONTH) - fechaCuenta.get(Calendar.MONTH);
        int diferenciaAnios = fechaActual.get(Calendar.YEAR) - fechaCuenta.get(Calendar.YEAR);

        if (diferenciaMeses >= 1 || diferenciaAnios >= 1) {
            btnCalcular.setEnabled(true);
        } else {
            btnCalcular.setEnabled(false);
        }
    }

    // Calcular el saldo de la cuenta incrementándolo o decrementándolo
    private void calcularSaldo() {
        Cuenta cuentaSeleccionada = ctrlLista.obtenerDatosLista().get(indexActual);

        // Verificar si el saldo es suficiente antes de realizar cualquier cálculo
        if (cuentaSeleccionada.getSaldo() < cuentaSeleccionada.getSaldoMinimo()) {
            JOptionPane.showMessageDialog(this, "El saldo es inferior al saldo mínimo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (cuentaSeleccionada instanceof CuentaCorriente) {
                ((CuentaCorriente) cuentaSeleccionada).calcularOperacion(); // Llamada al método calcularOperacion
            } else if (cuentaSeleccionada instanceof CuentaAhorro) {
                ((CuentaAhorro) cuentaSeleccionada).calcularOperacion(); // Llamada al método calcularOperacion para aplicar interés
            }

            mostrarDetallesCuenta();
        } catch (SaldoInferiorException e) {
            JOptionPane.showMessageDialog(this, "Error al calcular el saldo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
