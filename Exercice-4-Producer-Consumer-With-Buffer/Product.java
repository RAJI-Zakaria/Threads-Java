class Product{
    int id;
    int type;
    String name;
    String weight;
    public Product(int Type, int id){
        
        this.id = id;
        switch(Type){
            case 1:
                this.name =  "COCO";
                this.weight = "22,2kg";
                break;
                
            case 2:
                this.name =  "VANILA";
                this.weight = "41,11kg";
                break;
                
            case 3:
                this.name =  "CHOCO";
                this.weight = "912g";
                break;
                
        }
    }

//@Override
    public String toString(){
        return "id : "+this.id +" =>"+this.name + " -> "+this.weight;
    }


}