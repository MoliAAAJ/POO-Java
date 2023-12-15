package AlquilerDeVehicuos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

public class AlquilerGUI extends JFrame {

    private JLabel lblIdVehiculo;
    private JTextField txtCantidadDias;
    private JButton btnCalcular;
    private JButton btnAceptar;
    private JButton btnSalir;
    private JTable table; // Agregado para mantener la referencia de la tabla
    private VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private String tipoVehiculo;

    public AlquilerGUI(String idVehiculo,String tipoVehiculo, JTable table) {

        this.tipoVehiculo = tipoVehiculo;
        this.table = table; // Almacenar la referencia de la tabla

        // Configurar la ventana
        setTitle("Alquiler de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Crear y configurar la etiqueta que muestra el tipo de vehículo seleccionado
        lblIdVehiculo = new JLabel("Tipo de vehículo seleccionado: " + tipoVehiculo);
        lblIdVehiculo.setFont(new Font("Arial", Font.BOLD, 16));
        lblIdVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblIdVehiculo, BorderLayout.NORTH);

        // Crear un panel central con un diseño de cuadrícula para la entrada de datos
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(2, 2, 10, 10));

        // Crear etiqueta y campo de texto para la cantidad de días
        JLabel lblCantidadDias = new JLabel("Cantidad de días:");
        lblCantidadDias.setFont(new Font("Arial", Font.PLAIN, 14));
        txtCantidadDias = new JTextField();
        txtCantidadDias.setFont(new Font("Arial", Font.PLAIN, 14));
        panelCentral.add(lblCantidadDias);
        panelCentral.add(txtCantidadDias);

        // Agrego el panel central al contenedor
        add(panelCentral, BorderLayout.CENTER);

        // Crear botón para calcular el costo del alquiler
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Ingreso de cantidad de días de alquiler por parte del usuario
                String cantidadDiasStr = txtCantidadDias.getText();

                if (cantidadDiasStr.isEmpty()) {

                    JOptionPane.showMessageDialog(AlquilerGUI.this, "Por favor, ingrese la cantidad de días.", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        int selectedRow = table.getSelectedRow();

                        if (selectedRow != -1) {

                            // Obtener el idVehiculo seleccionado por el usuario
                            int idVehiculoSeleccionado = Integer.parseInt(String.valueOf(table.getModel().getValueAt(selectedRow, 0)));
                            int cantidadDias = Integer.parseInt(cantidadDiasStr);

                            // Obtener el tipo de vehículo y crear una instancia correspondiente
                            Vehiculo vehiculo = obtenerVehiculoSegunTipo(tipoVehiculo);

                            // Calcular el costo del alquiler utilizando la instancia del vehículo
                            double costoAlquiler = vehiculo.calcularPrecioAlquiler(cantidadDias);

                            // Mostrar el costo del alquiler
                            mostrarResultadoCostoAlquiler(costoAlquiler);

                            // Obtener la fecha actual
                            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

                            // Insertar cotización en la base de datos
                            vehiculoDAO.insertarCotizacion(idVehiculoSeleccionado, cantidadDias, (float) costoAlquiler, fechaCreacion);

                        } else {

                            JOptionPane.showMessageDialog(AlquilerGUI.this, "Selecciona una fila antes de hacer clic en Calcular");

                        }

                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(AlquilerGUI.this, "Por favor, ingrese un número entero válido para la cantidad de días.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        });

        // Crear botón para volver a la ventana de selección de vehículos
        btnAceptar = new JButton("Atrás");
        btnAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Volver a la ventana de selección de vehículos
                VehiculoDAO vehiculoDAO = new VehiculoDAO();
                List<Vehiculo> listaVehiculos = vehiculoDAO.imprimirListadoVehiculos();
                VehiculoGUI vehiculoGUI = new VehiculoGUI(listaVehiculos);
                vehiculoGUI.setVisible(true);
                dispose();

            }

        });

        // Crear botón para salir
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose(); // Cierra la ventana al hacer clic en el botón "Salir"

            }

        });

        // Crear un panel de botones y agregar los botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCalcular);
        panelBotones.add(btnAceptar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

    }

    // Método para obtener una instancia de Vehiculo según el tipo
    private Vehiculo obtenerVehiculoSegunTipo(String tipoVehiculo) {

        switch (tipoVehiculo) {

            case "AUTO":
                return new Auto("XXX");
            case "MINIBUS":
                return new Minibus("XXX");
            case "FURGONETA":
                return new Furgoneta("XXX");
            default:
                return new Camion("XXX");

        }

    }

    // Método para mostrar el resultado del costo del alquiler en un cuadro de diálogo
    private void mostrarResultadoCostoAlquiler(double costoAlquiler) {

        JOptionPane.showMessageDialog(AlquilerGUI.this, "El costo del alquiler es: $" + costoAlquiler, "Costo del Alquiler", JOptionPane.INFORMATION_MESSAGE);

    }

}
