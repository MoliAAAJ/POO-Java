package AlquilerDeVehicuos;

public class Minibus extends VehiculoPersonas {

    static final int PLAZAS_MINIBUS = 15;

    public Minibus(String patente) {

        super(patente, PLAZAS_MINIBUS);

    }

    @Override
    public double calcularPrecioAlquiler(int diasAlquiler) {

        return  super.calcularPrecioAlquiler(diasAlquiler) + (120 * this.plazas);

    }

}
