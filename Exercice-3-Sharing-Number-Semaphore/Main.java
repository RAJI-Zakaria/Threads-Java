 import java.util.concurrent.Semaphore;

 public class Main {
    // javac Th1.java | javac Th2.java | javac Number.java |  javac Main.java 
    private static Semaphore sem2 = new Semaphore(1);
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        Number nbr = new Number();

        Th1 th1 = new Th1("Th secondaire 1", nbr, sem);
        Th2 th2 = new Th2("Th secondaire 2", nbr, sem);

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
