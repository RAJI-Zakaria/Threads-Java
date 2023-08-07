
public class MonThread2 extends Thread {

    public MonThread2(String nom) {
        super(nom);

    }

    // @override
    public void run() {
        int start = 1;
        int end = 300;
        while (start < end) {
            System.out.println(Thread.currentThread().getName());
            start += 2;
        }
    }
}
