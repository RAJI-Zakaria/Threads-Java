 import java.util.concurrent.LinkedTransferQueue ;


public class Main {

    public static void main(String[] args) {
        LinkedTransferQueue<Product> ProductList = new LinkedTransferQueue<>();
        Producer pro = new Producer(ProductList);
        Consumer con = new Consumer(ProductList);

        Thread th1 = new Thread(pro);
        Thread th2 = new Thread(con);

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
 
//javac Product.java | javac Producer.java | javac Consumer.java | javac Main.java | 