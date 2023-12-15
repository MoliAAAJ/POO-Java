public class Tablero {

    private Casillero casilleros[][];

    public Tablero() {
        
    }

    public Tablero(Casillero[][] casilleros) {

        this.casilleros = casilleros;

    }

    public Casillero[][] getCasilleros() {

        return casilleros;

    }

    public void setCasilleros(Casillero[][] casilleros) {

        this.casilleros = casilleros;
        
    }
    
}
