
public class Number { 
    static int number;
    
    Number() { 
       this.number = 0; 
    }


    //add
    public synchronized void increment(){
        this.number++;
    }
    //substract
    public synchronized void decrement(){
        this.number--;
    }
    @Override
    public   String toString() {
        return "Number : " + this.number;
    }
}
