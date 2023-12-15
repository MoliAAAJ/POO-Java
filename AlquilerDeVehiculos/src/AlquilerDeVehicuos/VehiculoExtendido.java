package AlquilerDeVehicuos;

import java.sql.Timestamp;

public class VehiculoExtendido extends Vehiculo {

    // Atributos que voy a necesitar para obtener los datos de "vehiculos" y de "cotizaciones"
    private int IdVehiculo;
    private String TipoVehiculoDescripcion;
    private String Marca;
    private String Modelo;
    private int AñoFabricacion;
    private String Patente;
    private String Color;
    private String TipoTransmision;
    private int CantPlazas;
    private int CapacidadBaul;
    private float PMA;
    private int idCotizacion;
    private int cantidadDias;
    private float precioCotizacion;
    private Timestamp fecha_Creacion;

    // Constructor que utilizo para extraer los datos de vehiculos precargados en la base de datos
    public VehiculoExtendido(int IdVehiculo, String TipoVehiculoDescripcion, String Marca, String Modelo, int AñoFabricacion, String Patente, String Color, String TipoTransmision, int CantPlazas, int CapacidadBaul, float PMA) {

        this.IdVehiculo = IdVehiculo;
        this.TipoVehiculoDescripcion = TipoVehiculoDescripcion;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AñoFabricacion = AñoFabricacion;
        this.Patente = Patente;
        this.Color = Color;
        this.TipoTransmision = TipoTransmision;
        this.CantPlazas = CantPlazas;
        this.CapacidadBaul = CapacidadBaul;
        this.PMA = PMA;

    }

    // Constructor que utilizo para extraer los datos de los vehiculos cotizados cargados en la base de datos
    public VehiculoExtendido(int idCotizacion, int IdVehiculo, String TipoVehiculoDescripcion, String Marca, String Modelo, int AñoFabricacion, String Patente, int cantidadDias, float precioCotizacion, Timestamp fecha_Creacion) {

        this.idCotizacion = idCotizacion;
        this.IdVehiculo = IdVehiculo;
        this.TipoVehiculoDescripcion = TipoVehiculoDescripcion;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AñoFabricacion = AñoFabricacion;
        this.Patente = Patente;
        this.cantidadDias = cantidadDias;
        this.precioCotizacion = precioCotizacion;
        this.fecha_Creacion = fecha_Creacion;

    }

    public VehiculoExtendido() {

    }

    // Utilizo solo getters por solo voy a utilizar los constructores para extraer información de la base de datos
    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public String getTipoVehiculoDescripcion() {
        return TipoVehiculoDescripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getAñoFabricacion() {
        return AñoFabricacion;
    }

    public String getPatente() {
        return Patente;
    }

    public String getColor() {
        return Color;
    }

    public String getTipoTransmision() {
        return TipoTransmision;
    }

    public int getCantPlazas() {
        return CantPlazas;
    }

    public int getCapacidadBaul() {
        return CapacidadBaul;
    }

    public float getPMA() {
        return PMA;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public float getPrecioCotizacion() {
        return precioCotizacion;
    }

    public Timestamp getFecha_Creacion() {
        return fecha_Creacion;
    }
    
}
