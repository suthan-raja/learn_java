package msp.test.learn.datastrcuture.abstract_class;

abstract class Animals {
    String name;

    Animals(String name) {
        this.name = name;
    }

    abstract void sound();

    void eat() {
        System.out.println("This animal eats food.");
    }
    
}

class Lion extends Animals {

    Lion(String name){
        super(name);
    }
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Tiger extends Animals {
    public Tiger(String blue) {
        super(blue);
    }

    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class AbstractUseCase {



        public static void main(String[] args) {
            Animals myDog = new Lion("raja");
            myDog.sound(); // Outputs: Bark
            myDog.eat();   // Outputs: This animal eats food.

            Animals myCat = new Tiger("tiger");
            myCat.sound(); // Outputs: Meow
            myCat.eat();   // Outputs: This animal eats food.
        }

}
