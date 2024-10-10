package msp.test.learn.datastrcuture.interface_class;

interface Animal {
    void sound(); // Abstract method

    default void eat() { // Default method
        System.out.println("This animal eats food.");
    }
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

public class InterfaceUseCase {

    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound(); // Outputs: Bark
        myDog.eat();   // Outputs: This animal eats food.

        Animal myCat = new Cat();
        myCat.sound(); // Outputs: Meow
        myCat.eat();   // Outputs: This animal eats food.
    }
}

