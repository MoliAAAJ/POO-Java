package AlquilerDeVehicuos;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VehiculoGUI extends JFrame {

    private JTable table;
    private JButton siguienteButton;

    public VehiculoGUI(List<Vehiculo> vehiculos) {

        // Configurar la ventana
        setTitle("Listado de Vehículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public Class<?> getColumnClass(int columnIndex) {

                return columnIndex == 0 ? JButton.class : String.class;

            }

            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 0;

            }

        };

        // Configuro las columnas que va a tener la tabla
        model.addColumn("ID");
        model.addColumn("Tipo Vehículo");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Año Fabricación");
        model.addColumn("Patente");
        model.addColumn("Color");
        model.addColumn("Tipo Transmisión");
        model.addColumn("Cant. Plazas");
        model.addColumn("Capacidad Baul");
        model.addColumn("PMA");

        // Llenar la tabla con datos
        llenarTabla(vehiculos, model);

        // Crear la tabla con el modelo
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSelectionAllowed(true); // Permitir la selección de filas

        // Centrar los datos en las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {

            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        // Personalizar el renderizador de cabecera para negrita e itálica
        JTableHeader header = table.getTableHeader();
        header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC));

        // Agregar la tabla al JScrollPane para permitir desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane al contenedor
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Agregar el botón "Siguiente"
        siguienteButton = new JButton("Siguiente");
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                // Se verifica si alguna fila fue seleccionada, de lo contrario se imprime un mensaje de advertencia
                if (selectedRow != -1) {

                    // De la fila seleccionada por el usuario voy a tomar los datos que necesito para realizar la cotizacion
                    String idVehiculo = String.valueOf(table.getModel().getValueAt(selectedRow, 0));
                    String tipoVehiculo = String.valueOf(table.getModel().getValueAt(selectedRow, 1));

                    // Abrir la ventana de AlquilerGUI y pasar la referencia de la tabla
                    AlquilerGUI alquilerGUI = new AlquilerGUI(idVehiculo, tipoVehiculo, table); // Pasar la referencia de la tabla
                    alquilerGUI.setVisible(true);

                    dispose(); // Cerrar la ventana actual si es necesario

                } else {

                    JOptionPane.showMessageDialog(VehiculoGUI.this, "Selecciona una fila antes de hacer clic en Siguiente");

                }

            }

        });

        // Agregar el botón "Siguiente" al contenedor
        getContentPane().add(siguienteButton, BorderLayout.SOUTH);

    }

    // Método para llenar la tabla con datos de vehículos
    private void llenarTabla(List<Vehiculo> vehiculos, DefaultTableModel model) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo instanceof VehiculoExtendido) {

                VehiculoExtendido vehiculoExtendido = (VehiculoExtendido) vehiculo;

                // Añadir una fila a la tabla con los datos del vehículo extendido
                model.addRow(new Object[]{vehiculoExtendido.getIdVehiculo(), vehiculoExtendido.getTipoVehiculoDescripcion(),
                        vehiculoExtendido.getMarca(), vehiculoExtendido.getModelo(), vehiculoExtendido.getAñoFabricacion(),
                        vehiculoExtendido.getPatente(), vehiculoExtendido.getColor(), vehiculoExtendido.getTipoTransmision(),
                        vehiculoExtendido.getCantPlazas(), vehiculoExtendido.getCapacidadBaul(), vehiculoExtendido.getPMA()});

            }

        }

    }

}
