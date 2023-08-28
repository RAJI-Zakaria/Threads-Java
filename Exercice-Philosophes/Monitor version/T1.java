/*


Il s'agissait d'un problème de producteur - consommateur (avec buffer illimité, 3 producteurs, 1 consommateur), problème que nous avions étudié et programmé en cours/TP.

La solution la plus simple et la plus efficace pour gérer le buffer dans un environnement concurrent est d'utiliser une LinkedTransferQueue : cette classe est "thread safe" et permet, par exemple, à un producteur de déposer un élément alors qu'un consommateur en récupère un autre. Certains ont opté pour une liste gérée en exclusion mutuelle, cela limite le parallélisme en créant un goulot d'étranglement.

Il fallait créer une classe pour les threads producteurs (avec le nombre d'itérations et le buffer pour paramètres), une classe pour le thread consommateur (avec le nombre d'itérations et le buffer pour paramètres), une classe pour une statistique élémentaire (catégorie + nombre d'incidents) en plus de la classe du programme principal.

Vous aviez les consignes pour générer des statistiques aléatoires (catégorie : entier compris entre 1 et 4, nombre d'incidents : entier compris entre 1 et 20) mais beaucoup les ont mal suivies ...



*/

import java.util.concurrent.LinkedTransferQueue;
import java.util.Random; 

 
 class T1 {
    public static void main(String[] args) {
        LinkedTransferQueue<Incident> buffer = new LinkedTransferQueue<Incident>();
        int nbIterations = 100;
        Producer p1 = new Producer(nbIterations, buffer);
        Producer p2 = new Producer(nbIterations, buffer);
        Producer p3 = new Producer(nbIterations, buffer);
        Consumer c1 = new Consumer(nbIterations, buffer);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        try {
            p1.join();
            p2.join();
            p3.join();
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin du programme");
    }
}

class Producer extends Thread {
    private int nbIterations;
    private LinkedTransferQueue<Incident> buffer;
    public Producer(int nbIterations, LinkedTransferQueue<Incident> buffer) {
        this.nbIterations = nbIterations;
        this.buffer = buffer;
    }
    public void run() {
        Random r = new Random();
        for (int i = 0; i < nbIterations; i++) {
            int categorie = r.nextInt(4) + 1;
            int nbIncidents = r.nextInt(20) + 1;
            Incident incident = new Incident(categorie, nbIncidents);
            try {
                buffer.put(incident);
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private int nbIterations;
    private LinkedTransferQueue<Incident> buffer;
    public Consumer(int nbIterations, LinkedTransferQueue<Incident> buffer) {
        this.nbIterations = nbIterations;
        this.buffer = buffer;
    }
    public void run() {
        for (int i = 0; i < nbIterations; i++) {
            try {
                Incident incident = buffer.take();
                System.out.println(incident);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Incident {
    private int categorie;
    private int nbIncidents;
    public Incident(int categorie, int nbIncidents) {
        this.categorie = categorie;
        this.nbIncidents = nbIncidents;
    }
    public String toString() {
        return "Incident : catégorie = " + categorie + ", nombre d'incidents = " + nbIncidents;
    }
}

 




 
