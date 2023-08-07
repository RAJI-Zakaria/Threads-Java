
public class Product {
    private String color;
    private int weight;

    Product(int index) {

        switch (index){
                case 1 :
                this.color="rouge";
                this.weight= 100;
                 break; //
                case 2 :
                this.color="vert";
                this.weight=150;
                 break; //
                case 3 :
                this.color="jaune";
                this.weight=50; 
                 break; //
        }
        
    }

    @Override
    public String toString() {
        return "Color : " + this.color + " - Weight : " + this.weight + " kg";
    }
}
