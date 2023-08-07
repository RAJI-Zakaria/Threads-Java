
public class MonThread1 extends Thread {

    public MonThread1(String nom) {
        super(nom);

    }

    // @override
    public void run() {

        int start = 1;
        int end = 101;
        while (start < end) {
            System.out.println(Thread.currentThread().getName());
            start++;
        }
    }
}
