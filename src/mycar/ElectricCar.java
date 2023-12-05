package mycar;

import java.util.Scanner;

public class ElectricCar extends Car {
    String subsidy;
    int distance;

    @Override
    public void read(Scanner scan) {
        super.read(scan);
        subsidy = scan.next();
        distance = scan.nextInt();
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("\t\t%s %d\n", subsidy, distance);
    }


}
