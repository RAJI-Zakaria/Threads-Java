//import semaphore
import java.util.concurrent.Semaphore;


class Main { 
    public static void main(String[] args) {
        int nbr_philo = 5;
        Semaphore[] forks = new Semaphore[nbr_philo];
        Philosopher[] philos  = new Philosopher[nbr_philo]; 
        
        String[] names = {"Aristotle", "Plato", "Socrates", "Descartes", "Kant"};

        for(int i=0;i<nbr_philo;i++){
            forks[i] = new Semaphore(1);
        }
 
        for(int i=0;i<nbr_philo;i++){
            philos[i] = new Philosopher(names[i],forks[i], forks[(i+1)%nbr_philo]);
            philos[i].start();
        }


    }

} 