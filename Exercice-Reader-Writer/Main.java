//import semaphore
import java.util.concurrent.Semaphore;


class Main { 
    public static void main(String[] args) {
        int nbr_users = 3;
        Semaphore file = new Semaphore(1) ;
        Person[] persons  = new Person[nbr_users]; 
        
        String[] writersNames = { "Zakaria", "Micheal", "Steve" };
        String[] readersNames = { "Josh", "Harry" };

        
 
        for(int i=0;i<nbr_users;i++){
            persons[i] = new Person(writersNames[i], file);
            persons[i].start();
        }


    }

} 