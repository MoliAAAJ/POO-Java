package AlquilerDeVehicuos;

import java.util.List;

public abstract class Vehiculo {

    private String patente;
    
    public Vehiculo(String patente) {

        this.patente = patente;

    }

    public Vehiculo() {

        
    }
    
    public String getPatente() {

        return patente;

    }

    public void setPatente(String patente) {

        this.patente = patente;

    }

    public double calcularPrecioAlquiler(int diasAlquiler) {

        return 2000 * diasAlquiler;

    }

    public void add(List<Vehiculo> vehiculos) {
        
    }

}
