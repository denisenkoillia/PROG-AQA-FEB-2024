package org.prog.collections;

import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.C;

public class  Car {

    CarColors carColor;
    CarOwner carOwner;
    Car(){}
    Car(CarColors c){
        this.carColor = c;
    } Car(CarOwner c){
        this.carOwner = c;
    }

    public void turnToRight() {System.out.println("Car turn right");}

    public void turnToLeft() {System.out.println("Car turn left");}

    public void moveFront() {System.out.println("Car move front");}
}


