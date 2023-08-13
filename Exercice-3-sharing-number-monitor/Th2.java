import java.util.concurrent.Semaphore;

public class Th2 extends Thread {
    Number nbr; 
    
    public Th2(String nom, Number P_nbr ) {
        super(nom);
        this.nbr = P_nbr; 
    }

    // @override
    public void run() {
            try{ 
        int start = 0;
        int end = 1000;
        while (start < end) {  
            this.nbr.increment();
            System.out.println(Thread.currentThread().getName() + " --> " + this.nbr);
 
            Thread.sleep(1);

            start++;
        }
            } catch(Exception e){
            System.out.println("Error : "+e.getMessage());  
        }
    }
}
