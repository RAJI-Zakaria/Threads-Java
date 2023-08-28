

class Fork{ 

    private boolean isAvailable = true;

        int num;
        public Fork(int i){
                this.num=i;
        }
        public synchronized void take() throws InterruptedException {
            while (!isAvailable) {
                wait();
            }
            isAvailable = false;
        }
        public synchronized void putDown(){
            isAvailable = true;
            notify();
        }


            
         
}