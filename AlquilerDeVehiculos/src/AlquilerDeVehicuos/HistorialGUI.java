package AlquilerDeVehicuos;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class HistorialGUI extends JFrame {

    private JTable table;

    public HistorialGUI() {

        super("Historial de Cotizaciones");
        initUI();
        actualizarTablaCotizaciones(); // Llenar la tabla con los datos al inicio

    }

    private void initUI() {

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        // Personalizar el renderizador de cabecera para negrita e itálica
        JTableHeader header = table.getTableHeader();
        header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC));

        // Nombres de las columnas
        String[] columnNames = {"IdCotizacion", "IdVehiculo", "Tipo Vehiculo", "Marca", "Modelo", "AñoFabricacion", "Patente", "CantidadDias", "PrecioCotizacion", "Fecha_Creacion"};
        model.setColumnIdentifiers(columnNames);

        // Ajustar la alineación de las celdas al centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Crear el botón "Salir"
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> dispose()); // Cerrar la aplicación al hacer clic en el botón "Salir"

        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);

        // Crear un panel para los componentes
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(exitButton, BorderLayout.SOUTH);

        // Agregar el panel al frame
        add(panel);

        // Configuraciones del frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setVisible(true);

    }

    private void actualizarTablaCotizaciones() {

        // Obtener la lista de cotizaciones desde el DAO
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        List<Vehiculo> cotizaciones = vehiculoDAO.imprimirListadoCotizaciones();

        // Limpiar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Llenar la tabla con los datos de las cotizaciones
        for (Vehiculo vehiculo : cotizaciones) {

            if (vehiculo instanceof VehiculoExtendido) {

                VehiculoExtendido cotizacionExtendida = (VehiculoExtendido) vehiculo;

                model.addRow(new Object[]{

                    cotizacionExtendida.getIdCotizacion(),
                    cotizacionExtendida.getIdVehiculo(),
                    cotizacionExtendida.getTipoVehiculoDescripcion(),
                    cotizacionExtendida.getMarca(),
                    cotizacionExtendida.getModelo(),
                    cotizacionExtendida.getAñoFabricacion(),
                    cotizacionExtendida.getPatente(),
                    cotizacionExtendida.getCantidadDias(),
                    cotizacionExtendida.getPrecioCotizacion(),
                    cotizacionExtendida.getFecha_Creacion()

                });

            }

        }
        
    }

}
