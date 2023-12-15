package AlquilerDeVehicuos;

import java.sql.Timestamp;
import java.util.List;

public interface IVehiculoDAO {

    public abstract List<Vehiculo> imprimirListadoVehiculos();
    public abstract void insertarCotizacion(int idVehiculo, int cantidadDias, float precioCotizacion, Timestamp fecha_Creacion);
    public abstract List<Vehiculo> imprimirListadoCotizaciones();
    
}
