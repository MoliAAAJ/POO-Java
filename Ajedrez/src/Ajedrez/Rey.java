public class Rey extends Pieza{

    @Override
    public void mover() {
        
        String yellow = "\u001B[33m";
        String reset = "\u001B[0m";
        
        System.out.printf("Soy el " + "%s " + yellow +  "%s," + reset +  " me comporto " + yellow + "%s" + reset + " y me muevo " + yellow +  "%s" + reset + ".",this.getClass().getSimpleName(), this.getColor(), this.getComportamiento(), this.getMovimiento());
        System.out.println("\n");
        
    }
  
}
