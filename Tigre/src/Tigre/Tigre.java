package Tigre; // Se declara el paquete para importar la clase en la App.

public class Tigre {

    //* MÉTODOS */
    private String comportamiento;
    private String peligrosidad;
    private String vitalidad;
    private String instinto;
    private String apariencia;


    //* CONSTRUCTORES */
    public Tigre() {

    }

    public Tigre(String comportamiento, String peligrosidad, String vitalidad, String instinto, String apariencia) {

    this.comportamiento = comportamiento;
    this.peligrosidad = peligrosidad;
    this.vitalidad = vitalidad;
    this.instinto = instinto;
    this.apariencia = apariencia;

    }

    public String getComportamiento() {

    return comportamiento;

    }

    //* SETTERS Y GETTERS */
    public void setComportamiento(String comportamiento) {

    this.comportamiento = comportamiento;

    }

    public String getPeligrosidad() {

    return peligrosidad;

    }

    public void setPeligrosidad(String peligrosidad) {

    this.peligrosidad = peligrosidad;

    }

    public String getVitalidad() {

    return vitalidad;
    }

    public void setVitalidad(String vitalidad) {

    this.vitalidad = vitalidad;

    }

    public String getInstinto() {

    return instinto;

    }

    public void setInstinto(String instinto) {

    this.instinto = instinto;

    }

    public String getApariencia() {

    return apariencia;

    }

    public void setApariencia(String apariencia) {

    this.apariencia = apariencia;

    }

}