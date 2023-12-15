package AlquilerDeVehicuos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO implements IVehiculoDAO {

    private AccesoDatos accesoBD = new AccesoDatos();

    @Override
    public List<Vehiculo> imprimirListadoVehiculos() {

        List<Vehiculo> vehiculos = new ArrayList<>();

        // Consulta con JOIN para obtener la lista de vehículos y muestre el tipo de vehiculo en vez de su ID
        String query = "SELECT V.IdVehiculo, TV.descripcion AS TipoVehiculoDescripcion, V.Marca, V.Modelo, V.AñoFabricacion, V.Patente, V.Color, V.TipoTransmision, V.CantPlazas, V.CapacidadBaul, V.PMA\n" +
                "FROM VEHICULO V\n" +
                "JOIN TIPO_VEHICULO TV ON V.idtipo_vehiculo = TV.idtipo_vehiculo;";

        try (Connection con = accesoBD.getConexion();
             Statement sentencia = con.createStatement();
             ResultSet rs = sentencia.executeQuery(query)) {

            while (rs.next()) {

                int idVehiculo = rs.getInt("IdVehiculo");
                String tipoVehiculoDescripcion = rs.getString("TipoVehiculoDescripcion");
                String marca = rs.getString("Marca");
                String modelo = rs.getString("Modelo");
                int añoFabricacion = rs.getInt("AñoFabricacion");
                String patente = rs.getString("Patente");
                String color = rs.getString("Color");
                String tipoTransmision = rs.getString("TipoTransmision");
                int cantPlazas = rs.getInt("CantPlazas");
                int capacidadBaul = rs.getInt("CapacidadBaul");
                float pma = rs.getFloat("PMA");

                // Por cada vehiculo que se obtienen los datos se agregan a la lista
                Vehiculo vehiculo = new VehiculoExtendido(idVehiculo, tipoVehiculoDescripcion, marca, modelo, añoFabricacion, patente, color, tipoTransmision, cantPlazas, capacidadBaul, pma);
                vehiculos.add(vehiculo);

            }

        } catch (SQLException e) {

            throw new RuntimeException("Error al cargar datos", e);

        }

        // Se retorna la lista completa de vehiculos existentes en la base de datos
        return vehiculos;

    }

    @Override
    public void insertarCotizacion(int idVehiculo, int cantidadDias, float precioCotizacion, Timestamp fecha_Creacion) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
    
        try {

            AccesoDatos accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();

            // Consulta para insertar los datos de cotizacion ingresados por el usuario en la tabla "cotizacion"
            String insertQuery = "INSERT INTO cotizacion (idVehiculo, cantidadDias, precioCotizacion, fecha_Creacion) VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setInt(1, idVehiculo);
            preparedStatement.setInt(2, cantidadDias);
            preparedStatement.setFloat(3, precioCotizacion);
            preparedStatement.setTimestamp(4, fecha_Creacion);
            preparedStatement.executeUpdate();

            System.out.println("Inserción exitosa.");
    
        } catch (SQLException e) {

            e.printStackTrace();
            System.err.println("Error al insertar datos.");

        } finally {

            try {

                if (preparedStatement != null) {

                    preparedStatement.close();

                }

                if (con != null) {

                    con.close();

                }

            } catch (SQLException e) {

                e.printStackTrace();
                System.err.println("Error al cerrar la conexión.");

            }

        }

    }

    @Override
    public List<Vehiculo> imprimirListadoCotizaciones() {
        
        List<Vehiculo> cotizaciones = new ArrayList<>();

        // Con esta consulta se obtienen los datos de la tabla "cotizacion" concatenados con la tablas "vehiculo" y "tipo_vehiculo" ordenadas por "idCotizacion"
        String query = "SELECT\n" + //
                "    cotizacion.idCotizacion,\n" + //
                "    vehiculo.idVehiculo,\n" + //
                "    tipo_vehiculo.descripcion AS tipoVehiculoDescripcion,\n" + //
                "    vehiculo.Marca,\n" + //
                "    vehiculo.Modelo,\n" + //
                "    vehiculo.AñoFabricacion,\n" + //
                "    vehiculo.Patente,\n" + //
                "    cotizacion.cantidadDias,\n" + //
                "    cotizacion.precioCotizacion,\n" + //
                "    cotizacion.fecha_Creacion\n" + //
                "FROM\n" + //
                "    cotizacion\n" + //
                "JOIN\n" + //
                "    vehiculo ON cotizacion.idVehiculo = vehiculo.idVehiculo\n" + //
                "JOIN\n" + //
                "    tipo_vehiculo ON vehiculo.idtipo_vehiculo = tipo_vehiculo.idtipo_vehiculo\n" + //
                "ORDER BY cotizacion.idCotizacion;";

        try (Connection con = accesoBD.getConexion();
             Statement sentencia = con.createStatement();
             ResultSet rs = sentencia.executeQuery(query)) {

            while (rs.next()) {

                // Obtengo los datos de la tres tablas para luego armar la lista de vehiculos cotizados que se mostrara en la GUI
                int idCotizacion = rs.getInt("idCotizacion");
                int idVehiculo = rs.getInt("idVehiculo");
                String tipoVehiculoDescripcion = rs.getString("tipoVehiculoDescripcion");
                String Marca = rs.getString("Marca");
                String Modelo = rs.getString("Modelo");
                int AñoFabricacion = rs.getInt("AñoFabricacion");
                String Patente = rs.getString("Patente");
                int cantidadDias = rs.getInt("cantidadDias");
                float precioCotizacion = rs.getFloat("precioCotizacion");
                Timestamp fecha_Creacion = rs.getTimestamp("fecha_Creacion");

                // Se añade cada vehiculo cotizado a la lista
                Vehiculo vehiculo = new VehiculoExtendido(idCotizacion, idVehiculo, tipoVehiculoDescripcion, Marca, Modelo, AñoFabricacion, Patente, cantidadDias, precioCotizacion, fecha_Creacion);
                cotizaciones.add(vehiculo);

            }

        } catch (SQLException e) {

            throw new RuntimeException("Error al cargar datos", e);

        }

        // Se retorna la lista de cotizaciones
        return cotizaciones;

    }   

}
