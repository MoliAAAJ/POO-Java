import java.sql.Timestamp;
import java.util.List;

public interface iPiezaDAO{

    public abstract List<Pieza> imprimirListadoPiezas();
    public abstract Pieza obtenerPiezaByID(int id);
    public abstract void insertarPieza(int idTipoPieza, int idColor, String movimiento, String comportamiento, Timestamp Fecha_Creacion, int idTamanio, int idMaterial, String Posicion);
    public abstract void actualizarPieza(Pieza piezaMod);
    public abstract void eliminarPieza(int id);

}
