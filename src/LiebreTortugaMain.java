public class LiebreTortugaMain {

    static Turtle tort = new Turtle(1);
    static Hare hare = new Hare(1);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de la carrera");

        boolean fin = false;
        while(!fin){
            int turno1 = (int) Math.floor(Math.random()*(100)+1);
            int turno2 = (int) Math.floor(Math.random()*(100)+1);
            liebreTurno(turno1);
            tortugaTurno(turno2);
            int p1 = (int) hare.get();
            int p2 = (int) tort.get();

            for(int i = 0; i < p1; i++){
                System.out.print(" ");
            }
            System.out.println("L");
            for(int i = 0; i < p2; i++){
                System.out.print(" ");
            }
            System.out.println("T");

            boolean ganador1 = (boolean)hare.getWinner();
            boolean ganador2 = (boolean)tort.getWinner();
            if(ganador1 && ganador2){
                System.out.println("Empate");
                fin = true;
            }
            else if(ganador1){
                System.out.println("La Liebre Ha Ganado");
                fin = true;
            }
            else if(ganador2){
                System.out.println("La Tortuga Ha Ganado");
                fin = true;
            }
        }
    }

    public static void liebreTurno(int valor) throws InterruptedException {
        if(0 < valor && valor < 21){
            hare.duerme();
        }
        else if(21 < valor && valor < 41){
            hare.granSalto();
        }
        else if(41 < valor && valor < 51){
            hare.resbalonGrande();
        }
        else if(51 < valor && valor < 81){
            hare.saltoChico();
        }
        else{
            hare.resbalonChico();
        }
    }
    public static void tortugaTurno(int valor) throws InterruptedException{
        if(0 < valor && valor < 51){
            tort.avanceRapido();
        }
        else if(51 < valor && valor < 71) {
            tort.resbalon();
        }
        else{
            tort.avanceLento();
        }
    }
}
