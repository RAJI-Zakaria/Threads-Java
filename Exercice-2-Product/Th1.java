
public class Th1 extends Thread {
    public Th1(String nom) {
        super(nom);

    }

    // @override
    public void run() {

        int start = 0;
        int end = 5; 
        while (start < end) {
            Product p  = new Product(start % 2 + 1);
            System.out.println(Thread.currentThread().getName() + " --> " + p);
            start++;
        }
    }
}
