import java.util.concurrent.LinkedTransferQueue ;
class Producer implements Runnable {
    private LinkedTransferQueue<Product> productList;

    public Producer(LinkedTransferQueue<Product> P_productList) {
        this.productList = P_productList;
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            synchronized (productList) {
                while (productList.size() > 5) { // buffer allows 5 items only
                    try {
                        productList.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

                Product p = new Product(i % 3 + 1, i);
                System.out.println("creation of product : " + p);
                productList.offer(p);
                productList.notify();
            }
             try {
                Thread.sleep(50); // Adding a sleep interval to simulate production
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}