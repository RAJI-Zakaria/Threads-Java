import java.util.concurrent.Semaphore;

public class Th1 extends Thread {
    Number nbr;
    Semaphore sem;
    
    public Th1(String nom, Number P_nbr, Semaphore P_Sem) {
        super(nom);
        this.nbr = P_nbr;
        this.sem = P_Sem;
    }

    // @override
    public void run() {
        try{ 
        int start = 0;
        int end = 1000; 
        while (start < end) {

            sem.acquire();
            this.nbr.decrement();  
            System.out.println(Thread.currentThread().getName() + " --> " + this.nbr);


            sem.release();
            Thread.sleep(1);
            start++;
        }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());  
        }
    }
}
