//import semaphore
import java.util.concurrent.Semaphore;


class Main { 
    public static void main(String[] args) {
        int nbr_philo = 5;
        Fork[] forks = new Fork[nbr_philo];
        Philosopher[] philos  = new Philosopher[nbr_philo]; 
        
        String[] names = {"Aristotle", "Plato", "Socrates", "Descartes", "Kant"};

        for(int i=0;i<nbr_philo;i++){
            forks[i] = new Fork(i);
        }
 
        for(int i=0;i<nbr_philo;i++){
            philos[i] = new Philosopher(names[i],forks[i], forks[(i+1)%nbr_philo]);
                        Thread thread = new Thread(philos[i]);

            thread.start();
        }


    }

} 