package msp.test.learn.datastrcuture.interface_class;

interface Naruto{

    public static final int HOKAGE = 0;

    void power(); // abstract method

    default void fourthHokage(){
        System.out.println("fourth Hokage");
    }

}

interface Sasuke {

    void sensai();


}

class Power implements Naruto{

    @Override
    public void power() {
        System.out.println("Nine Tail Fox Sprit");
    }
}

class Friends implements Naruto , Sasuke {

    @Override
    public void power() {
        System.out.println("Nine Tail Fox Sprit");
    }

    @Override
    public void sensai() {
        System.out.println("Orachimaru");
    }
}



public class InterfaceDemoClass {

    public static void main(String[] args) {

        /*  1. Instantiation
         *
         *          1.1 Interface cannot instantiate Directly.
         * */

//        Naruto naruto = new Naruto();

        /*  2. Methods
         *
         *          2.1 All Methods in interface are implicitly abstract ( before java 8 ) .
         *          2.2 From Java  8 onwards,  interface can contain default methods ( with a body ) and static methods.
         *          2.3 All methods in interface are public by default.
         * */

        Naruto naruto = new Power();
        naruto.fourthHokage();
        naruto.power();

        /*  3. Fields
         *
         *          3.1 All fields is an interface are implicitly public , static , final ( constants ) .
         * */

        /*  4. Multiple Inheritance
         *
         *          4.1 A class can implement multiple interfaces ( multiple inheritance ) .
         * */

        Friends friends = new Friends();
        friends.sensai();
        friends.fourthHokage();

        /*  5.  Use Case
         *
         *          5.1 Use interfaces when you want to define contract that multiple classes can implement , regardless
         *              of their location in the class hierarchy.
         * */

    }

}
