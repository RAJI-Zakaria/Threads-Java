import java.util.concurrent.LinkedTransferQueue ;

class Consumer implements Runnable {
    private LinkedTransferQueue<Product> productList;

    public Consumer(LinkedTransferQueue<Product> P_productList) {
        this.productList = P_productList;
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            synchronized (productList) {
                while (productList.isEmpty()) {
                    try {
                        productList.wait(); 
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

                Product p = productList.poll();
                System.out.println("consumming the Product  : " + p);
                productList.notify();
            }
             try {
                Thread.sleep(150); // Adding a sleep interval to simulate production
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
