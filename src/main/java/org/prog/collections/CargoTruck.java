package org.prog.collections;

public class CargoTruck extends Truck {
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

