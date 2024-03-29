package org.prog.collections;

public class Lorry extends CargoTruck{
    int passengers=0;
    public void getIn() {
        if (this.passengers < 25) {
            System.out.println("Yes, get in");
            this.passengers += 1;
        } else {
            System.out.println("Sorry, dont have space");
        }
    }

}