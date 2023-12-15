import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class PiezaDAO implements iPiezaDAO{

    AccesoDatos accesoBD = null;
    Connection con = null;
    Statement sentencia = null;
	ResultSet rs = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Pieza> imprimirListadoPiezas() {

        List<Pieza> piezas = new ArrayList<>();
        
        String query = "SELECT\n" + //
                "    p.idPieza,\n" + //
                "    p.idTipoPieza,\n" + //
                "    p.IdColor,\n" + //
                "    p.Comportamiento,\n" + //
                "    p.Movimiento,\n" + //
                "    p.Fecha_Creacion,\n" + //
                "    c.Descripcion AS Color_Descripcion,\n" + //
                "    tp.Descripciondepieza AS TipoPieza_Descripcion\n" + //
                "FROM\n" + //
                "    pieza p\n" + //
                "    LEFT JOIN color c ON p.IdColor = c.idColor\n" + //
                "    LEFT JOIN tipopieza tp ON p.idTipoPieza = tp.idTipoPieza;";
        
        try {
        
        	accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
            sentencia = con.createStatement();
            rs  = sentencia.executeQuery(query);
            
            System.out.println("---LISTADO DE PIEZAS EN BD---");   	         		
            
            while(rs.next()){ 
            	
            	int idPieza = rs.getInt("idPieza");
				String Color = rs.getString("Color_Descripcion");
				String TipoPieza = rs.getString("TipoPieza_Descripcion");
                String movimiento = rs.getString("Movimiento");
                String comportamiento = rs.getString("Comportamiento");
                Timestamp fechaCreacion = rs.getTimestamp("Fecha_Creacion");

                // Crear una nueva pieza y añadirla a la lista
                Pieza pieza = new PiezaConcreta(idPieza, TipoPieza, Color, movimiento, comportamiento, fechaCreacion);
                piezas.add(pieza); 	         		
            	            			
			}        
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS");
        }
       finally
        {
        	try
        	{
        		
        		if (rs!= null) rs.close();
        		
        		if (sentencia!= null) sentencia.close();
        		
        		if (con != null) con.close();
        		
        	}catch (SQLException e)
        	{
        		System.err.println("Error al cerrar conexion");
        	}
        }

    
        // Devolver la lista de piezas
        return piezas;

    }

    public void insertarPieza(int idTipoPieza, int idColor, String movimiento, String comportamiento, Timestamp Fecha_Creacion, int idTamanio, int idMaterial, String Posicion) {

        try {

            accesoBD = new AccesoDatos();
            con = accesoBD.getConexion();
    
            String insertQuery = "INSERT INTO pieza (idTipoPieza, idColor, Movimiento, Comportamiento, Fecha_Creacion, idTamanio, idMaterial, Posicion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            preparedStatement = con.prepareStatement(insertQuery);
            
            preparedStatement.setInt(1, idTipoPieza);
            preparedStatement.setInt(2, idColor);
            preparedStatement.setString(3, movimiento);
            preparedStatement.setString(4, comportamiento);
            preparedStatement.setTimestamp(5, Fecha_Creacion);
            preparedStatement.setInt(6, idTamanio);
            preparedStatement.setInt(7, idMaterial);
            preparedStatement.setString(8, Posicion);
            
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
    public void actualizarPieza(Pieza piezaMod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPieza'");
    }

    @Override
    public void eliminarPieza(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPieza'");
    }

    @Override
    public Pieza obtenerPiezaByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPiezaByID'");
    }

}
