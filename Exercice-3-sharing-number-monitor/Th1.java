import java.util.concurrent.Semaphore;

public class Th1 extends Thread {
    Number nbr; 
    
    public Th1(String nom, Number P_nbr ) {
        super(nom);
        this.nbr = P_nbr; 
    }

    // @override
    public void run() {
        try{ 
        int start = 0;
        int end = 1000; 
        while (start < end) { 
            this.nbr.decrement();  
            System.out.println(Thread.currentThread().getName() + " --> " + this.nbr);

 
            Thread.sleep(1);
            start+=1;
        }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());  
        }
    }
}
