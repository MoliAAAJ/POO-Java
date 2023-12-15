package AlquilerDeVehicuos;

class Camion extends VehiculoCarga {

    static final double PMA_CAMION = 11.5;
    static final double PRECIO_FIJO_CAMION = 1600;

    public Camion(String patente) {

        super(patente, PMA_CAMION);

    }

    @Override
    public double calcularPrecioAlquiler(int diasAlquiler) {

        return super.calcularPrecioAlquiler(diasAlquiler) + PRECIO_FIJO_CAMION;

    }

}
