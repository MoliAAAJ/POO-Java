package AlquilerDeVehicuos;

public class VehiculoPersonas extends Vehiculo {

    int plazas;

    public VehiculoPersonas(String patente, int plazas) {

        super(patente);
        this.plazas = plazas;

    }

    @Override
    public double calcularPrecioAlquiler(int diasAlquiler) {

        return super.calcularPrecioAlquiler(diasAlquiler) + 100 * (this.plazas + diasAlquiler);

    }

}
