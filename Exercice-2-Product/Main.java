 public class Main {
    public static void main(String[] args) {
        Th1 th1 = new Th1("Th secondaire 1");
        Th2 th2 = new Th2("Th secondaire 2");

        th1.start();
        th2.start();
        try {
            // Attendre que les threads se terminent
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin du programme");
    }

}
