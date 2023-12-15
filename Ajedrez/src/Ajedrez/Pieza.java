import java.sql.Timestamp;

public abstract class Pieza {

    private int idPieza;
    private String tipoPieza;
    private String movimiento;
    private String color;
    private String comportamiento;
    private Timestamp fechaCreacion;

    public Pieza() {

    }

    public Pieza(String movimiento, String color, String comportamiento) {

        this.movimiento = movimiento;
        this.color = color;
        this.comportamiento = comportamiento;

    }

    public Pieza(int idPieza, String tipoPieza, String color, String movimiento, String comportamiento, Timestamp fechaCreacion) {

        this.idPieza = idPieza;
        this.tipoPieza = tipoPieza;
        this.color = color;
        this.movimiento = movimiento;
        this.comportamiento = comportamiento;
        this.fechaCreacion = fechaCreacion;

    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public abstract void mover();
    
}
