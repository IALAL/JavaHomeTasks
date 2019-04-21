package Hometask7;

public class Cat {
    private int appetite;
    private String name;

    public Cat(int appetite, String name) {
        this.appetite = appetite;
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void Eat(Plate p){
        if(appetite>p.getFood()) {
           // appetite -= p.getFood();
            System.out.println(name+" Мало");
        }
        else if(Appetite()){
            System.out.println(name+" Сыт");
        }
        else {
            p.addFood(-appetite);
            appetite = 0;
        }
    }

    public boolean Appetite(){
        return appetite==0;
    }

    public void AppetiteInfo(){
        System.out.println(name+" "+Appetite());
    }
}

class Plate{
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void FoodInfo(){
        System.out.println("Food: "+food);
    }
}

class Main{
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cat = new Cat[3];
        cat[0] = new Cat(33,"Barsik");
        cat[1] = new Cat(33,"Rudy");
        cat[2] = new Cat(33,"Shell");

        plate.FoodInfo();
        for (int i = 0; i <cat.length ; i++) {
            cat[i].Eat(plate);
            cat[i].AppetiteInfo();
            plate.FoodInfo();
        }
        cat[0].Eat(plate);
        plate.addFood(50);
        plate.FoodInfo();
    }
}
