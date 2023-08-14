 
 //import Semaphore
    import java.util.concurrent.Semaphore;

    class Philosopher extends Thread{
        String name;
        Semaphore LeftFork;
        Semaphore RightFork;

        public Philosopher(String name, Semaphore LeftFork, Semaphore RightFork){
            this.name = name;
            this.LeftFork = LeftFork;
            this.RightFork = RightFork;
        }

        public void eating(){
            try{
                LeftFork.acquire();
                RightFork.acquire();
                System.out.println(name + " is eating");
                Thread.sleep(1000);
                LeftFork.release();
                RightFork.release();

                System.out.println(name + "  has done eating");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public  void waiting(){
            try{
                System.out.println(name + " is waiting");
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
        //@Override
        public void run(){
            while(true){
                waiting();
                eating();
            }
        }
    }