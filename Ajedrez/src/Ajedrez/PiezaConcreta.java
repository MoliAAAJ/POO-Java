import java.sql.Timestamp;

public class PiezaConcreta extends Pieza {

    public PiezaConcreta(int idPieza, String tipoPieza, String color, String movimiento, String comportamiento, Timestamp fechaCreacion) {

        super(idPieza, tipoPieza, color, movimiento, comportamiento, fechaCreacion);
        
    }

    @Override
    public void mover() {
    }

}
