package AlquilerDeVehicuos;

class VehiculoCarga extends Vehiculo {

    double pesoMaximoAutorizado;

    public VehiculoCarga(String patente, double pesoMaximoAutorizado) {

        super(patente);
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;

    }

    @Override
    public double calcularPrecioAlquiler(int diasAlquiler) {

        return super.calcularPrecioAlquiler(diasAlquiler) + (800 * this.pesoMaximoAutorizado);

    }
    
}
