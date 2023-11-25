package mycar;

import java.util.Scanner;
import manager.Manageable;

public class Part implements Manageable {

    String code;
    String name;
    int price;
    int fixPrice;

    @Override
    public void read(Scanner scan) {
        code = scan.next();
        name = scan.next();
        price = scan.nextInt();
        fixPrice = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s %s %d %d\n", code, name, price, fixPrice);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(code)) {
            return true;
        }
        return false;
    }

}
