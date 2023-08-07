
public class Number { 
    static int number;
    
    Number() { 
       this.number = 0; 
    }


    //add
    public void increment(){
        this.number++;
    }
    //substract
    public void decrement(){
        this.number--;
    }
    @Override
    public String toString() {
        return "Number : " + this.number;
    }
}
