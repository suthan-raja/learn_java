package msp.test.learn.datastrcuture.abstract_class;

abstract class Animal{

    protected String name;

    protected Animal(String name){
        this.name = name;
    }

    public abstract void sound();

    void wild(){
        System.out.println(name + " Wild");
    }
}

abstract class Birds extends Animal {

    protected Birds(String name) {
        super(name);
    }

    public abstract void walk();

}

class Dog extends Birds {

    Dog(String name){
        super(name);
    }

    @Override
    public void walk() {

    }

    @Override
    public void sound() {
        System.out.println(name + " Bark");
    }
}

class Cat extends Animal {

    Cat(String name){
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " Meow");
    }
}

public class AbstractClassDemo extends Animal {

    AbstractClassDemo(String name){
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " Lion ");
    }

    public static void creation(){

    }

    public static void main(String[] args) {

        /*
         *   1. Instantiation
         *          you cannot create a instance of an abstract class directly.
         *          It serves as a base class for other classes.
         */

//        Animal animal   = new Animal();

        AbstractClassDemo creation = new AbstractClassDemo("green");
        creation.wild();
        creation.sound();


        /*
         *  2. Methods
         *
         *      2.1 Abstract class can have both abstract and non-abstract or concrete methods
         *      2.2 Abstract methods must be implemented by subclass. concrete methods can be overridden
         *          but are not required.
         * */

        /*
         *   3. Fields
         *
         *        3.1 An abstract class can have instance variables (fields) and constructors.
         *
         * */

        Animal creation2 = new Dog("blue");
        creation2.wild();
        creation2.sound();

        /*   4. Access Modifiers
         *
         *         4.1 An abstract class can use all access modifiers ( public , protected , private ) for methods and
         *             fields
         * */

        /*  5. Multiple Inheritance
         *
         *          5.1 A class can extend only one abstract class ( single inheritance ).
         * */

        /*  6. Use Case
         *
         *         6.1 Use an abstract class when you want to provide a common base with default behaviour ,
         *             shared state, or a combination of method implementations.
         * */


        creation();
    }


}
