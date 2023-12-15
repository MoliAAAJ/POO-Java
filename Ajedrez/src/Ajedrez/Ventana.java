import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Ventana extends JFrame {

    private JPanel contentPane;
    private DefaultTableModel tableModel;
    private JTable table;

    public Ventana(iPiezaDAO iPieza) {

        // Configuración de la ventana
        setTitle("El ajedrez de Borges");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear el modelo de tabla y la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Pieza Nro.");
        tableModel.addColumn("Tipo");
        tableModel.addColumn("Color");
        tableModel.addColumn("Movimiento");
        tableModel.addColumn("Comportamiento");
        tableModel.addColumn("Fecha de creación");
        table = new JTable(tableModel);

        // Agregar la tabla en un JScrollPane para permitir desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 900, 600);
        contentPane.add(scrollPane);

        // Botón para salir
        JButton btnNewButton = new JButton("Salir");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton.setBounds(455, 655, 89, 23);
        contentPane.add(btnNewButton);

        // Obtener la lista de piezas desde la base de datos
        List<Pieza> piezas = iPieza.imprimirListadoPiezas();

        // Agregar los datos de las piezas a la tabla
        for (Pieza pieza : piezas) {
            Object[] rowData = {
                pieza.getIdPieza(),
                pieza.getTipoPieza(),
                pieza.getColor(),
                pieza.getMovimiento(),
                pieza.getComportamiento(),
                pieza.getFechaCreacion()
            };
            tableModel.addRow(rowData);
        }
    }

}
