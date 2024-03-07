package org.prog.collections;

public class Car {
    public void turnToRight() {System.out.println("Car turn right");}

    public void turnToLeft() {System.out.println("Car turn left");}

    public void moveFront() {System.out.println("Car move front");}
}
 class Truck extends Car{

    public void getTrunk(){System.out.println("Truck get trunk");}

}
 class CargoTruck extends Truck {
    @java.lang.Override
    public void turnToRight() {
        System.out.println("Go front");
        super.turnToRight();
    }

    @java.lang.Override
    public void turnToLeft() {
        System.out.println("Go front");
        super.turnToLeft();
    }

}
 class Lorry extends CargoTruck{
    int passengers=0;
    public void getIn() {
        if (this.passengers < 25) {
            System.out.println("Yes, get in");
            this.passengers += 1;
        } else {
            System.out.println("Sorry, dont have space.");
        }
    }

}