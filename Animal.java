package Hometask6;

import java.util.Random;

public class Animal {
    private float run;
    private float jump;
    private float swim;
    private String name;

    private final  Random random = new Random();

    Animal(float run, float jump, float swim, String name) {

        this.run = run*(random.nextInt(10)+5)/10;
        this.jump = jump+random.nextInt(5)/10;
        this.swim = swim*(random.nextInt(10)+5)/10;
        this.name=name;
    }

    void Run(float distance){
        System.out.println(name + " run - " + (run>=distance));
    }

    void Swim(float distance){
        System.out.println(name + " swim - " + (swim>=distance));
    }

    void Jump(float distance){
        System.out.println(name +  " jump - " + (jump>=distance));
    }

    public String getName() {
        return name;
    }
}

 class Cat extends Animal{
       Cat(float run, float jump, float swim, String name) {
         super(run, jump, swim,name);
     }
 }

class Dog extends Animal{
     Dog(float run, float jump, float swim, String name) {
        super(run, jump, swim,name);
    }
}

class Main {
    public static void main(String[] args) {
        Cat cat1= new Cat(100,1,50,"Mew");
        Dog dog2= new Dog(200,0.8f,150,"Rudy");
        float toJump = 0.5f;
        float toRun = 200;
        float toSwim = 100;


            cat1.Jump(toJump);
            cat1.Run(toRun);
            cat1.Swim(toSwim);
            dog2.Jump(toJump);
            dog2.Run(toRun);
            dog2.Swim(toSwim);

            Random random = new Random();

        System.out.println(random.nextFloat()*200-100);

    }
 }
