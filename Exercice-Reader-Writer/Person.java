import java.util.concurrent.Semaphore;


class Person extends Thread{
    String name;
    Semaphore file; 
    public Person(String name, Semaphore file){
        this.name = name;
        this.file = file;
    }

    public void openFile(){
       try{
         file.acquire();
        System.out.println(name+" has opened the file"); 
        Thread.sleep(200);
       }catch(Exception e){
              System.out.println(e.getMessage());
       }

    }

    public void writeFile(){
          try{
        System.out.println(name+" is writing on the file");   
        Thread.sleep(200);
       }catch(Exception e){
              System.out.println(e.getMessage());
       }
    }

    public void closeFile(){
         try{
        System.out.println(name+" has closed the file");
        file.release();
        Thread.sleep(200);
       }catch(Exception e){
              System.out.println(e.getMessage());
       }
       
    }

    //@override
    public void run(){
       while (true){
         openFile();
        writeFile();
        closeFile();
       }
    }
}