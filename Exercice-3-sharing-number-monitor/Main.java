 import java.util.concurrent.Semaphore;

 public class Main {
    // javac Th1.java | javac Th2.java | javac Number.java |  javac Main.java  
    public static void main(String[] args) { 

        Number nbr = new Number();

        Th1 th1 = new Th1("Th secondaire 1", nbr);
        Th2 th2 = new Th2("Th secondaire 2", nbr);

        th1.start();
        th2.start();
        try {
            // Attendre que les threads se terminent
            th1.join();
            th2.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------Fin du programme--------------------");
        System.out.println(nbr);
    }

}
