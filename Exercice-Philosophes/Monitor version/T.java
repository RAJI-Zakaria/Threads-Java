
import java.util.concurrent.LinkedTransferQueue;
import java.util.Random;
 class T {
    public static void main(String[] args) {
        LinkedTransferQueue<Incident> buffer = new LinkedTransferQueue<Incident>();
        int nbIterations = 100;
        Producer p1 = new Producer(nbIterations, buffer);
        Producer p2 = new Producer(nbIterations, buffer);
        Producer p3 = new Producer(nbIterations, buffer);
        Consumer c1 = new Consumer(nbIterations, buffer);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        try {
            p1.join();
            p2.join();
            p3.join();
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin du programme");
    }
}