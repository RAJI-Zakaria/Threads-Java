
public class Th2 extends Thread {
    public Th2(String nom) {
        super(nom);

    }

    // @override
    public void run() {

        int start = 0;
        int end = 10;
        while (start < end) {
            
            Product p = new Product(start % 3 + 1);
            System.out.println(Thread.currentThread().getName() + " --> " + p);
            start+=2;
        }
    }
}
