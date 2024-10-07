package msp.test.learn.datastrcuture.CollectionInterface;

// Interfaces specify what a class must do and not how.
// It is the blueprint of the class, interface methods are abstract by default.

interface PaymentMethod{
    void pay();
}

class DebitCard implements PaymentMethod{
    @Override
    public void pay() {
        System.out.println("Paying Via Debit Card");
    }
}

class CreditCard implements PaymentMethod{
    @Override
    public void pay() {
        System.out.println("Paying Via Credit Card");
    }
}

class UPI implements PaymentMethod{
    @Override
    public void pay(){
        System.out.println("Paying Via UPI");
    }
}

class CASH {
    public void  pay(){
        System.out.println("Paying Via Cash");
    }
}

public class PaymentInterface {

    public static void payUsingDebitCard(PaymentMethod paymentMethod){
        paymentMethod.pay();
    }

    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard();

        creditCard.pay();

        System.out.println("OR");

        payUsingDebitCard(new DebitCard());


    }

}
