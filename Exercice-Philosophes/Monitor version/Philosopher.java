 
 
 

    class Philosopher extends Thread{
        String name;
        Fork LeftFork;
        Fork RightFork;

        public Philosopher(String name, Fork LeftFork , Fork RightFork ){
            this.name = name;
            this.LeftFork = LeftFork;
            this.RightFork = RightFork;
        }

        public void eating() throws InterruptedException { 
                LeftFork.take();
                RightFork.take();
                System.out.println(name + " is eating");
                Thread.sleep((long) (10));
                LeftFork.putDown();
                RightFork.putDown();

                System.out.println(name + "  has done eating");
             
        }

        public  void waiting() throws InterruptedException {
            
                System.out.println(name + " is waiting");
                Thread.sleep((long) (10));
            
        } 
        @Override
        public void run() {
            try {
                while (true) {
                    waiting();
                    eating();
                }
            } catch ( Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }