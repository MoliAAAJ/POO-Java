package AlquilerDeVehicuos;

import javax.swing.*;
import java.awt.*;

public class CotizacionGUI extends JFrame {

    private JLabel lblCotizacion;

    public CotizacionGUI(double costoAlquiler) {

        // Configurar la ventana pequeña donde se le pide al usuario que ingrese los días de alquiler
        setTitle("Cotización");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al presionar el botón de cerrar
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Crear y configurar la etiqueta de cotización
        lblCotizacion = new JLabel("El costo del alquiler es: $" + costoAlquiler);
        lblCotizacion.setFont(new Font("Arial", Font.BOLD, 16));
        lblCotizacion.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar la etiqueta al centro de la ventana
        add(lblCotizacion, BorderLayout.CENTER);

    }

}
